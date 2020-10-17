package com.nsw.backend.mard.p01.repositories;


import com.nsw.backend.mard.p01.model.FilterForm;
import com.nsw.backend.mard.p01.model.FilterResult;
import com.nsw.backend.mard.p01.model.Tbdhoso01;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class Tbdhoso01RepositoryImpl implements Tbdhoso01RepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public FilterResult searchHoso(FilterForm filter) {
        //RESETTING PAGE TO ZERO
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tbdhoso01> cq = cb.createQuery(Tbdhoso01.class);
        Root<Tbdhoso01> root = cq.from(Tbdhoso01.class);
        List<Predicate> listPredicate = new ArrayList<>();
        if (!StringUtils.isEmpty(filter.getFiCompanyTaxCode())) {
            listPredicate.add(cb.equal(root.get("fiTaxCode"), filter.getFiCompanyTaxCode()));
        }
        listPredicate.add(cb.equal(root.get("fiActive"), filter.isFiActive()));
        // điều kiện cần
        if (!StringUtils.isEmpty(filter.getFiHSCode())) {
            listPredicate.add(cb.like(root.get("fiNSWFileCode"), String.format("%%%s%%", filter.getFiHSCode())));
        }

        if (filter.getFiHSStatus() != -1L && filter.getFiHSStatus() != null) {
            listPredicate.add(cb.equal(root.get("fiHSStatus"), filter.getFiHSStatus()));
        }

        if (filter.getSentStartDate() != null) {
            listPredicate.add(cb.greaterThanOrEqualTo(root.get("fiCreatedDate"), filter.getSentStartDate()));
        }
        if (filter.getSentEndDate() != null) {
            listPredicate.add(cb.lessThanOrEqualTo(root.get("fiCreatedDate"), filter.getSentEndDate()));
        }
        if (filter.isValidForLicenseQuery()) {
            if (filter.getFiLstNSWFileCode().isEmpty() == false) {
                listPredicate.add(root.get("fiNSWFileCode").in(filter.getFiLstNSWFileCode()));
            } else {
                listPredicate.add(cb.disjunction());
            }
        }

        Path<Object> sortBy = root.get(filter.getSortBy());
        Order order = (filter.getOrder().equals("asc")) ? cb.asc(sortBy) : cb.desc(sortBy);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        //Initialize Pagination
        TypedQuery<Tbdhoso01> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Tbdhoso01> countRoot = countQuery.from(Tbdhoso01.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        FilterResult filterResult = new FilterResult();
        filterResult.setTotal(count);
        filterResult.setSize(filter.getSize());
        filterResult.setPage(filter.getPage());
        List<Tbdhoso01> rawList = query.getResultList();
        filterResult.setData(rawList);
        return filterResult;
    }
}

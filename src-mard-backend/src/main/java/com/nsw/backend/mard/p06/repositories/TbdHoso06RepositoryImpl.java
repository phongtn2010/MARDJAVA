package com.nsw.backend.mard.p06.repositories;

import com.nsw.backend.mard.p06.model.FilterForm;
import com.nsw.backend.mard.p06.model.FilterResult;
import com.nsw.backend.mard.p06.model.TbdCongvan06;
import com.nsw.backend.mard.p06.model.TbdHoso06;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class TbdHoso06RepositoryImpl implements TbdHoso06RepositoryCustom {
    @Autowired
    TbdCongvan06Repository certRepo;
    @PersistenceContext
    private EntityManager em;

    @Override
    public FilterResult searchHoso(FilterForm filter) {
        //RESETTING PAGE TO ZERO
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbdHoso06> cq = cb.createQuery(TbdHoso06.class);
        Root<TbdHoso06> root = cq.from(TbdHoso06.class);
        List<Predicate> listPredicate = new ArrayList<>();
        if (!StringUtils.isEmpty(filter.getFiCompanyTaxCode())) {
                listPredicate.add(cb.equal(root.get("fiTaxCode"), filter.getFiCompanyTaxCode()));
        }
        listPredicate.add(cb.equal(root.get("fiActive"), filter.isFiActive()));
        if (!StringUtils.isEmpty(filter.getFiHSCode())) {
            listPredicate.add(cb.like(root.get("fiNSWFileCode"), String.format("%%%s%%", filter.getFiHSCode())));
        }
        if (filter.getFiHSStatus() != -1L) {
            listPredicate.add(cb.equal(root.get("fiHSStatus"), filter.getFiHSStatus()));
        }
        if (filter.getSentStartDate() != null) {
            listPredicate.add(cb.greaterThanOrEqualTo(root.get("fiHSCreatedDate"), filter.getSentStartDate()));
        }
        if (filter.getSentEndDate() != null) {
            listPredicate.add(cb.lessThanOrEqualTo(root.get("fiHSCreatedDate"), filter.getSentEndDate()));
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
        TypedQuery<TbdHoso06> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<TbdHoso06> countRoot = countQuery.from(TbdHoso06.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<TbdHoso06> result = query.getResultList();
        result.forEach(hs -> {
            TbdCongvan06 cert = certRepo.findFirstByFiNSWFileCodeAndFiDispatchTypeOrderByFiCreatedDateDesc(hs.getFiNSWFileCode(), 2);
            hs.setFiCertNo(cert == null ? "" : cert.getFiDispatchNo());
        });

        FilterResult filterResult = new FilterResult();
        filterResult.setTotal(count.intValue());
        filterResult.setSize(filter.getSize());
        filterResult.setPage(filter.getPage());
        filterResult.setData(result);
        return filterResult;
    }
}

package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.FilterForm;
import com.nsw.backend.mard.p25.model.FilterResult;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class TbdHoso25RepositoryImpl implements TbdHoso25RepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public FilterResult searchHoso(FilterForm filter){
        //RESETTING PAGE TO ZERO
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbdHoso25> cq = cb.createQuery(TbdHoso25.class);
        Root<TbdHoso25> root = cq.from(TbdHoso25.class);
        Join<TbdHoso25, TbdHanghoa25> hanghoa25Join = root.join("fiProductList", JoinType.INNER);
        List<Predicate> listPredicate = new ArrayList<>();
//        if (!StringUtils.isEmpty(filter.getFiCertNo())) {
//            listPredicate.add(cb.equal(root.get("fiCertNo"), filter.getFiCertNo()));
//        }
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
        if (filter.getFiProName() != null) {
            listPredicate.add(cb.like(hanghoa25Join.get("fiProName"), String.format("%%%s%%", filter.getFiProName())));
        }
        if (filter.getFiProCountryName() != null) {
            listPredicate.add(cb.like(hanghoa25Join.get("fiProCountryName"), String.format("%%%s%%", filter.getFiProCountryName())));
        }
        if (filter.getFiProMadeIn() != null) {
            listPredicate.add(cb.like(hanghoa25Join.get("fiProMadeIn"), String.format("%%%s%%", filter.getFiProMadeIn())));
        }
        if (filter.getFiHSType() != null) {
            listPredicate.add(cb.lessThanOrEqualTo(root.get("fiHSType"), filter.getFiHSType()));
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
        TypedQuery<TbdHoso25> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<TbdHoso25> countRoot = countQuery.from(TbdHoso25.class);
        Join<TbdHoso25, TbdHanghoa25> tesst = countRoot.join("fiProductList", JoinType.INNER);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<TbdHoso25> result = query.getResultList();
        result.forEach(hs ->{

        });

        FilterResult filterResult = new FilterResult();
        filterResult.setTotal(count.intValue());
        filterResult.setSize(filter.getSize());
        filterResult.setPage(filter.getPage());
        filterResult.setData(result);
        return filterResult;
    }
}

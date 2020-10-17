/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.repositories;

import com.nsw.backend.mard.p08.model.FilterForm;
import com.nsw.backend.mard.p08.model.FilterResult;
import com.nsw.backend.mard.p08.model.Tbdhoso08;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class Tbdhoso08RepositoryImpl implements Tbdhoso08RepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public FilterResult searchHoso(FilterForm filter) {
        //RESETTING PAGE TO ZERO
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tbdhoso08> cq = cb.createQuery(Tbdhoso08.class);
        Root<Tbdhoso08> root = cq.from(Tbdhoso08.class);
        List<Predicate> listPredicate = new ArrayList<>();
        if (!StringUtils.isEmpty(filter.getFiCompanyTaxCode())) {
            listPredicate.add(cb.equal(root.get("fiTaxCode"), filter.getFiCompanyTaxCode()));
        }
        listPredicate.add(cb.equal(root.get("fiActive"), filter.isFiActive()));
        if (!StringUtils.isEmpty(filter.getFiHSCode())) {
            listPredicate.add(cb.like(root.get("fiHSCode"), String.format("%%%s%%", filter.getFiHSCode())));
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
                listPredicate.add(root.get("fiHSCode").in(filter.getFiLstNSWFileCode()));
            } else {
                listPredicate.add(cb.disjunction());
            }
        }

        Path<Object> sortBy = root.get(filter.getSortBy());
        Order order = (filter.getOrder().equals("asc")) ? cb.asc(sortBy) : cb.desc(sortBy);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        //Initialize Pagination
        TypedQuery<Tbdhoso08> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Tbdhoso08> countRoot = countQuery.from(Tbdhoso08.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        FilterResult filterResult = new FilterResult();
        filterResult.setTotal(count);
        filterResult.setSize(filter.getSize());
        filterResult.setPage(filter.getPage());
        List<Tbdhoso08> rawList = query.getResultList();
        filterResult.setData(rawList);
        return filterResult;
    }
}

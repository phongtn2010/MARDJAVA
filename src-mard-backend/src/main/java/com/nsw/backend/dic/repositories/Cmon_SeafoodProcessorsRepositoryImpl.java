package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonSeafoodprocessors;
import com.nsw.backend.dic.model.FilterFormCmonSF;
import com.nsw.backend.dic.model.FilterResult_CmonSeafood;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class Cmon_SeafoodProcessorsRepositoryImpl implements Cmon_SeafoodProcessorsRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    @Override
    public FilterResult_CmonSeafood searchCmonSeafood(FilterFormCmonSF filter) {
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CmonSeafoodprocessors> cq = cb.createQuery(CmonSeafoodprocessors.class);
        Root<CmonSeafoodprocessors> root = cq.from(CmonSeafoodprocessors.class);
        List<Predicate> listPredicate = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getMacssx())) {
            listPredicate.add(cb.like(root.get("seafoodprocessorscode"), String.format("%%%s%%", filter.getMacssx())));
        }
        if (!StringUtils.isEmpty(filter.getTencssx())) {
            listPredicate.add(cb.like(root.get("seafoodprocessorsname"), String.format("%%%s%%", filter.getTencssx())));
        }

        Path<Object> sortBy = root.get(filter.getSortBy());
        Order order = (filter.getOrder().equals("asc")) ? cb.asc(sortBy) : cb.desc(sortBy);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        TypedQuery<CmonSeafoodprocessors> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<CmonSeafoodprocessors> countRoot = countQuery.from(CmonSeafoodprocessors.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<CmonSeafoodprocessors> result = query.getResultList();
        FilterResult_CmonSeafood result_cmonSeafood = new FilterResult_CmonSeafood();
        result_cmonSeafood.setTotal(count.intValue());
        result_cmonSeafood.setPage(filter.getPage());
        result_cmonSeafood.setSize(filter.getSize());

        result_cmonSeafood.setData(result);
        return result_cmonSeafood;
    }
}

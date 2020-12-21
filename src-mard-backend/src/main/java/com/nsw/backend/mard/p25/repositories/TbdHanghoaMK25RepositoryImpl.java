package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.dto.FilterFormHangHoaMK25;
import com.nsw.backend.mard.p25.dto.FilterResultHangHoaMK25;
import com.nsw.backend.mard.p25.model.TbdHanghoaMK25;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class TbdHanghoaMK25RepositoryImpl implements TbdHanghoaMK25RepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    @Override
    public FilterResultHangHoaMK25 searchHanghoaMK25(FilterFormHangHoaMK25 filter) {
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbdHanghoaMK25> cq = cb.createQuery(TbdHanghoaMK25.class);
        Root<TbdHanghoaMK25> root = cq.from(TbdHanghoaMK25.class);
        List<Predicate> listPredicate = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getTaxCode())) {
            listPredicate.add(cb.like(root.get("fiTaxCode"), String.format("%%%s%%", filter.getTaxCode())));
        }
        listPredicate.add(cb.equal(root.get("fiActive"), Boolean.TRUE));
        Path<Object> sortByAsc = root.get(filter.getSortBy());
        Path<Object> sortByDesc = root.get(filter.getFiOrder());
//        Order order = (filter.getOrder().equals("asc")) ? cb.asc(sortBy) : cb.desc(sortBy);

        List<Order> orderList = new ArrayList();
        Order orderAsc = cb.asc(sortByAsc);
        Order orderDesc = cb.desc(sortByDesc);
        orderList.add(orderAsc);
        orderList.add(orderDesc);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        //Initialize Pagination
        TypedQuery<TbdHanghoaMK25> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(orderList));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
//        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<TbdHanghoaMK25> countRoot = countQuery.from(TbdHanghoaMK25.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<TbdHanghoaMK25> result = query.getResultList();
        FilterResultHangHoaMK25 filterResultHH = new FilterResultHangHoaMK25();
        filterResultHH.setTotal(count.intValue());
        filterResultHH.setSize(filter.getSize());
        filterResultHH.setPage(filter.getPage());
        filterResultHH.setListTbdHanghoaMK25(result);
        return filterResultHH;
    }
}

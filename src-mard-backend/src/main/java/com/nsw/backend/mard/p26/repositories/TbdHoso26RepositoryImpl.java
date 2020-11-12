package com.nsw.backend.mard.p26.repositories;

import com.nsw.backend.mard.p26.model.TbdHanghoa26;
import com.nsw.backend.mard.p26.model.TbdHoso26;
import com.nsw.backend.mard.p26.model.FilterForm;
import com.nsw.backend.mard.p26.model.FilterResult;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class TbdHoso26RepositoryImpl implements TbdHoso26RepositoryCustom{
    @PersistenceContext
    private EntityManager em;
    @Override
    public FilterResult searchHoso(FilterForm filter) {
        //RESETTING PAGE TO ZERO
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbdHoso26> cq = cb.createQuery(TbdHoso26.class);
        Root<TbdHoso26> root = cq.from(TbdHoso26.class);
        List<Predicate> listPredicate = new ArrayList<>();
//        if (!StringUtils.isEmpty(filter.getFiCertNo())) {
//            listPredicate.add(cb.equal(root.get("fiCertNo"), filter.getFiCertNo()));
//        }
        if (!StringUtils.isEmpty(filter.getMaHoSo())) {
            listPredicate.add(cb.like(root.get("fiMaHoso"), String.format("%%%s%%", filter.getMaHoSo())));
        }
        if (filter.isHoatDong()) {
            listPredicate.add(cb.equal(root.get("fiActive"), filter.isHoatDong()));
        }
        if (filter.getTrangThaiHoSo() != null) {
            listPredicate.add(cb.equal(root.get("fiTrangthai"), filter.getTrangThaiHoSo()));
        }
        if (filter.getMaSoThue() != null) {
            listPredicate.add(cb.equal(root.get("fiMasothue"), filter.getMaSoThue()));
        }
        if (filter.getNgayTaoTuNgay() != null) {
            listPredicate.add(cb.greaterThanOrEqualTo(root.get("fiNgaytao"), filter.getNgayTaoTuNgay()));
        }
        if (filter.getNgayTaoDenNgay() != null) {
            listPredicate.add(cb.lessThanOrEqualTo(root.get("fiNgaytao"), filter.getNgayTaoDenNgay()));
        }

        Path<Object> sortBy = root.get(filter.getSortBy());
        Order order = (filter.getOrder().equals("asc")) ? cb.asc(sortBy) : cb.desc(sortBy);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        //Initialize Pagination
        TypedQuery<TbdHoso26> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<TbdHoso26> countRoot = countQuery.from(TbdHoso26.class);
        Join<TbdHoso26, TbdHanghoa26> tesst = countRoot.join("fiProductList", JoinType.INNER);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<TbdHoso26> result = query.getResultList();

        FilterResult filterResult = new FilterResult();
        filterResult.setTotal(count.intValue());
        filterResult.setSize(filter.getSize());
        filterResult.setPage(filter.getPage());
        filterResult.setData(result);
        return filterResult;
    }
}

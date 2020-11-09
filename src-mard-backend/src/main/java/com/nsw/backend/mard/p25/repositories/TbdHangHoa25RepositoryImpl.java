package com.nsw.backend.mard.p25.repositories;
import com.nsw.backend.mard.p25.model.FilterHangHoa;
import com.nsw.backend.mard.p25.model.FilterResult;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdHoso25;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class TbdHangHoa25RepositoryImpl implements TbdHangHoa25RepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public FilterResult searchHangHoa(FilterHangHoa filterHangHoa){
        //RESETTING PAGE TO ZERO
        filterHangHoa.setPage(filterHangHoa.getPage() == 0 ? 0 : filterHangHoa.getPage() - 1);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbdHoso25> cq = cb.createQuery(TbdHoso25.class);
        Root<TbdHoso25> root = cq.from(TbdHoso25.class);
        Join<TbdHoso25, TbdHanghoa25> hanghoa25Join = root.join("fiProductList", JoinType.INNER);
        List<Predicate> listPredicate = new ArrayList<>();
        if (filterHangHoa.getFiProName() != null) {
            listPredicate.add(cb.like(hanghoa25Join.get("fiProName"), String.format("%%%s%%", filterHangHoa.getFiProName())));
        }
        if (filterHangHoa.getFiHSStatus() != -1L) {
            listPredicate.add(cb.equal(root.get("fiHSStatus"), filterHangHoa.getFiHSStatus()));
        }
        Path<Object> sortBy = root.get(filterHangHoa.getSortBy());
        Order order = (filterHangHoa.getOrder().equals("asc")) ? cb.asc(sortBy) : cb.desc(sortBy);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        //Initialize Pagination
        TypedQuery<TbdHoso25> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filterHangHoa.getSize());
        query.setFirstResult(filterHangHoa.getPage() * filterHangHoa.getSize());

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
        filterResult.setSize(filterHangHoa.getSize());
        filterResult.setPage(filterHangHoa.getPage());
        filterResult.setData(result);
        return filterResult;
    }
}

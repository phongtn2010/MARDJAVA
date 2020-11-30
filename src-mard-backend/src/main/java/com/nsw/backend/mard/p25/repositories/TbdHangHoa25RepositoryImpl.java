package com.nsw.backend.mard.p25.repositories;
import com.nsw.backend.mard.p25.model.*;
import org.springframework.util.StringUtils;


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
    public FilterResultHH searchHangHoa(FilterHangHoa filterHangHoa){
        //RESETTING PAGE TO ZERO
        filterHangHoa.setPage(filterHangHoa.getPage() == 0 ? 0 : filterHangHoa.getPage() - 1);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbdHanghoa25> cq = cb.createQuery(TbdHanghoa25.class);
        Root<TbdHanghoa25> root = cq.from(TbdHanghoa25.class);
//        Join<TbdHoso25, TbdHanghoa25> hanghoa25Join = root.join("fiProductList", JoinType.INNER);
        List<Predicate> listPredicate = new ArrayList<>();
        if (filterHangHoa.getFiIdHS() != null) {
            listPredicate.add(cb.equal(root.get("fiIdHS"), filterHangHoa.getFiIdHS()));
        }
        if (!StringUtils.isEmpty(filterHangHoa.getFiProName())) {
            listPredicate.add(cb.like(root.get("fiProName"), String.format("%%%s%%", filterHangHoa.getFiProName())));
        }
        if (filterHangHoa.getFiTrangThaiHangHoa() != null) {
            listPredicate.add(cb.equal(root.get("fiTrangThaiHangHoa"), filterHangHoa.getFiTrangThaiHangHoa()));
        }
        Path<Object> sortBy = root.get(filterHangHoa.getSortBy());
        Order order = (filterHangHoa.getOrder().equals("asc")) ? cb.asc(sortBy) : cb.desc(sortBy);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        //Initialize Pagination
        TypedQuery<TbdHanghoa25> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filterHangHoa.getSize());
        query.setFirstResult(filterHangHoa.getPage() * filterHangHoa.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
//        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<TbdHanghoa25> countRoot = countQuery.from(TbdHanghoa25.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<TbdHanghoa25> result = query.getResultList();
        result.forEach(hs ->{

        });

        FilterResultHH filterResultHH = new FilterResultHH();
        filterResultHH.setTotal(count.intValue());
        filterResultHH.setSize(filterHangHoa.getSize());
        filterResultHH.setPage(filterHangHoa.getPage());
        filterResultHH.setFiHSStatus(filterHangHoa.getFiTrangThaiHangHoa());
        filterResultHH.setData(result);
        return filterResultHH;
    }
}

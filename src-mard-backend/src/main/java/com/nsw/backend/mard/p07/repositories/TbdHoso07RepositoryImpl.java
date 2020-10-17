package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.FilterForm;
import com.nsw.backend.mard.p07.model.FilterResult;
import com.nsw.backend.mard.p07.model.TbdCvCnkd07;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class TbdHoso07RepositoryImpl implements TbdHoso07RepositoryCustom {
    @Autowired
    TbdGiayCNKD07Repository certRepo;
    @PersistenceContext
    private EntityManager em;

    @Override
    public FilterResult searchHoso(FilterForm filter) {
        //RESETTING PAGE TO ZERO
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbdHoso07> cq = cb.createQuery(TbdHoso07.class);
        Root<TbdHoso07> root = cq.from(TbdHoso07.class);
        List<Predicate> listPredicate = new ArrayList<>();
        if (!StringUtils.isEmpty(filter.getFiCompanyTaxCode())) {
            listPredicate.add(cb.equal(root.get("fiTaxCode"), filter.getFiCompanyTaxCode()));
        }
        listPredicate.add(cb.equal(root.get("fiActive"), filter.isFiActive()));
        if (!StringUtils.isEmpty(filter.getFiHSCode())) {
            listPredicate.add(cb.like(root.get("fiNSWFileCode"), String.format("%%%s%%", filter.getFiHSCode())));
        }
        if (!StringUtils.isEmpty(filter.getFiDepartmentofMonitorCode())) {
            listPredicate.add(cb.equal(root.get("fiDepartmentofMonitorCode"), filter.getFiDepartmentofMonitorCode()));
        }
        if (!StringUtils.isEmpty(filter.getFiDepartmentofQuarantineCode())) {
            listPredicate.add(cb.equal(root.get("fiDepartmentofQuarantineCode"), filter.getFiDepartmentofQuarantineCode()));
        }
        if (filter.getFiHSStatus() != -1L) {
            listPredicate.add(cb.equal(root.get("fiHSStatus"), filter.getFiHSStatus()));
        }
        if (filter.getFiKDStatus() != -1L) {
            listPredicate.add(cb.equal(root.get("fiKDStatus"), filter.getFiKDStatus()));
        }
        if (filter.getFiGSStatus() != -1L) {
            listPredicate.add(cb.equal(root.get("fiGSStatus"), filter.getFiGSStatus()));
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
        TypedQuery<TbdHoso07> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<TbdHoso07> countRoot = countQuery.from(TbdHoso07.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<TbdHoso07> result = query.getResultList();
        result.forEach(hs -> {
            List<TbdCvCnkd07> certList = certRepo.findAllByFiNSWFileCodeOrderByFiIdCVDesc(hs.getFiNSWFileCode());
            hs.setFiCertNo(CollectionUtils.isEmpty(certList) ? "" : certList.get(0).getFiCertificateNo());
        });

        FilterResult filterResult = new FilterResult();
        filterResult.setTotal(count.intValue());
        filterResult.setSize(filter.getSize());
        filterResult.setPage(filter.getPage());
        filterResult.setData(result);
        return filterResult;
    }
}

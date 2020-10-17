package com.nsw.backend.mard.p09.repositories;


import com.nsw.backend.mard.p09.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class Tbdhoso09RepositoryImpl implements Tbdhoso09RepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    TbdGiayXNCL09Repository qualityCertRepo;

    @Autowired
    TbdGiayCNKD09Repository quarantineCertRepo;

    @Override
    public FilterResult searchHoso(FilterForm filter) {
        //RESETTING PAGE TO ZERO
        filter.setPage(filter.getPage() == 0 ? 0 : filter.getPage() - 1);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tbdhoso09> cq = cb.createQuery(Tbdhoso09.class);
        Root<Tbdhoso09> root = cq.from(Tbdhoso09.class);
        List<Predicate> listPredicate = new ArrayList<>();
        if (!StringUtils.isEmpty(filter.getFiCompanyTaxCode())) {
            listPredicate.add(cb.equal(root.get("fiTaxCode"), filter.getFiCompanyTaxCode()));
        }
        listPredicate.add(cb.equal(root.get("fiActive"), filter.isFiActive()));
        if (!StringUtils.isEmpty(filter.getFiHSCode())) {
            listPredicate.add(cb.like(root.get("fiHSCode"), String.format("%%%s%%", filter.getFiHSCode())));
        }
        if (filter.getFiHSStatus() != -1L && filter.getFiHSStatus() != null) {
            listPredicate.add(cb.equal(root.get("fiHSStatus"), filter.getFiHSStatus()));
        }
        if (!StringUtils.isEmpty(filter.getFiMonitoringDepartmentCode())) {
            listPredicate.add(cb.equal(root.get("fiMonitoringDepartmentCode"), filter.getFiMonitoringDepartmentCode()));
        }
        if (!StringUtils.isEmpty(filter.getFiQuarantineDepartmentCode())) {
            listPredicate.add(cb.equal(root.get("fiQuarantineDepartmentCode"), filter.getFiQuarantineDepartmentCode()));
        }
        if (filter.getFiGSStatus() != -1L && filter.getFiGSStatus() != null) {
            listPredicate.add(cb.equal(root.get("fiGSStatus"), filter.getFiGSStatus()));
        }
        if (filter.getFiKDStatus() != -1L && filter.getFiKDStatus() != null) {
            listPredicate.add(cb.equal(root.get("fiKDStatus"), filter.getFiKDStatus()));
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
        Order order = ("asc".equals(filter.getOrder())) ? cb.asc(sortBy) : cb.desc(sortBy);
        Predicate[] finalPredicate = new Predicate[listPredicate.size()];
        listPredicate.toArray(finalPredicate);

        //Initialize Pagination
        TypedQuery<Tbdhoso09> query = em.createQuery(cq.select(root).where(cb.and(finalPredicate)).orderBy(order));
        query.setMaxResults(filter.getSize());
        query.setFirstResult(filter.getPage() * filter.getSize());

        //Get all count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Tbdhoso09> countRoot = countQuery.from(Tbdhoso09.class);
        Long count = em.createQuery(countQuery.select(cb.count(countRoot)).where(cb.and(finalPredicate))).getSingleResult();

        List<Tbdhoso09> result = query.getResultList();
        result.forEach(hs -> {
            List<Tbdgiayxncl09> qualityCertList = qualityCertRepo.findAllByFiNSWFileCodeOrderByFiIdQualityCerDesc(hs.getFiHSCode());
            List<Tbdgiaycnkd09> quarantineCertList = quarantineCertRepo.findAllByFiNSWFileCodeOrderByFiIdQuarantineCerDesc(hs.getFiHSCode());
            String certNo = "";
            if(CollectionUtils.isNotEmpty(qualityCertList)){
                certNo = qualityCertList.get(0).getFiQuanlityCerNo();
            }
            else if (CollectionUtils.isNotEmpty(quarantineCertList)){
                certNo = quarantineCertList.get(0).getFiCertificateNo();
            }
            hs.setFiCertNo(certNo);
        });

        FilterResult filterResult = new FilterResult();
        filterResult.setTotal(count);
        filterResult.setSize(filter.getSize());
        filterResult.setPage(filter.getPage());
        filterResult.setData(result);
        return filterResult;
    }
}

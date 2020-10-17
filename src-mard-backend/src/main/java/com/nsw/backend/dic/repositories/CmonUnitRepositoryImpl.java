/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonUnit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CmonUnitRepositoryImpl implements CmonUnitRepositoryCustom {

    private static final Logger LOG = LoggerFactory.getLogger(CmonUnitRepositoryImpl.class);
    private static final String TAG = "CmonUnitRepositoryImpl";

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CmonUnit> findByUnittypeid(Long unittypeid) {
        try {
            if (unittypeid == null) {
                return new ArrayList<>();
            }
            Query query = em.createQuery("SELECT a FROM CmonUnit a "
                    + " WHERE a.unittypeid = ?1 ORDER BY a.unitname");
            query.setParameter(1, unittypeid);

            List<CmonUnit> lst = query.getResultList();
            return lst;
        } catch (Exception ex) {
            LOG.error(TAG + "findByUnitTypeId::", ex);
            return null;
        }
    }

    @Override
    public List<CmonUnit> findByUnittypeidAndSystemid(Long unittypeid, Long systemid) {
        try {
            if (unittypeid == null) {
                return new ArrayList<>();
            }
            Query query = em.createQuery("SELECT a FROM CmonUnit a "
                    + " WHERE a.unittypeid = ?1 AND a.systemid = ?2 ORDER BY a.unitname");
            query.setParameter(1, unittypeid);
            query.setParameter(2, systemid);
            
            List<CmonUnit> lst = query.getResultList();
            return lst;
        } catch (Exception ex) {
            LOG.error(TAG + "findByUnittypeidAndSystemid::", ex);
            return null;
        }
    }

}

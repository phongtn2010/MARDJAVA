/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonPort;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CmonPortRepositoryImpl implements CmonPortRepositoryCustom {

    private static final Logger LOG = LoggerFactory.getLogger(CmonPortRepositoryImpl.class);
    private static final String TAG = "CmonPortRepositoryIpml";

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CmonPort> findByStatecode(String statecode) {
        try {
            if (statecode == null || statecode.isEmpty()) {
                return new ArrayList<>();
            }
            Query query = em.createQuery("SELECT a FROM CmonPort a "
                    + " WHERE a.statecode = ?1 ORDER BY a.portname");
            query.setParameter(1, statecode);

            List<CmonPort> lst = query.getResultList();
            return lst;
        } catch (Exception ex) {
            LOG.error(TAG + "findPortByCountryCode::", ex);
            return null;
        }
    }

    @Override
    public List<CmonPort> findWithOutCountryCode(String statecode) {
        try {
            if (statecode == null || statecode.isEmpty()) {
                return new ArrayList<>();
            }
            Query query = em.createQuery("SELECT a FROM CmonPort a "
                    + " WHERE a.statecode != ?1 ORDER BY a.statecode, a.portname ");
            query.setParameter(1, statecode);

            List<CmonPort> lst = query.getResultList();
            return lst;
        } catch (Exception ex) {
            LOG.error(TAG + "findWithOutCountryCode::", ex);
            return null;
        }
    }
}

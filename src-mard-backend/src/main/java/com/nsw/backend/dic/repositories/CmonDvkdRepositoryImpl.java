
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonDvkd;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phongnv
 */
public class CmonDvkdRepositoryImpl implements CmonDvkdRepositoryCustom {    
    private static final Logger LOG = LoggerFactory.getLogger(CmonDvkdRepositoryImpl.class);
    private static final String TAG = "CmonAttachtypeRepositoryImpl";

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<CmonDvkd> findBySystemId(Long systemId){
        try {
            if (systemId == null) {
                return new ArrayList<>();
            }
            Query query = em.createQuery("SELECT a FROM CmonDvkd a "
                    + " WHERE a.systemID = ?0 ORDER BY a.orderID");
            query.setParameter(0, systemId);

            List<CmonDvkd> lst = query.getResultList();
            return lst;
        } catch (Exception ex) {
            LOG.error(TAG + "findBySystemId::", ex);
            return null;
        }
    }
}

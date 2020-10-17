
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonAttachtype;
import com.nsw.backend.dic.model.CmonUnit;
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
public class CmonAttachtypeRepositoryImpl implements CmonAttachtypeRepositoryCustom {    
    private static final Logger LOG = LoggerFactory.getLogger(CmonAttachtypeRepositoryImpl.class);
    private static final String TAG = "CmonAttachtypeRepositoryImpl";

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<CmonAttachtype> findBySystemId(Long systemId){
        try {
            if (systemId == null) {
                return new ArrayList<>();
            }
            Query query = em.createQuery("SELECT a FROM CmonAttachtype a "
                    + " WHERE a.systemid = ?0 ORDER BY a.attachtypecode");
            query.setParameter(0, systemId);

            List<CmonAttachtype> lst = query.getResultList();
            return lst;
        } catch (Exception ex) {
            LOG.error(TAG + "findBySystemId::", ex);
            return null;
        }
    }
}

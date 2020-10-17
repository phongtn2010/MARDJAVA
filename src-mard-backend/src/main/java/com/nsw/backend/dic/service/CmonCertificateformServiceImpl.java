/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonCertificateform;
import com.nsw.backend.dic.repositories.CmonCertificateformRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonCertificateformService")
@Transactional
public class CmonCertificateformServiceImpl implements CmonCertificateformService {
    
    public static final Logger logger = LoggerFactory.getLogger(CmonCertificateformServiceImpl.class);
    
    @Autowired
    private CmonCertificateformRepository cmonCertificateformRepository;

    @Override
    public CmonCertificateform findById(Long id) {
        return cmonCertificateformRepository.findOne(id);
    }

    @Override
    public List<CmonCertificateform> findAll() {
        return cmonCertificateformRepository.findAll();
    }

    @Override
    public CmonCertificateform save(CmonCertificateform entity) {
        return cmonCertificateformRepository.save(entity);
    }

    @Override
    public CmonCertificateform update(CmonCertificateform entity) {
        return cmonCertificateformRepository.save(entity);
    }

    @Override
    public CmonCertificateform create(CmonCertificateform entity) {
        return cmonCertificateformRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonCertificateformRepository.delete(id);
    }
    
}

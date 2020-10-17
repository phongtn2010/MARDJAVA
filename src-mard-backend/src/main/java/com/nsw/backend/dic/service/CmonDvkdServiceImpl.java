/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonDvkd;
import com.nsw.backend.dic.repositories.CmonDvkdRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonDvkdService")
@Transactional
public class CmonDvkdServiceImpl implements CmonDvkdService {
    
    public static final Logger logger = LoggerFactory.getLogger(CmonDvkdServiceImpl.class);
    
    @Autowired
    private CmonDvkdRepository cmonAttachtypeRepository;

    @Override
    public CmonDvkd findById(Long id) {
        return cmonAttachtypeRepository.findOne(id);
    }

    @Override
    public List<CmonDvkd> findAll() {
        return cmonAttachtypeRepository.findAll();
    }

    @Override
    public CmonDvkd save(CmonDvkd entity) {
        return cmonAttachtypeRepository.save(entity);
    }

    @Override
    public CmonDvkd update(CmonDvkd entity) {
        return cmonAttachtypeRepository.save(entity);
    }

    @Override
    public CmonDvkd create(CmonDvkd entity) {
        return cmonAttachtypeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonAttachtypeRepository.delete(id);
    }

    @Override
    public List<CmonDvkd> findBySystemId(Long systemId) {
        return cmonAttachtypeRepository.findBySystemId(systemId);
    }
    
}

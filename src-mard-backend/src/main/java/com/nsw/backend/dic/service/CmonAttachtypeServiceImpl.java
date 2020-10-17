/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonAttachmentTypePhase2;
import com.nsw.backend.dic.model.CmonAttachtype;
import com.nsw.backend.dic.repositories.CmonAtchPhs2Repository;
import com.nsw.backend.dic.repositories.CmonAttachtypeRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonAttachtypeService")
@Transactional
public class CmonAttachtypeServiceImpl implements CmonAttachtypeService {
    
    public static final Logger logger = LoggerFactory.getLogger(CmonAttachtypeServiceImpl.class);
    
    @Autowired
    private CmonAttachtypeRepository cmonAttachtypeRepository;

    @Autowired
    private CmonAtchPhs2Repository cmonAtchPhs2Repository;
    @Override
    public CmonAttachtype findById(Long id) {
        return cmonAttachtypeRepository.findOne(id);
    }

    @Override
    public List<CmonAttachtype> findAll() {
        return cmonAttachtypeRepository.findAll();
    }

    @Override
    public CmonAttachtype save(CmonAttachtype entity) {
        return cmonAttachtypeRepository.save(entity);
    }

    @Override
    public CmonAttachtype update(CmonAttachtype entity) {
        return cmonAttachtypeRepository.save(entity);
    }

    @Override
    public CmonAttachtype create(CmonAttachtype entity) {
        return cmonAttachtypeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonAttachtypeRepository.delete(id);
    }

    @Override
    public List<CmonAttachtype> findBySystemId(Long systemId) {
        return cmonAttachtypeRepository.findBySystemId(systemId);
    }

    @Override
    public List<CmonAttachmentTypePhase2> findBySystemIdPhase2(Long systemId) {
        return cmonAtchPhs2Repository.findAllBySystemIdOrderByRequiredDesc(systemId);
    }

    @Override
    public List<CmonAttachmentTypePhase2> findBySystemIdTemplateTypePhase2(Long systemId, String templateType) {
        return cmonAtchPhs2Repository.findAllBySystemIdAndTemplateTypeOrderByRequiredDesc(systemId, templateType);
    }

}

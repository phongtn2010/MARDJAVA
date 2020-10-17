/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonPurpose;
import com.nsw.backend.dic.repositories.CmonPurposeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonPurposeService")
@Transactional
public class CmonPurposeServiceImpl implements CmonPurposeService {

    @Autowired
    CmonPurposeRepository cmonPurposeRepository;

    @Override
    public CmonPurpose findById(Long id) {
        return cmonPurposeRepository.findOne(id);
    }

    @Override
    public List<CmonPurpose> findAll() {
        return cmonPurposeRepository.findAll();
    }

    @Override
    public CmonPurpose save(CmonPurpose entity) {
        return cmonPurposeRepository.save(entity);
    }

    @Override
    public CmonPurpose update(CmonPurpose entity) {
        return cmonPurposeRepository.save(entity);
    }

    @Override
    public CmonPurpose create(CmonPurpose entity) {
        return cmonPurposeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonPurposeRepository.delete(id);
    }

}

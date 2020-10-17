/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonPaymenttype;
import com.nsw.backend.dic.repositories.CmonPaymenttypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonPaymenttypeService")
@Transactional
public class CmonPaymenttypeServiceImpl implements CmonPaymenttypeService {

    @Autowired
    CmonPaymenttypeRepository cmonPaymenttypeRepository;
    
    @Override
    public CmonPaymenttype findById(Long id) {
        return cmonPaymenttypeRepository.findOne(id);
    }

    @Override
    public List<CmonPaymenttype> findAll() {
        return cmonPaymenttypeRepository.findAll();
    }

    @Override
    public CmonPaymenttype save(CmonPaymenttype entity) {
        return cmonPaymenttypeRepository.save(entity);
    }

    @Override
    public CmonPaymenttype update(CmonPaymenttype entity) {
        return cmonPaymenttypeRepository.save(entity);
    }

    @Override
    public CmonPaymenttype create(CmonPaymenttype entity) {
        return cmonPaymenttypeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonPaymenttypeRepository.delete(id);
    }
    
}

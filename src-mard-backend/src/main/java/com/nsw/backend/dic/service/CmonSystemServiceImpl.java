/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonSystem;
import com.nsw.backend.dic.repositories.CmonSystemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonSystemService")
@Transactional
public class CmonSystemServiceImpl implements CmonSystemService {
    
    @Autowired
    CmonSystemRepository systemRepository;

    @Override
    public CmonSystem findById(Long id) {
        return systemRepository.findOne(id);
    }

    @Override
    public List<CmonSystem> findAll() {
        return systemRepository.findAll();
    }

    @Override
    public CmonSystem save(CmonSystem entity) {
        return systemRepository.save(entity);
    }

    @Override
    public CmonSystem update(CmonSystem entity) {
        return systemRepository.save(entity);
    }

    @Override
    public CmonSystem create(CmonSystem entity) {
        return systemRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        systemRepository.delete(id);
    }
    
}

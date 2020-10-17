/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonGood;
import com.nsw.backend.dic.repositories.CmonGoodRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonGoodService")
@Transactional
public class CmonGoodServiceImpl implements CmonGoodService {
    
    @Autowired
    CmonGoodRepository cmonGoodRepository;
    
    @Override
    public CmonGood findById(Long id) {
        return cmonGoodRepository.findOne(id);
    }
    
    @Override
    public List<CmonGood> findAll() {
        return cmonGoodRepository.findAll();
    }
    
    @Override
    public CmonGood save(CmonGood entity) {
        return cmonGoodRepository.save(entity);
    }
    
    @Override
    public CmonGood update(CmonGood entity) {
        return cmonGoodRepository.save(entity);
    }
    
    @Override
    public CmonGood create(CmonGood entity) {
        return cmonGoodRepository.save(entity);
    }
    
    @Override
    public void delete(Long id) {
        cmonGoodRepository.delete(id);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonUnittype;
import com.nsw.backend.dic.repositories.CmonUnittypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cmonUnittypeService")
public class CmonUnittypeServiceImpl implements CmonUnittypeService {
    
    @Autowired
    CmonUnittypeRepository unittypeRepository;
    
    @Override
    public CmonUnittype findById(Long id) {
        return unittypeRepository.findOne(id);
    }
    
    @Override
    public List<CmonUnittype> findAll() {
        return unittypeRepository.findAll();
    }
    
    @Override
    public CmonUnittype save(CmonUnittype entity) {
        return unittypeRepository.save(entity);
    }
    
    @Override
    public CmonUnittype update(CmonUnittype entity) {
        return unittypeRepository.save(entity);
    }
    
    @Override
    public CmonUnittype create(CmonUnittype entity) {
        return unittypeRepository.save(entity);
    }
    
    @Override
    public void delete(Long id) {
        unittypeRepository.delete(id);
    }
    
}

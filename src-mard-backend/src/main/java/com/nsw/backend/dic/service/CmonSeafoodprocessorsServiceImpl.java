/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonSeafoodprocessors;
import com.nsw.backend.dic.model.FilterFormCmonSF;
import com.nsw.backend.dic.model.FilterResult_CmonSeafood;
import com.nsw.backend.dic.repositories.CmonSeafoodprocessorsRepository;
import java.util.List;

import com.nsw.backend.dic.repositories.Cmon_SeafoodProcessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonSeafoodprocessorsService")
@Transactional
public class CmonSeafoodprocessorsServiceImpl implements CmonSeafoodprocessorsService {
    
    @Autowired
    CmonSeafoodprocessorsRepository seafoodprocessorsRepository;

    @Autowired
    Cmon_SeafoodProcessorsRepository  cmon_seafoodProcessorsRepository;
    @Override
    public CmonSeafoodprocessors findById(Long id) {
        return seafoodprocessorsRepository.findOne(id);
    }
    
    @Override
    public List<CmonSeafoodprocessors> findAll() {
        return seafoodprocessorsRepository.findAll();
    }
    
    @Override
    public CmonSeafoodprocessors save(CmonSeafoodprocessors entity) {
        return seafoodprocessorsRepository.save(entity);
    }
    
    @Override
    public CmonSeafoodprocessors update(CmonSeafoodprocessors entity) {
        return seafoodprocessorsRepository.save(entity);
    }
    
    @Override
    public CmonSeafoodprocessors create(CmonSeafoodprocessors entity) {
        return seafoodprocessorsRepository.save(entity);
    }
    
    @Override
    public void delete(Long id) {
        seafoodprocessorsRepository.delete(id);
    }

    @Override
    public FilterResult_CmonSeafood searchCmonSeaFood(FilterFormCmonSF filter) {
        return cmon_seafoodProcessorsRepository.searchCmonSeafood(filter);
    }

    @Override
    public Long maxId() {
        return cmon_seafoodProcessorsRepository.maxId();
    }
}

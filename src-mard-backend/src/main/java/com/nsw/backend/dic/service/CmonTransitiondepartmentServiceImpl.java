/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonTransitiondepartment;
import com.nsw.backend.dic.repositories.CmonTransitiondepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonTransitiondepartmentService")
@Transactional
public class CmonTransitiondepartmentServiceImpl implements CmonTransitiondepartmentService {
    
    @Autowired
    CmonTransitiondepartmentRepository transitiondepartmentRepository;
    
    @Override
    public CmonTransitiondepartment findById(Long id) {
        return transitiondepartmentRepository.findOne(id);
    }
    
    @Override
    public List<CmonTransitiondepartment> findAll() {
        return transitiondepartmentRepository.findAll();
    }
    
    @Override
    public CmonTransitiondepartment save(CmonTransitiondepartment entity) {
        return transitiondepartmentRepository.save(entity);
    }
    
    @Override
    public CmonTransitiondepartment update(CmonTransitiondepartment entity) {
        return transitiondepartmentRepository.save(entity);
    }
    
    @Override
    public CmonTransitiondepartment create(CmonTransitiondepartment entity) {
        return transitiondepartmentRepository.save(entity);
    }
    
    @Override
    public void delete(Long id) {
        transitiondepartmentRepository.delete(id);
    }
    
}

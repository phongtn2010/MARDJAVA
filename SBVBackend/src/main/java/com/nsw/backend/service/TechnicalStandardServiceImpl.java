/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.service;

import com.nsw.backend.model.TechnicalStandard;
import com.nsw.backend.repositories.TechnicalStandardRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Phong84NV
 */
@Service("technicalStandardService")
@Transactional
public class TechnicalStandardServiceImpl implements TechnicalStandardService {

    public static final Logger logger = LoggerFactory.getLogger(TechnicalStandardServiceImpl.class);
    @Autowired
    private TechnicalStandardRepository technicalStandardRepository;

    @Override
    public TechnicalStandard findById() {
        return null;
    }

    @Override
    public List<TechnicalStandard> findAll() {
        return technicalStandardRepository.findAll();
    }

    @Override
    public TechnicalStandard save(TechnicalStandard entity) {
        return technicalStandardRepository.save(entity);
    }

    @Override
    public TechnicalStandard update(TechnicalStandard entity) {
        return technicalStandardRepository.save(entity);
    }

    @Override
    public TechnicalStandard create(TechnicalStandard entity) {
        return technicalStandardRepository.save(entity);
    }

    @Override
    public void delete() {
        
    }

    @Override
    public List<TechnicalStandard> findByRole(Long roleId) {
        return technicalStandardRepository.findByRole(roleId);
    }
}

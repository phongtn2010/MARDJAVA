/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonCountry;
import com.nsw.backend.dic.repositories.CmonCountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonCountryService")
@Transactional
public class CmonCountryServiceImpl implements CmonCountryService {
    
    @Autowired
    CmonCountryRepository cmonCountryRepository;

    @Override
    public CmonCountry findById(Long id) {
        return cmonCountryRepository.findOne(id);
    }

    @Override
    public CmonCountry findByCountryCode(String countryCode) {
        return cmonCountryRepository.findFirstByCountrycode(countryCode).orElse(null);
    }

    @Override
    public List<CmonCountry> findAll() {
        return cmonCountryRepository.findAll();
    }

    @Override
    public CmonCountry save(CmonCountry entity) {
        return cmonCountryRepository.save(entity);
    }

    @Override
    public CmonCountry update(CmonCountry entity) {
        return cmonCountryRepository.save(entity);
    }

    @Override
    public CmonCountry create(CmonCountry entity) {
        return cmonCountryRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonCountryRepository.delete(id);
    }
    
    
    
}

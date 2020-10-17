/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonPort;
import com.nsw.backend.dic.repositories.CmonPortRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonPortService")
@Transactional
public class CmonPortServiceImpl implements CmonPortService {
    
    @Autowired
    CmonPortRepository cmonPortRepository;

    @Override
    public CmonPort findById(Long id) {
        return cmonPortRepository.findOne(id);
    }

    @Override
    public List<CmonPort> findAll() {
        return cmonPortRepository.findAll();
    }

    @Override
    public CmonPort save(CmonPort entity) {
        return cmonPortRepository.save(entity);
    }

    @Override
    public CmonPort update(CmonPort entity) {
        return cmonPortRepository.save(entity);
    }

    @Override
    public CmonPort create(CmonPort entity) {
        return cmonPortRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonPortRepository.delete(id);
    }

    @Override
    public List<CmonPort> findByCountryCode(String countryCode) {
        return cmonPortRepository.findByStatecode(countryCode);
    }

    @Override
    public List<CmonPort> findWithOutCountryCode(String countryCode) {
        return cmonPortRepository.findWithOutCountryCode(countryCode);
    }

    @Override
    public CmonPort findByPortCode(String portCode) {
        return cmonPortRepository.findByPortcode(portCode).orElse(new CmonPort());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonProvince;
import com.nsw.backend.dic.repositories.CmonProvinceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonProvinceService")
@Transactional
public class CmonProvinceServiceImpl implements CmonProvinceService {

    @Autowired
    CmonProvinceRepository cmonProvinceRepository;

    @Override
    public CmonProvince findById(Long id) {
        return cmonProvinceRepository.findOne(id);
    }

    @Override
    public List<CmonProvince> findAll() {
        return cmonProvinceRepository.findAll();
    }

    @Override
    public CmonProvince save(CmonProvince entity) {
        return cmonProvinceRepository.save(entity);
    }

    @Override
    public CmonProvince update(CmonProvince entity) {
        return cmonProvinceRepository.save(entity);
    }

    @Override
    public CmonProvince create(CmonProvince entity) {
        return cmonProvinceRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cmonProvinceRepository.delete(id);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonUnit;
import com.nsw.backend.dic.repositories.CmonUnitRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cmonUnitService")
@Transactional
public class CmonUnitServiceImpl implements CmonUnitService {

    @Autowired
    CmonUnitRepository unitRepository;

    @Override
    public CmonUnit findById(Long id) {
        return unitRepository.findOne(id);
    }

    @Override
    public List<CmonUnit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public CmonUnit save(CmonUnit entity) {
        return unitRepository.save(entity);
    }

    @Override
    public CmonUnit update(CmonUnit entity) {
        return unitRepository.save(entity);
    }

    @Override
    public CmonUnit create(CmonUnit entity) {
        return unitRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        unitRepository.delete(id);
    }

    @Override
    public List<CmonUnit> findByUnitTypeId(Long unitTypeId) {
        return unitRepository.findByUnittypeid(unitTypeId);
    }

    @Override
    public List<CmonUnit> findByUnitTypeIdAndSystemId(Long unitTypeId, Long systemId) {
        return unitRepository.findByUnittypeidAndSystemid(unitTypeId, systemId);
    }

    @Override
    public CmonUnit findByUomCode(String uomCode) {
        return unitRepository.findFirstByUnitcode(uomCode).orElse(new CmonUnit());
    }

}

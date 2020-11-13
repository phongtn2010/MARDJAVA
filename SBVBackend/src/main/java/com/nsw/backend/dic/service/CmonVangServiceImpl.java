package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonVang;
import com.nsw.backend.dic.repositories.CmonPortRepository;
import com.nsw.backend.dic.repositories.CmonVangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cmonVangService")
@Transactional
public class CmonVangServiceImpl implements CmonVangService {

    @Autowired
    CmonVangRepository cmonPortRepository;

    @Override
    public List<CmonVang> findAll() {
        return cmonPortRepository.findAll();
    }


}

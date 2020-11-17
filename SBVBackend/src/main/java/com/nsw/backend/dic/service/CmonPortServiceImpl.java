package com.nsw.backend.dic.service;


import com.nsw.backend.dic.model.CmonPort;
import com.nsw.backend.dic.repositories.CmonPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cmonPortService")
@Transactional
public class CmonPortServiceImpl implements CmonPortService {

    @Autowired
    CmonPortRepository cmonPortRepository;

    @Override
    public List<CmonPort> findAll() {
        return cmonPortRepository.findAll();
    }


}
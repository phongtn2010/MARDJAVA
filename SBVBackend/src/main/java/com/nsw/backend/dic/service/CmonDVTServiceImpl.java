package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonDVT;
import com.nsw.backend.dic.repositories.CmonDVTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cmonDVTService")
@Transactional
public class CmonDVTServiceImpl implements CmonDVTService {

    @Autowired
    CmonDVTRepository cmonDVTRepository;

    @Override
    public List<CmonDVT> findAll() {
        return cmonDVTRepository.findAll();
    }


}
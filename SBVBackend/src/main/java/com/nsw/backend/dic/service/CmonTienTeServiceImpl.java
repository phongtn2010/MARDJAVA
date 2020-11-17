package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonTienTe;
import com.nsw.backend.dic.repositories.CmonTienTeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cmonTienTeService")
@Transactional
public class CmonTienTeServiceImpl implements CmonTienTeService {

    @Autowired
    CmonTienTeRepository cmonTienTeRepository;

    @Override
    public List<CmonTienTe> findAll() {
        return cmonTienTeRepository.findAll();
    }


}
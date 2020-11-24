package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdDinhkem25;
import com.nsw.backend.mard.p25.repositories.TbdDinhkem25Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class TbdDinhkem25ServiceImpl implements TbdDinhkem25Service{
    @Autowired
    private TbdDinhkem25Repository repository;
    @Override
    public void saveAll(List<TbdDinhkem25> tbdDinhkem25List) {
        repository.save(tbdDinhkem25List);
    }
}

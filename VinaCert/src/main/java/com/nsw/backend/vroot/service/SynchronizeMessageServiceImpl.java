package com.nsw.backend.vroot.service;

import com.nsw.backend.vroot.model.SynchronizeMessage;
import com.nsw.backend.vroot.repositories.SynchronizeMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SynchronizeMessageServiceImpl implements SynchronizeMessageService{

    @Autowired
    private SynchronizeMessageRepository synchronizeMessageRepository;

    @Override
    public List<SynchronizeMessage> findByCreatedDate(Date from) {
        return synchronizeMessageRepository.findByCreatedDate(from);
    }

    @Override
    public List<SynchronizeMessage> findByCreatedDateToDate(Date from, Date to) {
        return synchronizeMessageRepository.findByCreatedDateToDate(from,to);
    }
}

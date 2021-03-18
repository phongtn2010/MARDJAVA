package com.nsw.backend.vroot.service;

import com.nsw.backend.vroot.model.SynchronizeMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface SynchronizeMessageService {
    public List<SynchronizeMessage> findByCreatedDate(Date from);
    public List<SynchronizeMessage> findByCreatedDateToDate(Date from,Date to);
}

package com.nsw.backend.vroot.repositories;

import com.nsw.backend.vroot.model.SynchronizeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


public class SynchronizeMessageRepositoryImpl implements SynchronizeMessageRepositoryCustom {
    @PersistenceContext
    private EntityManager mEntityManager;
    @Autowired
    private SynchronizeMessageRepository repository;

}

package com.nsw.backend.vroot.repositories;

import com.nsw.backend.vroot.model.SynchronizeMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SynchronizeMessageRepository extends JpaRepository<SynchronizeMessage, Long>, SynchronizeMessageRepositoryCustom {
    @Query(value = "SELECT a from SynchronizeMessage a where a.createdDate>=?1 and a.messageType=13 and a.function=6")
    public List<SynchronizeMessage> findByCreatedDate(Date from);
    @Query(value = "SELECT a from SynchronizeMessage a where a.createdDate>=?1 and a.createdDate<?2 and a.messageType=13 and a.function=6")
    List<SynchronizeMessage> findByCreatedDateToDate(Date from, Date to);
}
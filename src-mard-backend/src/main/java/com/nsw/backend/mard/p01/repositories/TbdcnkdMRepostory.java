package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.TbdcnkdM01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TbdcnkdMRepostory extends JpaRepository<TbdcnkdM01, Long> {
    Optional<TbdcnkdM01> findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(String fiNSWFileCode);

    @Query("select gp from TbdcnkdM01 gp " +
            "where (?1 is null or gp.fiHealthCertificateNoVni like %?1%) " +
            "and (?2 is null or ?2 <= gp.fiSignResultDate) " +
            "and (?3 is null or ?3 >= gp.fiSignResultDate)")
    List<TbdcnkdM01> findGPByFilter(String fiCertNo, Date fiSignStartDate, Date fiSignEndDate);
}

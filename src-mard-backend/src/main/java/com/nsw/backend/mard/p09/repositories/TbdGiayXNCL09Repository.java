package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.Tbdgiayxncl09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TbdGiayXNCL09Repository extends JpaRepository<Tbdgiayxncl09, Long> {
    Optional<Tbdgiayxncl09> findFirstByFiQuanlityCerNo(String fiCertificateNo);

    List<Tbdgiayxncl09> findAllByFiNSWFileCodeOrderByFiIdQualityCerDesc(String fiHSCode);

    @Query("select gp from Tbdgiayxncl09 gp " +
            "where (?1 is null or gp.fiQuanlityCerNo like %?1%) " +
            "and (?2 is null or ?2 <= gp.fiSignResultDate) " +
            "and (?3 is null or ?3 >= gp.fiSignResultDate)")
    List<Tbdgiayxncl09> findGPByFilter(String fiCertNo, Date fiSignStartDate, Date fiSignEndDate);
}

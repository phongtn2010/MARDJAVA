package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.Tbdgiayvc09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TbdGiayVC09Repository extends JpaRepository<Tbdgiayvc09, Long> {
    Optional<Tbdgiayvc09> findFirstByFiCertificateNo(String fiCertificateNo);

    List<Tbdgiayvc09> findAllByFiNSWFileCodeOrderByFiIdTransportCerDesc(String fiNSWFileCode);

    @Query("select gp from Tbdgiayvc09 gp " +
            "where (?1 is null or gp.fiCertificateNo like %?1%) " +
            "and (?2 is null or ?2 <= gp.fiSignConfirmDate) " +
            "and (?3 is null or ?3 >= gp.fiSignConfirmDate)")
    List<Tbdgiayvc09> findGPByFilter(String fiCertNo, Date fiSignStartDate, Date fiSignEndDate);
}

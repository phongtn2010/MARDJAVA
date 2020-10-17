package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.TbdCvCnkd07;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TbdGiayCNKD07Repository extends JpaRepository<TbdCvCnkd07, Long> {
    List<TbdCvCnkd07> findAllByFiNSWFileCodeOrderByFiIdCVDesc(String fiHSCode);

    @Query("select gp from TbdCvCnkd07 gp " +
            "where (?1 is null or gp.fiCertificateNo like %?1%) " +
            "and (?2 is null or ?2 <= gp.fiSignConfirmDate) " +
            "and (?3 is null or ?3 >= gp.fiSignConfirmDate)")
    List<TbdCvCnkd07> findGPByFilter(String fiCertNo, Date fiSignStartDate, Date fiSignEndDate);

    Optional<TbdCvCnkd07> findFirstByFiCertificateNo(String certNo);
}

package com.nsw.backend.mard.p08.repositories;

import com.nsw.backend.mard.p08.model.Tbdcvvsty08;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Repository : Tbddvxl08
 */
@Repository
public interface Tbdcvvsty08Repository extends JpaRepository<Tbdcvvsty08, Long> {
    Tbdcvvsty08 findFirstByFiHSCodeOrderByFiIdCVDesc(String fiHSCode);

    Tbdcvvsty08 findByFiHSCode(String fiHSCode);

    @Query("select gp from Tbdcvvsty08 gp " +
            "where (?1 is null or gp.fiDispatchNo like %?1%) " +
            "and (?2 is null or ?2 <= gp.fiSignConfirmDate) " +
            "and (?3 is null or ?3 >= gp.fiSignConfirmDate)")
    List<Tbdcvvsty08> findGPByFilter(String fiCertNo, Date fiSignStartDate, Date fiSignEndDate);
}

package com.nsw.backend.mard.p06.repositories;

import com.nsw.backend.mard.p06.model.TbdCongvan06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TbdCongvan06Repository extends JpaRepository<TbdCongvan06, Long> {
    TbdCongvan06 findByFiNSWFileCodeAndFiDispatchType(String fiNSWFileCode, int fiDispatchType);

    TbdCongvan06 findFirstByFiNSWFileCodeAndFiDispatchTypeOrderByFiCreatedDateDesc(String fiNSWFileCode, int fiDispatchType);

    TbdCongvan06 findByFiDispatchNoAndFiDispatchType(String fiDispatchNo, int fiDispatchType);

    @Query("select gp from TbdCongvan06 gp " +
            "where (?1 is null or gp.fiDispatchNo like %?1%) " +
            "and (?2 is null or ?2 <= gp.fiDispatchDate) " +
            "and (?3 is null or ?3 >= gp.fiDispatchDate)")
    List<TbdCongvan06> findGPByFilter(String licenseNo, Date licenseStartDate, Date licenseEndDate);
}

package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdHoso25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TbdHoso25Repository extends JpaRepository<TbdHoso25, Integer>, TbdHoso25RepositoryCustom {
    Optional<TbdHoso25> findFirstByFiNSWFileCodeAndFiActive(String fileCode, boolean active);
    List<TbdHoso25> findAllByFiHSStatusAndFiActive(int fiHSStatus, boolean active);
    @Query("select hs from TbdHoso25 hs where hs.fiTaxCode=?1 and hs.fiHSStatus>=?2 and hs.fiHSStatus<=?3")
    List<TbdHoso25> findByFiHSStatus(String taxCode,Integer from, Integer to);
}

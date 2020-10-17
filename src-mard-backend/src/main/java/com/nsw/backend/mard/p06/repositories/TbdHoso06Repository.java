package com.nsw.backend.mard.p06.repositories;

import com.nsw.backend.mard.p06.model.TbdHoso06;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TbdHoso06Repository extends JpaRepository<TbdHoso06, Integer>, TbdHoso06RepositoryCustom {
    Optional<TbdHoso06> findFirstByFiNSWFileCodeAndFiActive(String fileCode, boolean active);

    List<TbdHoso06> findAllByFiHSStatusAndFiActive(int fiHSStatus, boolean active);
}

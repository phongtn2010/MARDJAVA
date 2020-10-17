package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.Tbdhoso01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tbdhoso01Repository extends JpaRepository<Tbdhoso01, Long>, Tbdhoso01RepositoryCustom {
    Optional<Tbdhoso01> findFirstByFiNSWFileCodeAndFiActive(String fiIdHS, boolean fiActive);

    //TODO: TEST remove later
    List<Tbdhoso01> findAllByFiHSStatusAndFiActive(Long fiHSType, boolean fiActive);
}

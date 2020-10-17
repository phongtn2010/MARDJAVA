package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.Tbdhoso09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tbdhoso09Repository extends JpaRepository<Tbdhoso09, Long>, Tbdhoso09RepositoryCustom {
    Optional<Tbdhoso09> findFirstByFiHSCodeAndFiActive(String fiHSCode, boolean fiActive);

}

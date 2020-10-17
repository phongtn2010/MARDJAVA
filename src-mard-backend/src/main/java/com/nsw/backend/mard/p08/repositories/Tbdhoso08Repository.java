package com.nsw.backend.mard.p08.repositories;

import com.nsw.backend.mard.p08.model.Tbdhoso08;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tbdhoso08Repository extends JpaRepository<Tbdhoso08, Long>, Tbdhoso08RepositoryCustom {
    Optional<Tbdhoso08> findFirstByFiHSCodeAndFiActive(String fiHSCode, boolean fiActive);

    Page<Tbdhoso08> findAllByFiTaxCodeAndFiActive(String fiBizRegistrationNo, boolean fiActive, Pageable pageable);

    List<Tbdhoso08> findAllByFiTaxCodeAndFiActive(String fiBizRegistrationNo, boolean fiActive);

    List<Tbdhoso08> findFirst10ByFiTaxCodeAndFiActiveOrderByFiCreatedDateDesc(String fiBizRegistrationNo, boolean fiActive);

    //TODO: TEST remove later
    List<Tbdhoso08> findAllByFiHSStatusAndFiActive(Long fiHSType, boolean fiActive);
}

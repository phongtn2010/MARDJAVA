package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.Cmon_SeafoodProcessors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cmon_SeafoodProcessorsRepository extends JpaRepository<Cmon_SeafoodProcessors, Long> {
}

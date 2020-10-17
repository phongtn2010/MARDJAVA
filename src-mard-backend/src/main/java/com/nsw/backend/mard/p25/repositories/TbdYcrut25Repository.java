package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdYcrut25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdYcrut25Repository extends JpaRepository<TbdYcrut25, Long> {
}

package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.TbdXacnhan09;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TbdXacnhan09Repository extends JpaRepository<TbdXacnhan09, Long> {

    Optional<TbdXacnhan09> findFirstByFiNSWFileCodeOrderByFiCreatedDateDesc(String fiNSWFileCode);

}

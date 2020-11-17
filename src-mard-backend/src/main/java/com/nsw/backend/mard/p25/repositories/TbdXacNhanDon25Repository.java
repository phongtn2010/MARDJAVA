package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdXacNhanDon25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdXacNhanDon25Repository extends JpaRepository<TbdXacNhanDon25, Integer> {
    TbdXacNhanDon25 findByFiNSWFileCode(String fiNSWFileCode);
}

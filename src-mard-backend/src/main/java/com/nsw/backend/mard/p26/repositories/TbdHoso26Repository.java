package com.nsw.backend.mard.p26.repositories;

import com.nsw.backend.mard.p26.model.TbdHoso26;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdHoso26Repository extends JpaRepository<TbdHoso26, Integer>, TbdHoso26RepositoryCustom{

    TbdHoso26 findByFiIdHoSo26(Integer parseInt);
    TbdHoso26 findByFiMaHoso(String nswFileCode);
}

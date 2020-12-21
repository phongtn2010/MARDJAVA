package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdHanghoaMK25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdHanghoaMK25Repository extends JpaRepository<TbdHanghoaMK25, Integer>,TbdHanghoaMK25RepositoryCustom{

    List<TbdHanghoaMK25> findByFiTaxCode(String taxCode);
    List<TbdHanghoaMK25> findByFiProHashOrderByFiOrderDesc(String hash);

    TbdHanghoaMK25 findByFiIdProduct(Integer fiIdProduct);
}

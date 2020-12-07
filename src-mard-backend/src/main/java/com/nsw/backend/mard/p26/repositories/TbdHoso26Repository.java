package com.nsw.backend.mard.p26.repositories;

import com.nsw.backend.mard.p26.model.TbdHoso26;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TbdHoso26Repository extends JpaRepository<TbdHoso26, Integer>, TbdHoso26RepositoryCustom{

    TbdHoso26 findByFiIdHoSo26(Integer parseInt);
    TbdHoso26 findByFiMaHoso(String nswFileCode);

    @Query("select hs from TbdHoso26 hs where hs.fiActive=true and hs.fiSoCVMienKiem is not null and hs.fiHieuLucToiNgay<=?1 and hs.fiMasothue=?2 " +
            "and hs.fiTrangthai=4 order by hs.fiNgayKyCV")
    List<TbdHoso26> findCongVanMienKiem(Date now,String taxcode);
}

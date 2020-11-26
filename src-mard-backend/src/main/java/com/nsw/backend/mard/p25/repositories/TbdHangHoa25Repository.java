package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbdHangHoa25Repository  extends JpaRepository<TbdHanghoa25, Integer>, TbdHangHoa25RepositoryCustom{
    public List<TbdHanghoa25> findByFiIdHS(Integer idHoSo);
    public TbdHanghoa25 findByFiIdProduct(Integer id);
    public List<TbdHanghoa25> findByFiTaxCodeAndFiTrangThaiHangHoa(String taxcode, Integer fiTrangThai);
}

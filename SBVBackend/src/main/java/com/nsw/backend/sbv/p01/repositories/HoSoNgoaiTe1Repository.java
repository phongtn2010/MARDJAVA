package com.nsw.backend.sbv.p01.repositories;


import com.nsw.backend.sbv.p01.model.HoSoNgoaiTe1;
import com.nsw.backend.sbv.p01.model.HoSoNgoaiTeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface HoSoNgoaiTe1Repository extends JpaRepository<HoSoNgoaiTe1, Long>, HoSoNgoaiTe1RepositoryCustom {

	public HoSoNgoaiTe1 findByMaHoSo(String maHoSo);
	
	@Query(value = "select new com.nsw.backend.sbv.p01.model.HoSoNgoaiTeModel(a.idHoSo, a.hinhThucXNK, a.tenNganHang, a.ngayTao, a.trangThai, a.maHoSo, b.soGiayPhep, b.ngayCap) "
			+ "from HoSoNgoaiTe1 a left join a.giayPhep b   WHERE "
			+ "(:maSoThue is null or (a.maSoThue = :maSoThue)) "
			+ " AND (:maHoSo is null or (a.maHoSo like CONCAT(CONCAT('%',UPPER(:maHoSo)),'%'))) "
			+ " AND (:trangThai is null or a.trangThai = :trangThai) "
			+ " AND (:hinhThucXNK is null or a.hinhThucXNK = :hinhThucXNK) "
			+ " AND (:maCuaKhau is null or (UPPER(a.maCuaKhau) like CONCAT(CONCAT('%',UPPER(:maCuaKhau)),'%'))) "
			+ " AND (:fromNgayTao is null or a.ngayTao >= :fromNgayTao) "
			+ " AND (:toNgayTao is null or a.ngayTao <= :toNgayTao) "
			+ " AND (:xoaHoSo is null or a.xoaHoSo = :xoaHoSo) "
			+ " AND (:fromNgayPhep is null or b.ngayCap >= :fromNgayPhep) "
			+ " AND (:toNgayPhep is null or b.ngayCap <= :toNgayPhep) "
			+ " AND (:soGiayPhep is null or (UPPER(b.soGiayPhep) like CONCAT(CONCAT('%',UPPER(:soGiayPhep)),'%'))) ",
			countQuery = "select count(a) from HoSoNgoaiTe1 a left join a.giayPhep b    WHERE "
					+ "(:maSoThue is null or (a.maSoThue = :maSoThue)) "
					+ " AND (:maHoSo is null or (UPPER(a.maHoSo) like CONCAT(CONCAT('%',UPPER(:maHoSo)),'%'))) "
					+ " AND (:trangThai is null or a.trangThai = :trangThai) "
					+ " AND (:hinhThucXNK is null or a.hinhThucXNK = :hinhThucXNK) "
					+ " AND (:maCuaKhau is null or (UPPER(a.maCuaKhau) like CONCAT(CONCAT('%',UPPER(:maCuaKhau)),'%'))) "
					+ " AND (:fromNgayTao is null or a.ngayTao >= :fromNgayTao) "
					+ " AND (:toNgayTao is null or a.ngayTao <= :toNgayTao) "
					+ " AND (:xoaHoSo is null or a.xoaHoSo = :xoaHoSo) "
					+ " AND (:fromNgayPhep is null or b.ngayCap >= :fromNgayPhep) "
					+ " AND (:toNgayPhep is null or b.ngayCap <= :toNgayPhep) "
					+ " AND (:soGiayPhep is null or (UPPER(b.soGiayPhep) like CONCAT(CONCAT('%',UPPER(:soGiayPhep)),'%'))) "
			)
	
	public Page<HoSoNgoaiTeModel> search(Pageable pageable, 
			@Param("maSoThue") String maSoThue,
			@Param("maHoSo") String maHoSo,
			@Param("trangThai") Integer trangThai,
			@Param("hinhThucXNK") Integer hinhThucXNK,
			@Param("maCuaKhau") String maCuaKhau,
			@Param("fromNgayTao") Date fromNgayTao,
			@Param("toNgayTao") Date toNgayTao,
			@Param("xoaHoSo") Boolean xoaHoSo,
			@Param("fromNgayPhep") Date fromNgayPhep,
			@Param("toNgayPhep") Date toNgayPhep,
			@Param("soGiayPhep") String soGiayPhep
			);

}

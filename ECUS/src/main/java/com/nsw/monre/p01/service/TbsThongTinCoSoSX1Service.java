package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsThongTinCoSoSX1;
import com.nsw.monre.p01.searchitem.TbsThongTinCoSoSX1SearchItem;



public interface TbsThongTinCoSoSX1Service {

	List<TbsThongTinCoSoSX1> getTbsThongTinCoSoSX1s(int pageIndex, int pageSize, String sort);

	List<TbsThongTinCoSoSX1> getTbsThongTinCoSoSX1s();

	TbsThongTinCoSoSX1 saveTbsThongTinCoSoSX1(TbsThongTinCoSoSX1 pTbsThongTinCoSoSX1);

	TbsThongTinCoSoSX1 updateTbsThongTinCoSoSX1(Long pTbsThongTinCoSoSX1Id, TbsThongTinCoSoSX1 pTbsThongTinCoSoSX1);

	TbsThongTinCoSoSX1 getTbsThongTinCoSoSX1(Long pTbsThongTinCoSoSX1Id);

	boolean deleteTbsThongTinCoSoSX1ById(Long pTbsThongTinCoSoSX1Id);

	long countAllTbsThongTinCoSoSX1();

	List<TbsThongTinCoSoSX1> searchTbsThongTinCoSoSX1s(TbsThongTinCoSoSX1SearchItem item);
	long countSearchTbsThongTinCoSoSX1(TbsThongTinCoSoSX1SearchItem item);

	List<TbsThongTinCoSoSX1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsThongTinCoSoSX1s(TbsThongTinCoSoSX1SearchItem item);


	public List<TbsThongTinCoSoSX1> findByMaNguoiTaoOrderByIdCSAsc(String maNguoiTao);


	public List<TbsThongTinCoSoSX1> findByMaNguoiTaoOrderByIdCSDesc(String maNguoiTao);

}


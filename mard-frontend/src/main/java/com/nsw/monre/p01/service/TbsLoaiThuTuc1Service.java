package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsLoaiThuTuc1;
import com.nsw.monre.p01.searchitem.TbsLoaiThuTuc1SearchItem;



public interface TbsLoaiThuTuc1Service {

	List<TbsLoaiThuTuc1> getTbsLoaiThuTuc1s(int pageIndex, int pageSize, String sort);

	List<TbsLoaiThuTuc1> getTbsLoaiThuTuc1s();

	TbsLoaiThuTuc1 saveTbsLoaiThuTuc1(TbsLoaiThuTuc1 pTbsLoaiThuTuc1);

	TbsLoaiThuTuc1 updateTbsLoaiThuTuc1(String pTbsLoaiThuTuc1Id, TbsLoaiThuTuc1 pTbsLoaiThuTuc1);

	TbsLoaiThuTuc1 getTbsLoaiThuTuc1(String pTbsLoaiThuTuc1Id);

	boolean deleteTbsLoaiThuTuc1ById(String pTbsLoaiThuTuc1Id);

	long countAllTbsLoaiThuTuc1();

	List<TbsLoaiThuTuc1> searchTbsLoaiThuTuc1s(TbsLoaiThuTuc1SearchItem item);
	long countSearchTbsLoaiThuTuc1(TbsLoaiThuTuc1SearchItem item);

	List<TbsLoaiThuTuc1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsLoaiThuTuc1s(TbsLoaiThuTuc1SearchItem item);

}


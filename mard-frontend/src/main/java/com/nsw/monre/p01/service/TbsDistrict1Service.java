package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsDistrict1;
import com.nsw.monre.p01.searchitem.TbsDistrict1SearchItem;



public interface TbsDistrict1Service {

	List<TbsDistrict1> getTbsDistrict1s(int pageIndex, int pageSize, String sort);

	List<TbsDistrict1> getTbsDistrict1s();

	TbsDistrict1 saveTbsDistrict1(TbsDistrict1 pTbsDistrict1);

	TbsDistrict1 updateTbsDistrict1(String pTbsDistrict1Id, TbsDistrict1 pTbsDistrict1);

	TbsDistrict1 getTbsDistrict1(String pTbsDistrict1Id);

	boolean deleteTbsDistrict1ById(String pTbsDistrict1Id);

	long countAllTbsDistrict1();

	List<TbsDistrict1> searchTbsDistrict1s(TbsDistrict1SearchItem item);
	long countSearchTbsDistrict1(TbsDistrict1SearchItem item);

	List<TbsDistrict1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsDistrict1s(TbsDistrict1SearchItem item);


	public List<TbsDistrict1> findByProvinceId(String provinceId);

}


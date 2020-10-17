package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsProvince1;
import com.nsw.monre.p01.searchitem.TbsProvince1SearchItem;



public interface TbsProvince1Service {

	List<TbsProvince1> getTbsProvince1s(int pageIndex, int pageSize, String sort);

	List<TbsProvince1> getTbsProvince1s();

	TbsProvince1 saveTbsProvince1(TbsProvince1 pTbsProvince1);

	TbsProvince1 updateTbsProvince1(String pTbsProvince1Id, TbsProvince1 pTbsProvince1);

	TbsProvince1 getTbsProvince1(String pTbsProvince1Id);

	boolean deleteTbsProvince1ById(String pTbsProvince1Id);

	long countAllTbsProvince1();

	List<TbsProvince1> searchTbsProvince1s(TbsProvince1SearchItem item);
	long countSearchTbsProvince1(TbsProvince1SearchItem item);

	List<TbsProvince1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsProvince1s(TbsProvince1SearchItem item);

}


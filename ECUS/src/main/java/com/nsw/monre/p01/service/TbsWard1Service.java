package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsWard1;
import com.nsw.monre.p01.searchitem.TbsWard1SearchItem;



public interface TbsWard1Service {

	List<TbsWard1> getTbsWard1s(int pageIndex, int pageSize, String sort);

	List<TbsWard1> getTbsWard1s();

	TbsWard1 saveTbsWard1(TbsWard1 pTbsWard1);

	TbsWard1 updateTbsWard1(String pTbsWard1Id, TbsWard1 pTbsWard1);

	TbsWard1 getTbsWard1(String pTbsWard1Id);

	boolean deleteTbsWard1ById(String pTbsWard1Id);

	long countAllTbsWard1();

	List<TbsWard1> searchTbsWard1s(TbsWard1SearchItem item);
	long countSearchTbsWard1(TbsWard1SearchItem item);

	List<TbsWard1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsWard1s(TbsWard1SearchItem item);


	public List<TbsWard1> findByDistrictId(String districtId);

}


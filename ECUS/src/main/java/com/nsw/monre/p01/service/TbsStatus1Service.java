package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsStatus1;
import com.nsw.monre.p01.searchitem.TbsStatus1SearchItem;



public interface TbsStatus1Service {

	List<TbsStatus1> getTbsStatus1s(int pageIndex, int pageSize, String sort);

	List<TbsStatus1> getTbsStatus1s();

	TbsStatus1 saveTbsStatus1(TbsStatus1 pTbsStatus1);

	TbsStatus1 updateTbsStatus1(Long pTbsStatus1Id, TbsStatus1 pTbsStatus1);

	TbsStatus1 getTbsStatus1(Long pTbsStatus1Id);

	boolean deleteTbsStatus1ById(Long pTbsStatus1Id);

	long countAllTbsStatus1();

	List<TbsStatus1> searchTbsStatus1s(TbsStatus1SearchItem item);
	long countSearchTbsStatus1(TbsStatus1SearchItem item);

	List<TbsStatus1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsStatus1s(TbsStatus1SearchItem item);


	public TbsStatus1 findByIdTrangThai(long idTrangThai);

}


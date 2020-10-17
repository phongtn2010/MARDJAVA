package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsPheLieu1;
import com.nsw.monre.p01.searchitem.TbsPheLieu1SearchItem;



public interface TbsPheLieu1Service {

	List<TbsPheLieu1> getTbsPheLieu1s(int pageIndex, int pageSize, String sort);

	List<TbsPheLieu1> getTbsPheLieu1s();

	TbsPheLieu1 saveTbsPheLieu1(TbsPheLieu1 pTbsPheLieu1);

	TbsPheLieu1 updateTbsPheLieu1(String pTbsPheLieu1Id, TbsPheLieu1 pTbsPheLieu1);

	TbsPheLieu1 getTbsPheLieu1(String pTbsPheLieu1Id);

	boolean deleteTbsPheLieu1ById(String pTbsPheLieu1Id);

	long countAllTbsPheLieu1();

	List<TbsPheLieu1> searchTbsPheLieu1s(TbsPheLieu1SearchItem item);
	long countSearchTbsPheLieu1(TbsPheLieu1SearchItem item);

	List<TbsPheLieu1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsPheLieu1s(TbsPheLieu1SearchItem item);

}


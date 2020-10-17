package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdGXNThongTinPheLieu1;
import com.nsw.monre.p01.searchitem.TbdGXNThongTinPheLieu1SearchItem;



public interface TbdGXNThongTinPheLieu1Service {

	List<TbdGXNThongTinPheLieu1> getTbdGXNThongTinPheLieu1s(int pageIndex, int pageSize, String sort);

	List<TbdGXNThongTinPheLieu1> getTbdGXNThongTinPheLieu1s();

	TbdGXNThongTinPheLieu1 saveTbdGXNThongTinPheLieu1(TbdGXNThongTinPheLieu1 pTbdGXNThongTinPheLieu1);

	TbdGXNThongTinPheLieu1 updateTbdGXNThongTinPheLieu1(Long pTbdGXNThongTinPheLieu1Id, TbdGXNThongTinPheLieu1 pTbdGXNThongTinPheLieu1);

	TbdGXNThongTinPheLieu1 getTbdGXNThongTinPheLieu1(Long pTbdGXNThongTinPheLieu1Id);

	boolean deleteTbdGXNThongTinPheLieu1ById(Long pTbdGXNThongTinPheLieu1Id);

	long countAllTbdGXNThongTinPheLieu1();

	List<TbdGXNThongTinPheLieu1> searchTbdGXNThongTinPheLieu1s(TbdGXNThongTinPheLieu1SearchItem item);
	long countSearchTbdGXNThongTinPheLieu1(TbdGXNThongTinPheLieu1SearchItem item);

	List<TbdGXNThongTinPheLieu1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdGXNThongTinPheLieu1s(TbdGXNThongTinPheLieu1SearchItem item);


	public List<TbdGXNThongTinPheLieu1> findByIdGXN(long idGXN);

}


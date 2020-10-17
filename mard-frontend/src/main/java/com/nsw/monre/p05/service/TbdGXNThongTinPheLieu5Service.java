package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdGXNThongTinPheLieu5;
import com.nsw.monre.p05.searchitem.TbdGXNThongTinPheLieu5SearchItem;



public interface TbdGXNThongTinPheLieu5Service {

	List<TbdGXNThongTinPheLieu5> getTbdGXNThongTinPheLieu5s(int pageIndex, int pageSize, String sort);

	List<TbdGXNThongTinPheLieu5> getTbdGXNThongTinPheLieu5s();

	TbdGXNThongTinPheLieu5 saveTbdGXNThongTinPheLieu5(TbdGXNThongTinPheLieu5 pTbdGXNThongTinPheLieu5);

	TbdGXNThongTinPheLieu5 updateTbdGXNThongTinPheLieu5(Long pTbdGXNThongTinPheLieu5Id, TbdGXNThongTinPheLieu5 pTbdGXNThongTinPheLieu5);

	TbdGXNThongTinPheLieu5 getTbdGXNThongTinPheLieu5(Long pTbdGXNThongTinPheLieu5Id);

	boolean deleteTbdGXNThongTinPheLieu5ById(Long pTbdGXNThongTinPheLieu5Id);

	long countAllTbdGXNThongTinPheLieu5();

	List<TbdGXNThongTinPheLieu5> searchTbdGXNThongTinPheLieu5s(TbdGXNThongTinPheLieu5SearchItem item);
	long countSearchTbdGXNThongTinPheLieu5(TbdGXNThongTinPheLieu5SearchItem item);

	List<TbdGXNThongTinPheLieu5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdGXNThongTinPheLieu5s(TbdGXNThongTinPheLieu5SearchItem item);


	public List<TbdGXNThongTinPheLieu5> findByIdGXN(long idGXN);

}


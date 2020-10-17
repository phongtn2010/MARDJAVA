package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdGXNThongTinCoSoSX5;
import com.nsw.monre.p05.searchitem.TbdGXNThongTinCoSoSX5SearchItem;



public interface TbdGXNThongTinCoSoSX5Service {

	List<TbdGXNThongTinCoSoSX5> getTbdGXNThongTinCoSoSX5s(int pageIndex, int pageSize, String sort);

	List<TbdGXNThongTinCoSoSX5> getTbdGXNThongTinCoSoSX5s();

	TbdGXNThongTinCoSoSX5 saveTbdGXNThongTinCoSoSX5(TbdGXNThongTinCoSoSX5 pTbdGXNThongTinCoSoSX5);

	TbdGXNThongTinCoSoSX5 updateTbdGXNThongTinCoSoSX5(Long pTbdGXNThongTinCoSoSX5Id, TbdGXNThongTinCoSoSX5 pTbdGXNThongTinCoSoSX5);

	TbdGXNThongTinCoSoSX5 getTbdGXNThongTinCoSoSX5(Long pTbdGXNThongTinCoSoSX5Id);

	boolean deleteTbdGXNThongTinCoSoSX5ById(Long pTbdGXNThongTinCoSoSX5Id);

	long countAllTbdGXNThongTinCoSoSX5();

	List<TbdGXNThongTinCoSoSX5> searchTbdGXNThongTinCoSoSX5s(TbdGXNThongTinCoSoSX5SearchItem item);
	long countSearchTbdGXNThongTinCoSoSX5(TbdGXNThongTinCoSoSX5SearchItem item);

	List<TbdGXNThongTinCoSoSX5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdGXNThongTinCoSoSX5s(TbdGXNThongTinCoSoSX5SearchItem item);


	public List<TbdGXNThongTinCoSoSX5> findByIdGXN(long idGXN);

}


package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdGXNThongTinCoSoSX1;
import com.nsw.monre.p01.searchitem.TbdGXNThongTinCoSoSX1SearchItem;



public interface TbdGXNThongTinCoSoSX1Service {

	List<TbdGXNThongTinCoSoSX1> getTbdGXNThongTinCoSoSX1s(int pageIndex, int pageSize, String sort);

	List<TbdGXNThongTinCoSoSX1> getTbdGXNThongTinCoSoSX1s();

	TbdGXNThongTinCoSoSX1 saveTbdGXNThongTinCoSoSX1(TbdGXNThongTinCoSoSX1 pTbdGXNThongTinCoSoSX1);

	TbdGXNThongTinCoSoSX1 updateTbdGXNThongTinCoSoSX1(Long pTbdGXNThongTinCoSoSX1Id, TbdGXNThongTinCoSoSX1 pTbdGXNThongTinCoSoSX1);

	TbdGXNThongTinCoSoSX1 getTbdGXNThongTinCoSoSX1(Long pTbdGXNThongTinCoSoSX1Id);

	boolean deleteTbdGXNThongTinCoSoSX1ById(Long pTbdGXNThongTinCoSoSX1Id);

	long countAllTbdGXNThongTinCoSoSX1();

	List<TbdGXNThongTinCoSoSX1> searchTbdGXNThongTinCoSoSX1s(TbdGXNThongTinCoSoSX1SearchItem item);
	long countSearchTbdGXNThongTinCoSoSX1(TbdGXNThongTinCoSoSX1SearchItem item);

	List<TbdGXNThongTinCoSoSX1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdGXNThongTinCoSoSX1s(TbdGXNThongTinCoSoSX1SearchItem item);


	public List<TbdGXNThongTinCoSoSX1> findByIdGXN(long idGXN);

}


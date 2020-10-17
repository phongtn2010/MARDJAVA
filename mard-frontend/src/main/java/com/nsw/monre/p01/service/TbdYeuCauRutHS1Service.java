package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdYeuCauRutHS1;
import com.nsw.monre.p01.searchitem.TbdYeuCauRutHS1SearchItem;



public interface TbdYeuCauRutHS1Service {

	List<TbdYeuCauRutHS1> getTbdYeuCauRutHS1s(int pageIndex, int pageSize, String sort);

	List<TbdYeuCauRutHS1> getTbdYeuCauRutHS1s();

	TbdYeuCauRutHS1 saveTbdYeuCauRutHS1(TbdYeuCauRutHS1 pTbdYeuCauRutHS1);

	TbdYeuCauRutHS1 updateTbdYeuCauRutHS1(Long pTbdYeuCauRutHS1Id, TbdYeuCauRutHS1 pTbdYeuCauRutHS1);

	TbdYeuCauRutHS1 getTbdYeuCauRutHS1(Long pTbdYeuCauRutHS1Id);

	boolean deleteTbdYeuCauRutHS1ById(Long pTbdYeuCauRutHS1Id);

	long countAllTbdYeuCauRutHS1();

	List<TbdYeuCauRutHS1> searchTbdYeuCauRutHS1s(TbdYeuCauRutHS1SearchItem item);
	long countSearchTbdYeuCauRutHS1(TbdYeuCauRutHS1SearchItem item);

	List<TbdYeuCauRutHS1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdYeuCauRutHS1s(TbdYeuCauRutHS1SearchItem item);


	public List<TbdYeuCauRutHS1> findByIdHS(long idHS);

}


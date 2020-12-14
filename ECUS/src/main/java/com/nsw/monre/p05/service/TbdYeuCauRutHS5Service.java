package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdYeuCauRutHS5;
import com.nsw.monre.p05.searchitem.TbdYeuCauRutHS5SearchItem;



public interface TbdYeuCauRutHS5Service {

	List<TbdYeuCauRutHS5> getTbdYeuCauRutHS5s(int pageIndex, int pageSize, String sort);

	List<TbdYeuCauRutHS5> getTbdYeuCauRutHS5s();

	TbdYeuCauRutHS5 saveTbdYeuCauRutHS5(TbdYeuCauRutHS5 pTbdYeuCauRutHS5);

	TbdYeuCauRutHS5 updateTbdYeuCauRutHS5(Long pTbdYeuCauRutHS5Id, TbdYeuCauRutHS5 pTbdYeuCauRutHS5);

	TbdYeuCauRutHS5 getTbdYeuCauRutHS5(Long pTbdYeuCauRutHS5Id);

	boolean deleteTbdYeuCauRutHS5ById(Long pTbdYeuCauRutHS5Id);

	long countAllTbdYeuCauRutHS5();

	List<TbdYeuCauRutHS5> searchTbdYeuCauRutHS5s(TbdYeuCauRutHS5SearchItem item);
	long countSearchTbdYeuCauRutHS5(TbdYeuCauRutHS5SearchItem item);

	List<TbdYeuCauRutHS5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdYeuCauRutHS5s(TbdYeuCauRutHS5SearchItem item);


	public List<TbdYeuCauRutHS5> findByIdHS(long idHS);

}


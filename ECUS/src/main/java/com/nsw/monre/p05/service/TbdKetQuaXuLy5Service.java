package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdKetQuaXuLy5;
import com.nsw.monre.p05.searchitem.TbdKetQuaXuLy5SearchItem;



public interface TbdKetQuaXuLy5Service {

	List<TbdKetQuaXuLy5> getTbdKetQuaXuLy5s(int pageIndex, int pageSize, String sort);

	List<TbdKetQuaXuLy5> getTbdKetQuaXuLy5s();

	TbdKetQuaXuLy5 saveTbdKetQuaXuLy5(TbdKetQuaXuLy5 pTbdKetQuaXuLy5);

	TbdKetQuaXuLy5 updateTbdKetQuaXuLy5(Long pTbdKetQuaXuLy5Id, TbdKetQuaXuLy5 pTbdKetQuaXuLy5);

	TbdKetQuaXuLy5 getTbdKetQuaXuLy5(Long pTbdKetQuaXuLy5Id);

	boolean deleteTbdKetQuaXuLy5ById(Long pTbdKetQuaXuLy5Id);

	long countAllTbdKetQuaXuLy5();

	List<TbdKetQuaXuLy5> searchTbdKetQuaXuLy5s(TbdKetQuaXuLy5SearchItem item);
	long countSearchTbdKetQuaXuLy5(TbdKetQuaXuLy5SearchItem item);

	List<TbdKetQuaXuLy5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdKetQuaXuLy5s(TbdKetQuaXuLy5SearchItem item);


	public TbdKetQuaXuLy5 findByIdHSAndIdKQ(long idHS, long idKQ);


	public List<TbdKetQuaXuLy5> findByIdHS(long idHS);

}


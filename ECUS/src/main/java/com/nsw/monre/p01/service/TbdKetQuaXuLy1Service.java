package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdKetQuaXuLy1;
import com.nsw.monre.p01.searchitem.TbdKetQuaXuLy1SearchItem;



public interface TbdKetQuaXuLy1Service {

	List<TbdKetQuaXuLy1> getTbdKetQuaXuLy1s(int pageIndex, int pageSize, String sort);

	List<TbdKetQuaXuLy1> getTbdKetQuaXuLy1s();

	TbdKetQuaXuLy1 saveTbdKetQuaXuLy1(TbdKetQuaXuLy1 pTbdKetQuaXuLy1);

	TbdKetQuaXuLy1 updateTbdKetQuaXuLy1(Long pTbdKetQuaXuLy1Id, TbdKetQuaXuLy1 pTbdKetQuaXuLy1);

	TbdKetQuaXuLy1 getTbdKetQuaXuLy1(Long pTbdKetQuaXuLy1Id);

	boolean deleteTbdKetQuaXuLy1ById(Long pTbdKetQuaXuLy1Id);

	long countAllTbdKetQuaXuLy1();

	List<TbdKetQuaXuLy1> searchTbdKetQuaXuLy1s(TbdKetQuaXuLy1SearchItem item);
	long countSearchTbdKetQuaXuLy1(TbdKetQuaXuLy1SearchItem item);

	List<TbdKetQuaXuLy1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdKetQuaXuLy1s(TbdKetQuaXuLy1SearchItem item);


	public TbdKetQuaXuLy1 findByIdHSAndIdKQ(long idHS, long idKQ);


	public List<TbdKetQuaXuLy1> findByIdHS(long idHS);

}


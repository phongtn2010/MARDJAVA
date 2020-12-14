package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdThanhToan1;
import com.nsw.monre.p01.searchitem.TbdThanhToan1SearchItem;



public interface TbdThanhToan1Service {

	List<TbdThanhToan1> getTbdThanhToan1s(int pageIndex, int pageSize, String sort);

	List<TbdThanhToan1> getTbdThanhToan1s();

	TbdThanhToan1 saveTbdThanhToan1(TbdThanhToan1 pTbdThanhToan1);

	TbdThanhToan1 updateTbdThanhToan1(Long pTbdThanhToan1Id, TbdThanhToan1 pTbdThanhToan1);

	TbdThanhToan1 getTbdThanhToan1(Long pTbdThanhToan1Id);

	boolean deleteTbdThanhToan1ById(Long pTbdThanhToan1Id);

	long countAllTbdThanhToan1();

	List<TbdThanhToan1> searchTbdThanhToan1s(TbdThanhToan1SearchItem item);
	long countSearchTbdThanhToan1(TbdThanhToan1SearchItem item);

	List<TbdThanhToan1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdThanhToan1s(TbdThanhToan1SearchItem item);


	public List<TbdThanhToan1> findByIdHS(long idHS);

}


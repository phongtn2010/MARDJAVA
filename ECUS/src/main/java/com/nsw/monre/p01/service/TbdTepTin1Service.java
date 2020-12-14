package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdTepTin1;
import com.nsw.monre.p01.searchitem.TbdTepTin1SearchItem;



public interface TbdTepTin1Service {

	List<TbdTepTin1> getTbdTepTin1s(int pageIndex, int pageSize, String sort);

	List<TbdTepTin1> getTbdTepTin1s();

	TbdTepTin1 saveTbdTepTin1(TbdTepTin1 pTbdTepTin1);

	TbdTepTin1 updateTbdTepTin1(Long pTbdTepTin1Id, TbdTepTin1 pTbdTepTin1);

	TbdTepTin1 getTbdTepTin1(Long pTbdTepTin1Id);

	boolean deleteTbdTepTin1ById(Long pTbdTepTin1Id);

	long countAllTbdTepTin1();

	List<TbdTepTin1> searchTbdTepTin1s(TbdTepTin1SearchItem item);
	long countSearchTbdTepTin1(TbdTepTin1SearchItem item);

	List<TbdTepTin1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdTepTin1s(TbdTepTin1SearchItem item);


	public List<TbdTepTin1> findByIdHSOrderByLoaiTepTinAsc(long idHS);

}


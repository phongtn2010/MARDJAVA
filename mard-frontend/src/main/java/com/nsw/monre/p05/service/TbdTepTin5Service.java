package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdTepTin5;
import com.nsw.monre.p05.searchitem.TbdTepTin5SearchItem;



public interface TbdTepTin5Service {

	List<TbdTepTin5> getTbdTepTin5s(int pageIndex, int pageSize, String sort);

	List<TbdTepTin5> getTbdTepTin5s();

	TbdTepTin5 saveTbdTepTin5(TbdTepTin5 pTbdTepTin5);

	TbdTepTin5 updateTbdTepTin5(Long pTbdTepTin5Id, TbdTepTin5 pTbdTepTin5);

	TbdTepTin5 getTbdTepTin5(Long pTbdTepTin5Id);

	boolean deleteTbdTepTin5ById(Long pTbdTepTin5Id);

	long countAllTbdTepTin5();

	List<TbdTepTin5> searchTbdTepTin5s(TbdTepTin5SearchItem item);
	long countSearchTbdTepTin5(TbdTepTin5SearchItem item);

	List<TbdTepTin5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdTepTin5s(TbdTepTin5SearchItem item);


	public List<TbdTepTin5> findByIdHSOrderByLoaiTepTinAsc(long idHS);

}


package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdThongTinPheLieu1;
import com.nsw.monre.p01.searchitem.TbdThongTinPheLieu1SearchItem;



public interface TbdThongTinPheLieu1Service {

	List<TbdThongTinPheLieu1> getTbdThongTinPheLieu1s(int pageIndex, int pageSize, String sort);

	List<TbdThongTinPheLieu1> getTbdThongTinPheLieu1s();

	TbdThongTinPheLieu1 saveTbdThongTinPheLieu1(TbdThongTinPheLieu1 pTbdThongTinPheLieu1);

	TbdThongTinPheLieu1 updateTbdThongTinPheLieu1(Long pTbdThongTinPheLieu1Id, TbdThongTinPheLieu1 pTbdThongTinPheLieu1);

	TbdThongTinPheLieu1 getTbdThongTinPheLieu1(Long pTbdThongTinPheLieu1Id);

	boolean deleteTbdThongTinPheLieu1ById(Long pTbdThongTinPheLieu1Id);

	long countAllTbdThongTinPheLieu1();

	List<TbdThongTinPheLieu1> searchTbdThongTinPheLieu1s(TbdThongTinPheLieu1SearchItem item);
	long countSearchTbdThongTinPheLieu1(TbdThongTinPheLieu1SearchItem item);

	List<TbdThongTinPheLieu1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdThongTinPheLieu1s(TbdThongTinPheLieu1SearchItem item);


	public List<TbdThongTinPheLieu1> findByIdHS(long idHS);


	public List<TbdThongTinPheLieu1> findByIdHSOrderByIdPLAsc(long idHS);


	public TbdThongTinPheLieu1 findByMaHS(String maHS);

}


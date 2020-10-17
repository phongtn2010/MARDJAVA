package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdThongTinPheLieu5;
import com.nsw.monre.p05.searchitem.TbdThongTinPheLieu5SearchItem;



public interface TbdThongTinPheLieu5Service {

	List<TbdThongTinPheLieu5> getTbdThongTinPheLieu5s(int pageIndex, int pageSize, String sort);

	List<TbdThongTinPheLieu5> getTbdThongTinPheLieu5s();

	TbdThongTinPheLieu5 saveTbdThongTinPheLieu5(TbdThongTinPheLieu5 pTbdThongTinPheLieu5);

	TbdThongTinPheLieu5 updateTbdThongTinPheLieu5(Long pTbdThongTinPheLieu5Id, TbdThongTinPheLieu5 pTbdThongTinPheLieu5);

	TbdThongTinPheLieu5 getTbdThongTinPheLieu5(Long pTbdThongTinPheLieu5Id);

	boolean deleteTbdThongTinPheLieu5ById(Long pTbdThongTinPheLieu5Id);

	long countAllTbdThongTinPheLieu5();

	List<TbdThongTinPheLieu5> searchTbdThongTinPheLieu5s(TbdThongTinPheLieu5SearchItem item);
	long countSearchTbdThongTinPheLieu5(TbdThongTinPheLieu5SearchItem item);

	List<TbdThongTinPheLieu5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdThongTinPheLieu5s(TbdThongTinPheLieu5SearchItem item);


	public List<TbdThongTinPheLieu5> findByIdHS(long idHS);


	public List<TbdThongTinPheLieu5> findByIdHSOrderByIdPLAsc(long idHS);


	public TbdThongTinPheLieu5 findByMaHS(String maHS);

}


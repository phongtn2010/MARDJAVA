package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdThongTinCoSoSX5;
import com.nsw.monre.p05.searchitem.TbdThongTinCoSoSX5SearchItem;



public interface TbdThongTinCoSoSX5Service {

	List<TbdThongTinCoSoSX5> getTbdThongTinCoSoSX5s(int pageIndex, int pageSize, String sort);

	List<TbdThongTinCoSoSX5> getTbdThongTinCoSoSX5s();

	TbdThongTinCoSoSX5 saveTbdThongTinCoSoSX5(TbdThongTinCoSoSX5 pTbdThongTinCoSoSX5);

	TbdThongTinCoSoSX5 updateTbdThongTinCoSoSX5(Long pTbdThongTinCoSoSX5Id, TbdThongTinCoSoSX5 pTbdThongTinCoSoSX5);

	TbdThongTinCoSoSX5 getTbdThongTinCoSoSX5(Long pTbdThongTinCoSoSX5Id);

	boolean deleteTbdThongTinCoSoSX5ById(Long pTbdThongTinCoSoSX5Id);

	long countAllTbdThongTinCoSoSX5();

	List<TbdThongTinCoSoSX5> searchTbdThongTinCoSoSX5s(TbdThongTinCoSoSX5SearchItem item);
	long countSearchTbdThongTinCoSoSX5(TbdThongTinCoSoSX5SearchItem item);

	List<TbdThongTinCoSoSX5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdThongTinCoSoSX5s(TbdThongTinCoSoSX5SearchItem item);


	public List<TbdThongTinCoSoSX5> findByIdHS(long idHS);


	public List<TbdThongTinCoSoSX5> findByIdHSOrderByTbdThongTinCoSoSXIdAsc(long idHS);


	public List<TbdThongTinCoSoSX5> findByIdCS(long idCS);


	public TbdThongTinCoSoSX5 findByIdHSAndIdCS(long idHS, long idCS);

}


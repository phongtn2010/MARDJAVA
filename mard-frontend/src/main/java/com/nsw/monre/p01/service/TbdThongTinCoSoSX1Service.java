package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdThongTinCoSoSX1;
import com.nsw.monre.p01.searchitem.TbdThongTinCoSoSX1SearchItem;



public interface TbdThongTinCoSoSX1Service {

	List<TbdThongTinCoSoSX1> getTbdThongTinCoSoSX1s(int pageIndex, int pageSize, String sort);

	List<TbdThongTinCoSoSX1> getTbdThongTinCoSoSX1s();

	TbdThongTinCoSoSX1 saveTbdThongTinCoSoSX1(TbdThongTinCoSoSX1 pTbdThongTinCoSoSX1);

	TbdThongTinCoSoSX1 updateTbdThongTinCoSoSX1(Long pTbdThongTinCoSoSX1Id, TbdThongTinCoSoSX1 pTbdThongTinCoSoSX1);

	TbdThongTinCoSoSX1 getTbdThongTinCoSoSX1(Long pTbdThongTinCoSoSX1Id);

	boolean deleteTbdThongTinCoSoSX1ById(Long pTbdThongTinCoSoSX1Id);

	long countAllTbdThongTinCoSoSX1();

	List<TbdThongTinCoSoSX1> searchTbdThongTinCoSoSX1s(TbdThongTinCoSoSX1SearchItem item);
	long countSearchTbdThongTinCoSoSX1(TbdThongTinCoSoSX1SearchItem item);

	List<TbdThongTinCoSoSX1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdThongTinCoSoSX1s(TbdThongTinCoSoSX1SearchItem item);


	public List<TbdThongTinCoSoSX1> findByIdHS(long idHS);


	public List<TbdThongTinCoSoSX1> findByIdHSOrderByTbdThongTinCoSoSXIdAsc(long idHS);


	public List<TbdThongTinCoSoSX1> findByIdCS(long idCS);


	public TbdThongTinCoSoSX1 findByIdHSAndIdCS(long idHS, long idCS);

}


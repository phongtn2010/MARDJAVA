package com.nsw.monre.p05.service;

import java.util.List;
import com.nsw.monre.p05.model.TbdCapGiayXacNhan5;
import com.nsw.monre.p05.searchitem.TbdCapGiayXacNhan5SearchItem;



public interface TbdCapGiayXacNhan5Service {

	List<TbdCapGiayXacNhan5> getTbdCapGiayXacNhan5s(int pageIndex, int pageSize, String sort);

	List<TbdCapGiayXacNhan5> getTbdCapGiayXacNhan5s();

	TbdCapGiayXacNhan5 saveTbdCapGiayXacNhan5(TbdCapGiayXacNhan5 pTbdCapGiayXacNhan5);

	TbdCapGiayXacNhan5 updateTbdCapGiayXacNhan5(Long pTbdCapGiayXacNhan5Id, TbdCapGiayXacNhan5 pTbdCapGiayXacNhan5);

	TbdCapGiayXacNhan5 getTbdCapGiayXacNhan5(Long pTbdCapGiayXacNhan5Id);

	boolean deleteTbdCapGiayXacNhan5ById(Long pTbdCapGiayXacNhan5Id);

	long countAllTbdCapGiayXacNhan5();

	List<TbdCapGiayXacNhan5> searchTbdCapGiayXacNhan5s(TbdCapGiayXacNhan5SearchItem item);
	long countSearchTbdCapGiayXacNhan5(TbdCapGiayXacNhan5SearchItem item);

	List<TbdCapGiayXacNhan5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdCapGiayXacNhan5s(TbdCapGiayXacNhan5SearchItem item);


	public List<TbdCapGiayXacNhan5> findByIdHSOrderByIdGxnDesc(long idHS);


	public List<TbdCapGiayXacNhan5> findByIdHS(long idHS);


	public List<TbdCapGiayXacNhan5> findBySoGiayXNAndMaSoThueOrderByIdGxnDesc(String soGiayXN, String maSoThue);


	public List<TbdCapGiayXacNhan5> findBySoGiayXNOrderByIdGxnDesc(String soGiayXN);


	public List<TbdCapGiayXacNhan5> findBySoGiayXNAndHinhThucAndMaSoThueOrderByIdGxnDesc(String soGiayXN, long hinhThuc, String maSoThue);

}


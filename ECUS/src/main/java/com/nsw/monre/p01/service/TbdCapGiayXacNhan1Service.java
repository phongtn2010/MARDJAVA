package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbdCapGiayXacNhan1;
import com.nsw.monre.p01.searchitem.TbdCapGiayXacNhan1SearchItem;



public interface TbdCapGiayXacNhan1Service {

	List<TbdCapGiayXacNhan1> getTbdCapGiayXacNhan1s(int pageIndex, int pageSize, String sort);

	List<TbdCapGiayXacNhan1> getTbdCapGiayXacNhan1s();

	TbdCapGiayXacNhan1 saveTbdCapGiayXacNhan1(TbdCapGiayXacNhan1 pTbdCapGiayXacNhan1);

	TbdCapGiayXacNhan1 updateTbdCapGiayXacNhan1(Long pTbdCapGiayXacNhan1Id, TbdCapGiayXacNhan1 pTbdCapGiayXacNhan1);

	TbdCapGiayXacNhan1 getTbdCapGiayXacNhan1(Long pTbdCapGiayXacNhan1Id);

	boolean deleteTbdCapGiayXacNhan1ById(Long pTbdCapGiayXacNhan1Id);

	long countAllTbdCapGiayXacNhan1();

	List<TbdCapGiayXacNhan1> searchTbdCapGiayXacNhan1s(TbdCapGiayXacNhan1SearchItem item);
	long countSearchTbdCapGiayXacNhan1(TbdCapGiayXacNhan1SearchItem item);

	List<TbdCapGiayXacNhan1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdCapGiayXacNhan1s(TbdCapGiayXacNhan1SearchItem item);


	public List<TbdCapGiayXacNhan1> findByIdHSOrderByIdGxnDesc(long idHS);


	public List<TbdCapGiayXacNhan1> findByIdHS(long idHS);


	public List<TbdCapGiayXacNhan1> findBySoGiayXNOrderByIdGxnDesc(String soGiayXN);


	public List<TbdCapGiayXacNhan1> findBySoGiayXNAndHinhThucAndMaSoThueOrderByIdGxnDesc(String soGiayXN, long hinhThuc, String maSoThue);

}


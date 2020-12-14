package com.nsw.monre.p01.service;

import java.util.List;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;
import com.nsw.monre.p01.searchitem.TbsCoQuanXuLy1SearchItem;



public interface TbsCoQuanXuLy1Service {

	List<TbsCoQuanXuLy1> getTbsCoQuanXuLy1s(int pageIndex, int pageSize, String sort);

	List<TbsCoQuanXuLy1> getTbsCoQuanXuLy1s();

	TbsCoQuanXuLy1 saveTbsCoQuanXuLy1(TbsCoQuanXuLy1 pTbsCoQuanXuLy1);

	TbsCoQuanXuLy1 updateTbsCoQuanXuLy1(String pTbsCoQuanXuLy1Id, TbsCoQuanXuLy1 pTbsCoQuanXuLy1);

	TbsCoQuanXuLy1 getTbsCoQuanXuLy1(String pTbsCoQuanXuLy1Id);

	boolean deleteTbsCoQuanXuLy1ById(String pTbsCoQuanXuLy1Id);

	long countAllTbsCoQuanXuLy1();

	List<TbsCoQuanXuLy1> searchTbsCoQuanXuLy1s(TbsCoQuanXuLy1SearchItem item);
	long countSearchTbsCoQuanXuLy1(TbsCoQuanXuLy1SearchItem item);

	List<TbsCoQuanXuLy1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbsCoQuanXuLy1s(TbsCoQuanXuLy1SearchItem item);

}


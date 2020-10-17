package com.nsw.monre.p05.service;

import java.util.List;

import com.nsw.monre.p05.searchitem.TbdHSDeNghiCapGiayXn5SearchItem;
import com.nsw.monre.p05.model.HoSo5;
import com.nsw.monre.p05.model.TbdHSDeNghiCapGiayXn5;



public interface TbdHSDeNghiCapGiayXn5Service {

	List<TbdHSDeNghiCapGiayXn5> getTbdHSDeNghiCapGiayXn5s(int pageIndex, int pageSize, String sort);

	List<TbdHSDeNghiCapGiayXn5> getTbdHSDeNghiCapGiayXn5s();

	TbdHSDeNghiCapGiayXn5 saveTbdHSDeNghiCapGiayXn5(TbdHSDeNghiCapGiayXn5 pTbdHSDeNghiCapGiayXn5);

	TbdHSDeNghiCapGiayXn5 updateTbdHSDeNghiCapGiayXn5(Long pTbdHSDeNghiCapGiayXn5Id, TbdHSDeNghiCapGiayXn5 pTbdHSDeNghiCapGiayXn5);

	TbdHSDeNghiCapGiayXn5 getTbdHSDeNghiCapGiayXn5(Long pTbdHSDeNghiCapGiayXn5Id);

	boolean deleteTbdHSDeNghiCapGiayXn5ById(Long pTbdHSDeNghiCapGiayXn5Id);

	long countAllTbdHSDeNghiCapGiayXn5();

	List<TbdHSDeNghiCapGiayXn5> searchTbdHSDeNghiCapGiayXn5s(TbdHSDeNghiCapGiayXn5SearchItem item);
	long countSearchTbdHSDeNghiCapGiayXn5(TbdHSDeNghiCapGiayXn5SearchItem item);

	List<TbdHSDeNghiCapGiayXn5> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdHSDeNghiCapGiayXn5s(TbdHSDeNghiCapGiayXn5SearchItem item);


	public TbdHSDeNghiCapGiayXn5 findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(long idHS, String loaiThuTuc, int xoa, String maSoThue);


	public TbdHSDeNghiCapGiayXn5 findByMaHoSo(String maHoSo);


	public TbdHSDeNghiCapGiayXn5 findByIdHSAndMaHoSoAndLoaiThuTucAndXoaAndMaSoThue(long idHS, String maHoSo, String loaiThuTuc, int xoa, String maSoThue);

	List<HoSo5> search(TbdHSDeNghiCapGiayXn5SearchItem item);
	
	long count(TbdHSDeNghiCapGiayXn5SearchItem item);
}


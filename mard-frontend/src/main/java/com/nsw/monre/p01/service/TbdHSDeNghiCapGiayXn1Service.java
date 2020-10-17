package com.nsw.monre.p01.service;

import java.util.List;

import com.nsw.monre.p01.model.HoSo1;
import com.nsw.monre.p01.model.TbdHSDeNghiCapGiayXn1;
import com.nsw.monre.p01.searchitem.TbdHSDeNghiCapGiayXn1SearchItem;



public interface TbdHSDeNghiCapGiayXn1Service {

	List<TbdHSDeNghiCapGiayXn1> getTbdHSDeNghiCapGiayXn1s(int pageIndex, int pageSize, String sort);

	List<TbdHSDeNghiCapGiayXn1> getTbdHSDeNghiCapGiayXn1s();

	TbdHSDeNghiCapGiayXn1 saveTbdHSDeNghiCapGiayXn1(TbdHSDeNghiCapGiayXn1 pTbdHSDeNghiCapGiayXn1);

	TbdHSDeNghiCapGiayXn1 updateTbdHSDeNghiCapGiayXn1(Long pTbdHSDeNghiCapGiayXn1Id, TbdHSDeNghiCapGiayXn1 pTbdHSDeNghiCapGiayXn1);

	TbdHSDeNghiCapGiayXn1 getTbdHSDeNghiCapGiayXn1(Long pTbdHSDeNghiCapGiayXn1Id);

	boolean deleteTbdHSDeNghiCapGiayXn1ById(Long pTbdHSDeNghiCapGiayXn1Id);

	long countAllTbdHSDeNghiCapGiayXn1();

	List<TbdHSDeNghiCapGiayXn1> searchTbdHSDeNghiCapGiayXn1s(TbdHSDeNghiCapGiayXn1SearchItem item);
	long countSearchTbdHSDeNghiCapGiayXn1(TbdHSDeNghiCapGiayXn1SearchItem item);

	List<TbdHSDeNghiCapGiayXn1> callStoreMappingToModel( Object[] paramInputs);

	Object callStoreNoMappingToModel(Object[] paramInputs);

	boolean deleteBySearchItemTbdHSDeNghiCapGiayXn1s(TbdHSDeNghiCapGiayXn1SearchItem item);


	public TbdHSDeNghiCapGiayXn1 findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(long idHS, String loaiThuTuc, int xoa, String maSoThue);


	public TbdHSDeNghiCapGiayXn1 findByMaHoSo(String maHoSo);


	public TbdHSDeNghiCapGiayXn1 findByIdHSAndMaHoSoAndLoaiThuTucAndXoaAndMaSoThue(long idHS, String maHoSo, String loaiThuTuc, int xoa, String maSoThue);

	List<HoSo1> search(TbdHSDeNghiCapGiayXn1SearchItem item);
	
	long count(TbdHSDeNghiCapGiayXn1SearchItem item);
}


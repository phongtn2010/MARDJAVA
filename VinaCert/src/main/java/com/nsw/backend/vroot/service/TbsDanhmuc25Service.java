package com.nsw.backend.vroot.service;


import com.nsw.backend.vroot.model.TBSDANHMUC25;

import java.util.List;

public interface TbsDanhmuc25Service {
    public List<TBSDANHMUC25> findByFiCatNoOrderByFiOrder(Long fiCatNo);
    public List<TBSDANHMUC25> findByFiCatParentOrderByFiOrder(Long id);
    public Long findFiMaxCatTypeByFiCatNo(Long fiCatNo);
    void save(TBSDANHMUC25 tbsdanhmuc25);
    public List<TBSDANHMUC25> findByFiCatNoAndFiCatType(Long fiCatNo, Long fiCatType);
    public List<TBSDANHMUC25> findByFiCatNoAndFiCatNote(Long fiCatNo, String fiCatNote);
    void delete(TBSDANHMUC25 tbsdanhmuc25);
}

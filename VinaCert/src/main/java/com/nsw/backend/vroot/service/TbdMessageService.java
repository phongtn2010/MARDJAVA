package com.nsw.backend.vroot.service;

import com.nsw.backend.vroot.model.TbdMessage;

import java.util.List;

public interface TbdMessageService {
    public void updateAll(List<TbdMessage> tbdMessageList);
    public TbdMessage update(TbdMessage tbdMessageList);
    public List<TbdMessage> findByFiTrangThai(Long fiTrangThai);
    public List<TbdMessage> findTOP20ByFiTrangthai(Long fiTrangThai);
}

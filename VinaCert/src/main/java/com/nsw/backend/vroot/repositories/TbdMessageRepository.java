package com.nsw.backend.vroot.repositories;

import com.nsw.backend.vroot.model.TbdMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TbdMessageRepository extends JpaRepository<TbdMessage, Long>, JpaSpecificationExecutor<TbdMessage> {
    public List<TbdMessage> findByFiTrangthai(Long fiTrangThai);
    public List<TbdMessage> findTOP20ByFiTrangthai(Long fiTrangThai);
}
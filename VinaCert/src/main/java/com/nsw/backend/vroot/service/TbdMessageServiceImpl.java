package com.nsw.backend.vroot.service;

import com.nsw.backend.vroot.model.TbdMessage;
import com.nsw.backend.vroot.repositories.TbdMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TbdMessageServiceImpl implements TbdMessageService {

    @Autowired
    private TbdMessageRepository tbdMessageRepository;

    @Override
    public void updateAll(List<TbdMessage> tbdMessageList) {
        tbdMessageRepository.save(tbdMessageList);
    }

    @Override
    public TbdMessage update(TbdMessage tbdMessageList) {
        return tbdMessageRepository.save(tbdMessageList);
    }

    @Override
    public List<TbdMessage> findByFiTrangThai(Long fiTrangThai) {
        return tbdMessageRepository.findByFiTrangthai(fiTrangThai);
    }

    @Override
    public List<TbdMessage> findTOP20ByFiTrangthai(Long fiTrangThai) {
        return tbdMessageRepository.findTOP20ByFiTrangthai(fiTrangThai);
    }

}

package com.nsw.backend.mard.p07.service;

import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.mard.p07.model.TbdLichsu07;
import com.nsw.backend.mard.p07.repositories.TbdLichsu07Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbdLichsu07ServiceImpl implements TbdLichsu07Service {

    private final TbdLichsu07Repository hstRepository;

    @Autowired
    public TbdLichsu07ServiceImpl(TbdLichsu07Repository hstRepository) {
        this.hstRepository = hstRepository;
    }

    @Override
    public TbdLichsu07 findById(long fiIdLichsu) {
        return hstRepository.findByFiIdHst((int) fiIdLichsu).orElse(null);
    }

    @Override
    public List<TbdLichsu07> findAll() {
        return hstRepository.findAll();
    }

    @Override
    public TbdLichsu07 save(TbdLichsu07 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public TbdLichsu07 update(TbdLichsu07 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public TbdLichsu07 create(TbdLichsu07 entity) {
        return hstRepository.save(entity);
    }

    @Override
    public List<TbdLichsu07> findByIdHS(long id) {
        return hstRepository.findByFiIdHS((int) id);
    }

    @Override
    public List<TbdLichsu07> findByHSCode(String fiMaHoso) {
        return hstRepository.findByFiHSCodeOrderByFiCreatedDateDesc(fiMaHoso);
    }

    @Override
    public void createHistory(TbdHoso07 profile, String hstContent) {
        TbdLichsu07 profileHst = new TbdLichsu07();
        profileHst.setFiIdHS(profile.getFiIdHS());
        profileHst.setFiHSCode(profile.getFiNSWFileCode());
        profileHst.setFiStatus(profile.getFiHSStatus());
        profileHst.setFiSenderCode(profile.getFiCreatedBy());
        profileHst.setFiContent(hstContent);
        profileHst.setFiCreatedBy(profile.getFiSignName());
        profileHst.setFiSenderUnitName(profile.getFiNameOfRegistration());
        profileHst.setFiSenderName(profile.getFiTaxCode());
        this.save(profileHst);
    }

    @Override
    public Page<TbdLichsu07> findByHSCodeAndPagable(String fiHSCode, Pageable pageRequest) {
        return hstRepository.findByFiHSCodeOrderByFiIdHstDesc(fiHSCode, pageRequest);
    }
}

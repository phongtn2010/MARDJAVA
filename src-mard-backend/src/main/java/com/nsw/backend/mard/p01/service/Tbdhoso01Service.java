package com.nsw.backend.mard.p01.service;


import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p01.dto.RequestProEdit;
import com.nsw.backend.mard.p01.exception.NSWException;
import com.nsw.backend.mard.p01.model.FilterForm;
import com.nsw.backend.mard.p01.model.FilterResult;
import com.nsw.backend.mard.p01.model.Tbdhoso01;
import com.nsw.backend.mard.p01.model.Tbdycrut01;

public interface Tbdhoso01Service {
    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    Tbdhoso01 create(Tbdhoso01 entity);


    Tbdhoso01 save(Tbdhoso01 entity);


    Tbdhoso01 findById(Long fiIdHS);


    Tbdhoso01 update(Tbdhoso01 entity);

    Tbdhoso01 updateAfterSendNSW(RequestProEdit requestProEdit) throws NSWException;

    FilterResult searchHoso(FilterForm filter);

    /**
     * Tìm hồ sơ theo mã hồ sơ
     *
     * @param fiMaHoso
     * @return
     */
    Tbdhoso01 findByFiHSCode(String fiMaHoso);

    Tbdycrut01 cancelHoso(Tbdycrut01 ruts01) throws NSWException;

    void internalStatusUpdate(Tbdhoso01 regProfile, long status);

    void rollbackFailedRequestUpdate(Tbdhoso01 result);

    void rollbackFailedRequestUpdate(String nswFileCode);

    LoadingCache<String, Boolean> getSignPendingProfiles();
}

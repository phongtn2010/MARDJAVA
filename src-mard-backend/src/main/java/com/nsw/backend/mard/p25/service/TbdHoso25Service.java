package com.nsw.backend.mard.p25.service;

import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p25.model.*;
import com.nsw.backend.mard.p25.exception.NSWException;

import java.util.List;

public interface TbdHoso25Service {
    LoadingCache<String, Boolean> getSignPendingProfiles();

    /**
     * Loads an entity from the database using its Primary Key
     *
     * @param fiIdHoso
     * @return entity
     */
    TbdHoso25 findById(int fiIdHoso);
    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<TbdHoso25> findAll();
    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    TbdHoso25 save(TbdHoso25 entity);
    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    TbdHoso25 update(TbdHoso25 entity);
    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    TbdHoso25 create(TbdHoso25 entity);
    /**
     * Deletes an entity using its Primary Key
     *
     * @param fiIdHoso
     */
    void delete(int fiIdHoso);
    /**
     * Deletes an entity
     *
     * @param entity
     */
    void  delete(TbdHoso25 entity);
    /**
     * @param fiIdHoso
     * @return
     */
    TbdHoso25 getInfoById(int fiIdHoso);
    /**
     * Cập nhập trạng thái hồ sơ
     *
     * @param fiMaHoso
     * @param fiTrangthai
     * @return
     */
    boolean updateStatus(String fiMaHoso, int fiTrangthai);
    /**
     * Chỉnh sửa hồ sơ đã gửi qua NSW ( đã gửi qua BNN xử lý
     *
     * @param hoso
     * @return
     */
    TbdHoso25 updateAfterSendNSW(TbdHoso25 hoso) throws NSWException;

    void rollbackFailedRequestUpdate(String nswFileCode);
    /**
     * Yêu cầu rút hồ sơ
     *
     * @param cancelRequest
     * @return
     */
    TbdYcrut25 cancelHoso(TbdYcrut25 cancelRequest);
    /**
     * Tìm kiếm hồ sơ theo điều kiện
     *
     * @param filter điều kiện tìm kiếm
     * @return
     */
    FilterResult searchHoso(FilterForm filter);
    /**
     * Tìm hồ sơ theo mã hồ sơ
     *
     * @param fiMaHoso
     * @return
     */
    TbdHoso25 findByFiHSCode(String fiMaHoso);

    List<TbdHoso25> findAllByFiHSStatus(int fiHSStatus);

    void internalStatusUpdate(TbdHoso25 egProfile, int status);

    void rollbackFailedRequestUpdate(TbdHoso25  result);
    List<TbdHoso25> findByFiHSStatus(String taxCode,Integer from, Integer to);

}

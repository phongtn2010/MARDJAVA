package com.nsw.backend.mard.p07.service;

import com.google.common.cache.LoadingCache;
import com.nsw.backend.mard.p07.exception.NSWException;
import com.nsw.backend.mard.p07.model.FilterForm;
import com.nsw.backend.mard.p07.model.FilterResult;
import com.nsw.backend.mard.p07.model.TbdHoso07;
import com.nsw.backend.mard.p07.model.TbdYcrut07;

import java.util.List;

/**
 * Business Service Interface for entity Tbdhoso08.
 */
public interface TbdHoso07Service {

    /**
     * Loads an entity from the database using its Primary Key
     *
     * @param fiIdHoso
     * @return entity
     */
    TbdHoso07 findById(int fiIdHoso);

    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<TbdHoso07> findAll();

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    TbdHoso07 save(TbdHoso07 entity);

    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    TbdHoso07 update(TbdHoso07 entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    TbdHoso07 create(TbdHoso07 entity);

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
    void delete(TbdHoso07 entity);

    /**
     * @param fiIdHoso
     * @return
     */
    TbdHoso07 getInfoById(int fiIdHoso);

    /**
     * Chỉnh sửa hồ sơ đã gửi qua NSW ( đã gửi qua BNN xử lý
     *
     * @param hoso
     * @return
     */
    TbdHoso07 updateAfterSendNSW(TbdHoso07 hoso) throws NSWException;

    /**
     * Yêu cầu rút hồ sơ
     * @param cancelRequest
     * @return
     */

//    TbdYcrut06 cancelHoso(TbdYcrut06 cancelRequest);

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
    TbdHoso07 findByFiHSCode(String fiMaHoso);

    TbdHoso07 saveDraftTbdHoso(TbdHoso07 regProfile);

    TbdYcrut07 cancelHoso(TbdYcrut07 cancelRequest);

    void rollbackFailedRequestUpdate(TbdHoso07 result);

    void rollbackFailedRequestUpdate(String nswFileCode);

    LoadingCache<String, Boolean> getSignPendingProfiles();
}

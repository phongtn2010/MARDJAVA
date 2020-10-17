package com.nsw.backend.mard.p01.service;

import com.nsw.backend.mard.p01.model.Tbdlichsu01;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Business Service Interface for entity Tbdlichsu08.
 */
public interface Tbdlichsu01Service {

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    Tbdlichsu01 save(Tbdlichsu01 entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    Tbdlichsu01 create(Tbdlichsu01 entity);

    List<Tbdlichsu01> findByHSCode(String fiMaHoso);

    Page<Tbdlichsu01> findByHSCodeAndPagable(String fiNSWFileCode, Pageable pageRequest);
}

package com.nsw.backend.mard.p09.service;

import com.nsw.backend.mard.p09.model.Tbdlichsu09;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Business Service Interface for entity Tbdlichsu09.
 */
public interface Tbdlichsu09Service {

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    Tbdlichsu09 save(Tbdlichsu09 entity);

    List<Tbdlichsu09> findByHSCode(String fiMaHoso);

    Page<Tbdlichsu09> findByHSCodeAndPagable(String fiMaHoso, Pageable pageable);
}

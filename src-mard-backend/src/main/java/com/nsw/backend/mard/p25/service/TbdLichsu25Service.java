package com.nsw.backend.mard.p25.service;

import com.nsw.backend.mard.p25.model.TbdLichsu25;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Business Service Interface for entity TbdLichsu25.
 */
public interface TbdLichsu25Service {
    /**
     * Loads an entity from the database using its Primary Key
     *
     * @param fiIdLichsu
     * @return entity
     */
    TbdLichsu25 findById(Long fiIdLichsu);

    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<TbdLichsu25> findAll();

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    TbdLichsu25 save(TbdLichsu25 entity);

    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    TbdLichsu25 update(TbdLichsu25 entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    TbdLichsu25 create(TbdLichsu25 entity);

    List<TbdLichsu25> findByIdHS(long id);

    List<TbdLichsu25> findByHSCode(String fiMaHoso);

    Page<TbdLichsu25> findByHSCodeAndPagable(String fiHSCode, PageRequest pageRequest);
}

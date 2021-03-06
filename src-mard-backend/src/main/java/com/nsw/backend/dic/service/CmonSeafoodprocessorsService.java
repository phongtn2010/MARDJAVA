/*
 * Created on 25 Jul 2017 ( Time 08:16:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonSeafoodprocessors;
import java.util.List;

/**
 * Business Service Interface for entity CmonSeafoodprocessors.
 */
public interface CmonSeafoodprocessorsService {

    /**
     * Loads an entity from the database using its Primary Key
     *
     * @param id
     * @return entity
     */
    CmonSeafoodprocessors findById(Long id);

    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<CmonSeafoodprocessors> findAll();

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    CmonSeafoodprocessors save(CmonSeafoodprocessors entity);

    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonSeafoodprocessors update(CmonSeafoodprocessors entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonSeafoodprocessors create(CmonSeafoodprocessors entity);

    /**
     * Deletes an entity using its Primary Key
     * @param id
     */
    void delete(Long id);

}

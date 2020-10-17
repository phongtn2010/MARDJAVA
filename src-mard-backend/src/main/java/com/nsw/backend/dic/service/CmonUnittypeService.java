/*
 * Created on 25 Jul 2017 ( Time 08:17:30 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonUnittype;
import java.util.List;

/**
 * Business Service Interface for entity CmonUnittype.
 */
public interface CmonUnittypeService {

    /**
     * Loads an entity from the database using its Primary Key
     *
     * @param id
     * @return entity
     */
    CmonUnittype findById(Long id);

    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<CmonUnittype> findAll();

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    CmonUnittype save(CmonUnittype entity);

    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonUnittype update(CmonUnittype entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonUnittype create(CmonUnittype entity);

    /**
     * Deletes an entity using its Primary Key
     * @param id
     */
    void delete(Long id);

}

/*
 * Created on 25 Jul 2017 ( Time 08:17:14 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonTransitiondepartment;
import java.util.List;

/**
 * Business Service Interface for entity CmonTransitiondepartment.
 */
public interface CmonTransitiondepartmentService {

    /**
     * Loads an entity from the database using its Primary Key
     *
     * @param id
     * @return entity
     */
    CmonTransitiondepartment findById(Long id);

    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<CmonTransitiondepartment> findAll();

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    CmonTransitiondepartment save(CmonTransitiondepartment entity);

    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonTransitiondepartment update(CmonTransitiondepartment entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonTransitiondepartment create(CmonTransitiondepartment entity);

    /**
     * Deletes an entity using its Primary Key
     * @param id
     */
    void delete(Long id);

}

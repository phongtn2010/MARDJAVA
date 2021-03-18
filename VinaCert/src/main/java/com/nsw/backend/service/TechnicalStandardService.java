/*
 * Created on 29 Mar 2017 ( Time 14:05:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.nsw.backend.service;

import com.nsw.backend.model.TechnicalStandard;
import java.util.List;

/**
 * Business Service Interface for entity TechnicalStandard.
 */
public interface TechnicalStandardService {

    /**
     * Loads an entity from the database using its Primary Key
     *
     * @return entity
     */
    TechnicalStandard findById();

    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<TechnicalStandard> findAll();

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    TechnicalStandard save(TechnicalStandard entity);

    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    TechnicalStandard update(TechnicalStandard entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    TechnicalStandard create(TechnicalStandard entity);

    /**
     * Deletes an entity using its Primary Key
     */
    void delete();
    /**
     * Find by Role
     * @param roleId
     * @return 
     */
    List<TechnicalStandard> findByRole(Long roleId);
}
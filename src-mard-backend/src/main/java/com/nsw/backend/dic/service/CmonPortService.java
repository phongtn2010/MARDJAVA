/*
 * Created on 25 Jul 2017 ( Time 08:16:36 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.nsw.backend.dic.service;

import com.nsw.backend.dic.model.CmonPort;
import java.util.List;

/**
 * Business Service Interface for entity CmonPort.
 */
public interface CmonPortService {

    /**
     * Loads an entity from the database using its Primary Key
     *
     * @param id
     * @return entity
     */
    CmonPort findById(Long id);

    /**
     * Loads all entities.
     *
     * @return all entities
     */
    List<CmonPort> findAll();

    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    CmonPort save(CmonPort entity);

    /**
     * Updates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonPort update(CmonPort entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    CmonPort create(CmonPort entity);

    /**
     * Deletes an entity using its Primary Key
     *
     * @param id
     */
    void delete(Long id);

    /**
     *
     * @param countryCode
     * @return
     */
    List<CmonPort> findByCountryCode(String countryCode);

    List<CmonPort> findWithOutCountryCode(String countryCode);

    CmonPort findByPortCode(String portCode);
}

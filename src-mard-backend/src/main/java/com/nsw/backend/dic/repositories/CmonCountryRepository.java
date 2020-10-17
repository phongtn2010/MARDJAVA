/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CmonCountryRepository extends JpaRepository<CmonCountry, Long> {
    Optional<CmonCountry> findByCountrycode(String countryCode);
    Optional<CmonCountry> findFirstByCountrycode(String countryCode);
}

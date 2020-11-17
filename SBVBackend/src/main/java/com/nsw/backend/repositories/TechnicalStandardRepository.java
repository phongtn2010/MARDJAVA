/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.repositories;

import com.nsw.backend.model.TechnicalStandard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Phong84NV
 */
@Repository
public interface TechnicalStandardRepository extends JpaRepository<TechnicalStandard, Long> {
    List<TechnicalStandard> findByRole(Long role);
}

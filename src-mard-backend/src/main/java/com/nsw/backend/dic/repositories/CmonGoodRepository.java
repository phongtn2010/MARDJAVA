/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonGood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CmonGoodRepository extends JpaRepository<CmonGood, Long> {
    
}

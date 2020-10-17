/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonUnit;
import java.util.List;


public interface CmonUnitRepositoryCustom {

    public List<CmonUnit> findByUnittypeid(Long unittypeid);

    public List<CmonUnit> findByUnittypeidAndSystemid(Long unittypeid, Long systemid);

}

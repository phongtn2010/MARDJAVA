/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonAttachtype;
import java.util.List;

/**
 *
 * @author phongnv
 */
public interface CmonAttachtypeRepositoryCustom {
    public List<CmonAttachtype> findBySystemId(Long systemId);
}

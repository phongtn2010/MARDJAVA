/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonAttachmentTypePhase2;
import com.nsw.backend.dic.model.CmonAttachtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CmonAtchPhs2Repository extends JpaRepository<CmonAttachmentTypePhase2, Long> {
    List<CmonAttachmentTypePhase2> findAllBySystemIdOrderByRequiredDesc(long systemId);

    List<CmonAttachmentTypePhase2> findAllBySystemIdAndTemplateTypeOrderByRequiredDesc(long systemId, String templateType);

}

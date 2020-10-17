package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.TbdAttachmentFile01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdAttachmentFileRepository extends JpaRepository<TbdAttachmentFile01, Long> {
    TbdAttachmentFile01 findByFiIDAndFiTaxCode(Long id, String taxcode);
}

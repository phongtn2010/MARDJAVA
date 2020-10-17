package com.nsw.backend.mard.p01.repositories;

import com.nsw.backend.mard.p01.model.TbdPheDuyetHS01;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbdtbpdHS01Repository extends JpaRepository<TbdPheDuyetHS01, Long> {
}

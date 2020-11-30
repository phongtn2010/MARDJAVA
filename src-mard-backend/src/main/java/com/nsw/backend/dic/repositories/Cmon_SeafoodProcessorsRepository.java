package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.CmonSeafoodprocessors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("cmon_SeafoodProcessorsRepository")
public interface Cmon_SeafoodProcessorsRepository extends JpaRepository<CmonSeafoodprocessors, Long>, Cmon_SeafoodProcessorsRepositoryCustom {
    @Query(value = "SELECT max (cmon.seafoodprocessorsid) FROM CmonSeafoodprocessors  cmon")
    public Long maxId();
}

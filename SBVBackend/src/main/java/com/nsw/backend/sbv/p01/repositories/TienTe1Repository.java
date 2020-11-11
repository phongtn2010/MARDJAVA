package com.nsw.backend.sbv.p01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nsw.backend.sbv.p01.model.*;

@Repository
public interface TienTe1Repository  extends JpaRepository<TienTe1, Long>, TienTe1RepositoryCustom {

}
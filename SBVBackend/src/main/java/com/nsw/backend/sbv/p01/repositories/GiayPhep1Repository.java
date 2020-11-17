package com.nsw.backend.sbv.p01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nsw.backend.sbv.p01.model.*;

@Repository
public interface GiayPhep1Repository  extends JpaRepository<GiayPhep1, Long>, GiayPhep1RepositoryCustom {

	public GiayPhep1 findBySoGiayPhep(String soGiayPhep);
}
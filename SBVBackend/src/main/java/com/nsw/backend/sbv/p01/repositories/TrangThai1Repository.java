package com.nsw.backend.sbv.p01.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nsw.backend.sbv.p01.model.*;

@Repository
public interface TrangThai1Repository  extends JpaRepository<TrangThai1, Long>, TrangThai1RepositoryCustom {

	public TrangThai1 findByGiaTri(int giaTri);
	
}
package com.nsw.backend.sbv.p01.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nsw.backend.sbv.p01.model.*;

@Repository
public interface TepDinhKemHoSo1Repository  extends JpaRepository<TepDinhKemHoSo1, Long>, TepDinhKemHoSo1RepositoryCustom {

	@Query(value = "select sum(a.size) from TepDinhKemHoSo1 a where a.idHoSo = :idHoSo and a.size is not null")
	Optional<Long> sizeOfFiles(@Param("idHoSo")long idHoSo);
}
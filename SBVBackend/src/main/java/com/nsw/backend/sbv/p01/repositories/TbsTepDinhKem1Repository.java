package com.nsw.backend.sbv.p01.repositories;

import com.nsw.backend.sbv.p01.model.TbsTepDinhKem1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/***
 *
 *
 * @Repository
 * @interface TbsTepDinhKem6Repository
 * Created by Nguyen Van Quang
 * 22/08/2018 13:00:07
 *
 */
@Repository
public interface TbsTepDinhKem1Repository extends JpaRepository<TbsTepDinhKem1, Long> {

    /**
     * @param loaiThuTuc - Type: String
     * @return can return null or throw exception
     */
    @Query("select h from TbsTepDinhKem1 h where h.loaiThuTuc = :loaiThuTuc order by h.loaiTep asc, h.order asc")
    List<TbsTepDinhKem1> findByLoaiThuTucOrderByOrderAsc(@Param("loaiThuTuc")String loaiThuTuc);

    List<TbsTepDinhKem1> findByLoaiThuTucAndLoaiTepOrderByOrderAsc(String loaiThuTuc, String loaiTep);


}

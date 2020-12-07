package com.nsw.backend.mard.p25.repositories;


import com.nsw.backend.mard.p25.dto.FilterFormHangHoa26;
import com.nsw.backend.mard.p25.dto.FilterFormHangHoaMK25;
import com.nsw.backend.mard.p25.dto.FilterResultHangHoaMK25;

public interface TbdHanghoaMK25RepositoryCustom {
    FilterResultHangHoaMK25 searchHanghoaMK25(FilterFormHangHoaMK25 filter);
}

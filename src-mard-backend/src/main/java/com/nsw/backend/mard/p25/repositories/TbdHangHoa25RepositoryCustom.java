package com.nsw.backend.mard.p25.repositories;


import com.nsw.backend.mard.p25.model.FilterHangHoa;
import com.nsw.backend.mard.p25.model.FilterResult;

public interface TbdHangHoa25RepositoryCustom {
    FilterResult searchHangHoa (FilterHangHoa filterHangHoa);
}

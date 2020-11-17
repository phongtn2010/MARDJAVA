package com.nsw.backend.mard.p25.repositories;


import com.nsw.backend.mard.p25.model.FilterHangHoa;
import com.nsw.backend.mard.p25.model.FilterResult;
import com.nsw.backend.mard.p25.model.FilterResultHH;

public interface TbdHangHoa25RepositoryCustom {
    FilterResultHH searchHangHoa (FilterHangHoa filterHangHoa);
}

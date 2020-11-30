package com.nsw.backend.dic.repositories;

import com.nsw.backend.dic.model.FilterFormCmonSF;
import com.nsw.backend.dic.model.FilterResult_CmonSeafood;

public interface Cmon_SeafoodProcessorsRepositoryCustom {
    FilterResult_CmonSeafood searchCmonSeafood(FilterFormCmonSF filter);
}

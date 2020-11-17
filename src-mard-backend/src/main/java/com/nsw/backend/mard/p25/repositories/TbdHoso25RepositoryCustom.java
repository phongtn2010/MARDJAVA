package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.FilterForm;
import com.nsw.backend.mard.p25.model.FilterResult;


public interface TbdHoso25RepositoryCustom {
    FilterResult searchHoso(FilterForm filterForm);
}

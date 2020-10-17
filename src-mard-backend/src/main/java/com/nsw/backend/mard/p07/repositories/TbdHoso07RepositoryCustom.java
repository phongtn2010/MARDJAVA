package com.nsw.backend.mard.p07.repositories;

import com.nsw.backend.mard.p07.model.FilterForm;
import com.nsw.backend.mard.p07.model.FilterResult;

public interface TbdHoso07RepositoryCustom {
    FilterResult searchHoso(FilterForm filterForm);
}

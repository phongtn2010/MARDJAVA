package com.nsw.backend.mard.p09.repositories;

import com.nsw.backend.mard.p09.model.FilterForm;
import com.nsw.backend.mard.p09.model.FilterResult;

public interface Tbdhoso09RepositoryCustom {
    FilterResult searchHoso(FilterForm filter);
}

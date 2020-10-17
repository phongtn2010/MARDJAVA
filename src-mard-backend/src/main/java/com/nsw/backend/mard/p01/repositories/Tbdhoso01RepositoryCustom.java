package com.nsw.backend.mard.p01.repositories;


import com.nsw.backend.mard.p01.model.FilterForm;
import com.nsw.backend.mard.p01.model.FilterResult;

public interface Tbdhoso01RepositoryCustom {

    FilterResult searchHoso(FilterForm filter);
}

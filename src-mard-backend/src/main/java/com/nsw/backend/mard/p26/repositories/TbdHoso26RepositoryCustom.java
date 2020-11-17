package com.nsw.backend.mard.p26.repositories;

import com.nsw.backend.mard.p26.model.FilterForm;
import com.nsw.backend.mard.p26.model.FilterResult;

public interface TbdHoso26RepositoryCustom {
    FilterResult searchHoso(FilterForm filterForm);
}

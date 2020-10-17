package com.nsw.backend.mard.p06.repositories;

import com.nsw.backend.mard.p06.model.FilterForm;
import com.nsw.backend.mard.p06.model.FilterResult;

public interface TbdHoso06RepositoryCustom {
    FilterResult searchHoso(FilterForm filterForm);
}

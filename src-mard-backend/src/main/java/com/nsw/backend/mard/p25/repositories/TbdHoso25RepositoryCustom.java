package com.nsw.backend.mard.p25.repositories;

import com.nsw.backend.mard.p25.model.FilterForm;
import com.nsw.backend.mard.p25.model.FilterResult;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbdHoso25RepositoryCustom {
    FilterResult searchHoso(FilterForm filterForm);
}

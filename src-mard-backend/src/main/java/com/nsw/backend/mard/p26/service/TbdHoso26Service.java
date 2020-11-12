package com.nsw.backend.mard.p26.service;

import com.nsw.backend.mard.p26.model.FilterForm;
import com.nsw.backend.mard.p26.model.FilterResult;
import com.nsw.backend.mard.p26.model.TbdHoso26;

import java.util.List;

public interface TbdHoso26Service {
    public TbdHoso26 update(TbdHoso26 tbdHoso26);
    public TbdHoso26 create(TbdHoso26 tbdHoso26);

    FilterResult searchHoso(FilterForm filterForm);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.mard.p08.repositories;

import com.nsw.backend.mard.p08.model.FilterForm;
import com.nsw.backend.mard.p08.model.FilterResult;

public interface Tbdhoso08RepositoryCustom {
    FilterResult searchHoso(FilterForm filter);
}

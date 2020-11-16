package com.nsw.backend.sbv.p02.service;

import com.nsw.backend.sbv.p02.model.TbdHosovang2;

public interface TbdHosovang2Service {
    /**
     * Saves the given entity in the database (create or update)
     *
     * @param entity
     * @return entity
     */
    TbdHosovang2 save(TbdHosovang2 entity);

    /**
     * Creates the given entity in the database
     *
     * @param entity
     * @return
     */
    TbdHosovang2 create(TbdHosovang2 entity);
}

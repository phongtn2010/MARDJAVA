/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.annotations;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PhongNguyen
 */
public abstract class AbstractEntity {
    
    protected List<ErrorEntity> errors = new ArrayList<ErrorEntity>();
    
    public void addError(ErrorEntity error) {
        this.errors.add(error);
    }

    public void addErrors(List<ErrorEntity> errors) {
        this.errors.addAll(errors);
    }

    public boolean hasError() {
        return errors != null && errors.size() > 0;
    }

    public List<ErrorEntity> getErrors() {
        List<ErrorEntity> result = new ArrayList<ErrorEntity>();
        for (ErrorEntity error : errors) {
            result.add(error);
        }
        return result;
    }
}

package com.nsw.service;

import com.nsw.common.model.json.ResponseJson;

public interface ReceiveService {
    ResponseJson callResforEntity(String url, Object object, String method);
}

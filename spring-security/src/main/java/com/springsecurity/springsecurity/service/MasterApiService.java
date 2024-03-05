package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.entity.MasterApi;

public interface MasterApiService {

    public MasterApi createMasterApi(MasterApi masterApi);
    public MasterApi getByserialNumberId(Long serialNumber);
}

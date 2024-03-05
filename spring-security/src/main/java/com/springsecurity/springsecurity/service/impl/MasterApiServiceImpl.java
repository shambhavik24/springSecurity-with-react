package com.springsecurity.springsecurity.service.impl;

import com.springsecurity.springsecurity.entity.MasterApi;
import com.springsecurity.springsecurity.repository.MasterApiRepository;
import com.springsecurity.springsecurity.service.MasterApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MasterApiServiceImpl implements MasterApiService {

    @Autowired
    private MasterApiRepository masterApiRepository;
    @Override
    public MasterApi createMasterApi(MasterApi masterApi) {
      MasterApi masterApi1 =  masterApiRepository.save(masterApi);
        return masterApi1;
    }

    @Override
    public MasterApi getByserialNumberId(Long serialNumber) {
     Optional<MasterApi> optionalMasterApi = masterApiRepository.findById(serialNumber);
     return optionalMasterApi.get();
    }
}

package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.entity.MasterApi;
import com.springsecurity.springsecurity.service.MasterApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MasterApiController {
    @Autowired
    private MasterApiService masterApiService;

    @PostMapping
    public  ResponseEntity<MasterApi> createmasterapi(MasterApi masterApi){
      MasterApi masterApi1 =  masterApiService.createMasterApi(masterApi);
      return new ResponseEntity<>(masterApi1, HttpStatus.CREATED);

    }
    //optional
    @GetMapping("/master")
    public String master(){
        return "master";
    }

    @GetMapping("{id}")
    public ResponseEntity<MasterApi> getBySerialNo(Long serialNumber){
        MasterApi masterApi = masterApiService.getByserialNumberId(serialNumber);
        return new ResponseEntity<>(masterApi,HttpStatus.OK);
    }
}

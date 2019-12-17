package com.baeldung.ignite.spring.controller;

import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import com.baeldung.ignite.spring.service.ConversionService;
import com.baeldung.ignite.spring.service.DatasetWrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadFileController {

    @Autowired
    ConversionService conversionService;

    @Autowired
    DatasetWrapperService datasetWrapperService;

    @GetMapping(value = "/readFromFile")
    public ResponseEntity<String> readFromFile() {
//        conversionService.getDatasetWrapper();
        datasetWrapperService.insertDatasetWrapper();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/readCache")
    public ResponseEntity<DatasetWrapper> readFromCache() {
        DatasetWrapper response = datasetWrapperService.readFromCache();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping(value = "/playPerson")
//    public ResponseEntity<String> playWithPerson() {
//        datasetWrapperService.playWithPerson();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}

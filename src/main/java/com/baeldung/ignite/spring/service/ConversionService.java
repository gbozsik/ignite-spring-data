package com.baeldung.ignite.spring.service;


import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;

public interface ConversionService {

    DatasetWrapper getDatasetWrapper(String filepath);

    <T> T getLineInDataModel(String line, String fileId, long iterations);

    void streamToCache();

    void streamToCache(String line, String fileName, long iterations);
}

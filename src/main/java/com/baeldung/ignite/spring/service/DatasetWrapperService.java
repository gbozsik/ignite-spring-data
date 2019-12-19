package com.baeldung.ignite.spring.service;

import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;

public interface DatasetWrapperService {

    void insertDatasetWrapper();

    DatasetWrapper readFromCache();

    Iterable<DatasetWrapper> readAllFromCache();
}

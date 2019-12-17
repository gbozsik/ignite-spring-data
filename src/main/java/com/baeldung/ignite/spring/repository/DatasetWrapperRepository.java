package com.baeldung.ignite.spring.repository;

import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;

@Repository
@RepositoryConfig(cacheName = "datasetWrapperCache")
public interface DatasetWrapperRepository extends IgniteRepository<DatasetWrapper, Long> {

        DatasetWrapper getDatasetWrapperById(Long id);
}

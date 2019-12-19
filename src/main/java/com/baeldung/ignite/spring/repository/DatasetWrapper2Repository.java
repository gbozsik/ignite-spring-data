package com.baeldung.ignite.spring.repository;

import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper2;
import com.baeldung.ignite.spring.model.jolmodel.ResourceModel;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryConfig(cacheName = "datasetWrapper2Cache2")
public interface DatasetWrapper2Repository extends IgniteRepository<DatasetWrapper2, String> {
}

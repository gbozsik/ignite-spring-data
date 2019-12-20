package com.baeldung.ignite.stream;

import com.baeldung.ignite.model.Employee;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;

import javax.cache.configuration.FactoryBuilder;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CacheConfig {

    public static CacheConfiguration<Integer, Employee> employeeCache() {

        CacheConfiguration<Integer, Employee> config = new CacheConfiguration<>("baeldungEmployees");

        config.setIndexedTypes(Integer.class, Employee.class);
        config.setExpiryPolicyFactory(FactoryBuilder.factoryOf(
                new CreatedExpiryPolicy(new Duration(TimeUnit.SECONDS, 5))));

        return config;
    }

    public static CacheConfiguration<Long, List<DatasetWrapper>> datasetWrapperCache() {

        CacheConfiguration<Long, List<DatasetWrapper>> config = new CacheConfiguration<>("datasetCache");

        config.setIndexedTypes(Long.class, DatasetWrapper.class);
        config.setCacheMode(CacheMode.PARTITIONED);
        config.setExpiryPolicyFactory(FactoryBuilder.factoryOf(
                new CreatedExpiryPolicy(new Duration(TimeUnit.SECONDS, 5))));

        return config;
    }
}
package com.baeldung.ignite.spring.config;

import com.baeldung.ignite.spring.dto.EmployeeDTO;
import com.baeldung.ignite.spring.repository.EmployeeRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.ClientConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableIgniteRepositories(basePackageClasses = EmployeeRepository.class)
@ComponentScan(basePackages = "com.baeldung.ignite.spring.repository")
public class SpringDataConfig {

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration config = new IgniteConfiguration();

        CacheConfiguration cache = new CacheConfiguration("baeldungCache");

        cache.setIndexedTypes(Integer.class, EmployeeDTO.class);
        config.setCacheConfiguration(cache);
        return Ignition.start(config);
    }
//    @Bean
//    public IgniteClient igniteInstance() {
//        ClientConfiguration cfg = new ClientConfiguration().setAddresses("192.168.2.29:10800");
//        IgniteClient igniteClient = Ignition.startClient(cfg);
//
////        cfg.setCacheConfiguration(cache);
//        return Ignition.startClient(cfg);
//    }

    @Bean
    public CacheConfiguration cacheInstance() {
        CacheConfiguration cache = new CacheConfiguration("baeldungCache");

        cache.setIndexedTypes(Integer.class, EmployeeDTO.class);
//        config.setCacheConfiguration(cache);
        return cache;
    }
}

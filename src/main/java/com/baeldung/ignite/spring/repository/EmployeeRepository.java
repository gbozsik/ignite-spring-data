package com.baeldung.ignite.spring.repository;

import com.baeldung.ignite.spring.dto.EmployeeDTO;

import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryConfig(cacheName = "baeldungCache")
public interface EmployeeRepository extends IgniteRepository<EmployeeDTO, Integer> {

//    @Query(value = "select c from employee_dto")
    EmployeeDTO getEmployeeDTOById(Integer id);
}

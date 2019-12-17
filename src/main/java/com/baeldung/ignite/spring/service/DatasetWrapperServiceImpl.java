package com.baeldung.ignite.spring.service;

import com.baeldung.ignite.spring.dto.EmployeeDTO;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import com.baeldung.ignite.spring.repository.DatasetWrapperRepository;
import com.baeldung.ignite.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

//import com.ginite.inmemory.config.PersonRepository;

@Service
public class DatasetWrapperServiceImpl implements DatasetWrapperService {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private DatasetWrapperRepository datasetWrapperRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private DatasetWrapper datasetWrapper;
    private EmployeeDTO employeeDTO;

    @Override
    public void insertDatasetWrapper() {
        playWithDatasetWrapper();
    }

    private void playWithDatasetWrapper() {

        LocalDateTime startOfReadFile = LocalDateTime.now();
        datasetWrapper = conversionService.getDatasetWrapper();
        Duration durationOfReadFile = Duration.between(startOfReadFile, LocalDateTime.now());
        System.out.println("duration of read: " + durationOfReadFile);
        LocalDateTime startOfInsert = LocalDateTime.now();
        datasetWrapperRepository.save(datasetWrapper.getId(), datasetWrapper);
        Duration durationOfSave = Duration.between(startOfInsert, LocalDateTime.now());
//        System.out.println(datasetWrapper);
        System.out.println("duration of save: " + durationOfSave);

//        employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(1);
//        employeeDTO.setName("John");
//        employeeDTO.setEmployed(true);
//
//        employeeRepository.save(employeeDTO.getId(), employeeDTO);
//
//        EmployeeDTO employee = employeeRepository.getEmployeeDTOById(employeeDTO.getId());
//        System.out.println(employee);

    }

    @Override
    public DatasetWrapper readFromCache() {
//        EmployeeDTO employee = employeeRepository.getEmployeeDTOById(employeeDTO.getId());
//        System.out.println(employee);
//        System.out.println(datasetWrapperRepository.getDatasetWrapperById(datasetWrapper.getId()));
        LocalDateTime startOfget = LocalDateTime.now();
        DatasetWrapper datasetWrapperFromCache = datasetWrapperRepository.getDatasetWrapperById(datasetWrapper.getId());
        Duration durationOgetFromCache = Duration.between(startOfget, LocalDateTime.now());
        System.out.println("duration of get from cache: " + durationOgetFromCache);
        return datasetWrapperFromCache;
//        return null;
    }

    public void playWithPerson() {
//        Person person = new Person(1, 1, "John", 33);
//        personRepository.save(person);
//        Person personFromDb = personRepository.getPersonById(1);
//        System.out.println("person fromDB: " + personFromDb);
    }
}

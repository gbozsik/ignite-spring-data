package com.baeldung.ignite.spring.service;

import com.baeldung.ignite.spring.config.SpringDataConfig;
import com.baeldung.ignite.spring.converter.JolConverter;
import com.baeldung.ignite.spring.dto.EmployeeDTO;
import com.baeldung.ignite.spring.factory.enums.CacheNames;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import com.baeldung.ignite.spring.repository.DatasetWrapperRepository;
import com.baeldung.ignite.spring.repository.EmployeeRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import com.ginite.inmemory.config.PersonRepository;

@Service
public class DatasetWrapperServiceImpl implements DatasetWrapperService {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private DatasetWrapperRepository datasetWrapperRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Ignite igniteInstance;

    @Autowired
    private SpringDataConfig springDataConfig;
    @Autowired
    private JolConverter jolConverter;

    private DatasetWrapper datasetWrapper;
    private EmployeeDTO employeeDTO;

    @Override
    public void insertDatasetWrapper() {
        playWithDatasetWrapper();
    }

    private void playWithDatasetWrapper() {

        LocalDateTime startOfReadFile = LocalDateTime.now();
//        datasetWrapper = conversionService.getDatasetWrapper("/home/gbozsik/Documents/Artisjus/állományok/DSR__Apple_Individual_2018-Q4_HU__20190105T172258.jol");
        Duration durationOfReadFile = Duration.between(startOfReadFile, LocalDateTime.now());
        System.out.println("start to read: " + durationOfReadFile);
        LocalDateTime startOfInsert = LocalDateTime.now();
//        datasetWrapperRepository.save(2L, datasetWrapper);
        conversionService.streamToCache("line", "filename", 1);
//        jolConverter.readFromFile("/home/gbozsik/Documents/Artisjus/DeezerWorldwidePremiumPlusStandalone_20160301_20160331_HU_matched.jol");
        Duration durationOfSave = Duration.between(startOfInsert, LocalDateTime.now());
//        System.out.println(datasetWrapper);
        System.out.println("end of all: " + durationOfSave);

//        employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(1);
//        employeeDTO.setName("John");
//        employeeDTO.setEmployed(true);
//
//        employeeRepository.save(employeeDTO.getId(), employeeDTO);
//        System.out.println(employeeDTO.toString());
//
    }

    @Override
    public DatasetWrapper readFromCache() {
//        EmployeeDTO employee = employeeRepository.getEmployeeDTOById(employeeDTO.getId());
//        System.out.println(employee);
//        System.out.println(datasetWrapperRepository.getDatasetWrapperById(datasetWrapper.getId()));
        igniteInstance.getOrCreateCache(springDataConfig.getCache("clientCache"));
        LocalDateTime startOfget = LocalDateTime.now();
        DatasetWrapper datasetWrapperFromCache = datasetWrapperRepository.getDatasetWrapperById(3L);
        Duration durationOgetFromCache = Duration.between(startOfget, LocalDateTime.now());
        System.out.println("duration of get from cache: " + durationOgetFromCache);
        return datasetWrapperFromCache;
//        return null;
    }

    @Override
    public Iterable<DatasetWrapper> readAllFromCache() {
        igniteInstance.cache(CacheNames.CLIENT_CACHE.name()).clear();
        LocalDateTime startOfgetAll = LocalDateTime.now();
        Iterable<DatasetWrapper> datasetWrapperIterable = datasetWrapperRepository.findAll();
        Duration durationOgetFromCache = Duration.between(startOfgetAll, LocalDateTime.now());
        System.out.println("duration of get all from cache: " + durationOgetFromCache);
//        datasetWrapperIterable.forEach(datasetWrapper -> System.out.println("DATASET_WRAPPER_IDS: " + datasetWrapper.getId()));
        for (DatasetWrapper datasetWrapper : datasetWrapperIterable) {
            System.out.println("DATASET_WRAPPER_IDS: " + datasetWrapper.getId());
        }
        return datasetWrapperIterable;
    }


    public void playWithPerson() {
//        Person person = new Person(1, 1, "John", 33);
//        personRepository.save(person);
//        Person personFromDb = personRepository.getPersonById(1);
//        System.out.println("person fromDB: " + personFromDb);
    }
}

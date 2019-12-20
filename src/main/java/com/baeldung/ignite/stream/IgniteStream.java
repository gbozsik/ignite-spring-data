package com.baeldung.ignite.stream;

import com.baeldung.ignite.spring.factory.JolModelFactory;
import com.baeldung.ignite.spring.factory.enums.JolConstants;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import com.baeldung.ignite.spring.service.ConversionServiceImpl;
import com.google.gson.Gson;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteDataStreamer;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.BinaryConfiguration;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.ConnectorConfiguration;
import org.apache.ignite.configuration.DataRegionConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class IgniteStream {

    private static final Gson GSON = new Gson();

    private static DatasetWrapper datasetWrapper;

    private static final String DATA_CONFIG_NAME = "MyDataRegionConfiguration";
    private static final String IGNITE_PERSISTENCE_FILE_PATH = "/home/gbozsik/IdeaProjects/artisjus/poc/ignite-spring-data/data/";


    @Autowired
    private ConversionServiceImpl conversionServiceImpl;

    public static void main(String[] args) throws Exception {

//        Ignition.setClientMode(true);
//        Ignite ignite = Ignition.start();
//
//        IgniteCache<Integer, Employee> cache = ignite.getOrCreateCache(CacheConfig.employeeCache());
//        IgniteDataStreamer<Integer, Employee> streamer = ignite.dataStreamer(cache.getName());
//        streamer.allowOverwrite(true);
//
//        streamer.receiver(StreamTransformer.from((e, arg) -> {
//
//            Employee employee = e.getValue();
//            employee.setEmployed(true);
//            e.setValue(employee);
//
//            return employee;
//        }));

//        Path path = Paths.get(IgniteStream.class.getResource("employees.txt").toURI());

//        Files.lines(path)
//          .forEach(line -> {
//              Employee employee = GSON.fromJson(line, Employee.class);
//              System.out.println(employee);
//              streamer.addData(employee.getId(), employee);
//          });

        Ignition.setClientMode(true);
        Ignite ignite = Ignition.start("/home/gbozsik/IdeaProjects/artisjus/poc/ignite-spring-data/src/main/resources/igniteclient.xml");
//        Ignite ignite = Ignition.start();


        IgniteCache<Long, List<DatasetWrapper>> datasetCache = ignite.getOrCreateCache(CacheConfig.datasetWrapperCache());
        IgniteDataStreamer<Long, DatasetWrapper> datasetStreamer = ignite.dataStreamer(datasetCache.getName());
        datasetStreamer.allowOverwrite(true);




//        Path path = Paths.get(IgniteStream.class.getResource("/home/gbozsik/Documents/Artisjus/DeezerWorldwidePremiumPlusStandalone_20160301_20160331_HU.jol").toURI());
        Path path = Paths.get("/home/gbozsik/Documents/Artisjus/állományok/GooglePlay_PAYG_20170701_20170930_BA.jol");

        datasetWrapper = new DatasetWrapper();
        datasetWrapper.setId(3L);
        long iterations = 0;
        LocalDateTime startOfConversion = LocalDateTime.now();
        Files.lines(path)
                .forEach(line -> {
                    convertLineToDatasetWrapper(line, iterations);
//              System.out.println(employee);
                    datasetStreamer.addData(datasetWrapper.getId(), datasetWrapper);
                });
        Duration durationOfSave = Duration.between(startOfConversion, LocalDateTime.now());
        System.out.println("duration of save: " + durationOfSave);
//        convertLineToDatasetWrapper("REL|REL0|64450910||||TrackRelease|||Biboulakis||Jack a Dit (Original Mix)|", iterations);
        System.out.println(datasetWrapper);
    }

    private static void convertLineToDatasetWrapper(String line, long iterations) {
//        String[] splittedLine = line.split("\\|", -1);
//        switch (splittedLine[JolConstants.LINE_CODE_POSITION]) {
//            case JolConstants.RES_LINE_CODE:
//                datasetWrapper.getResDs().add(JolModelFactory.getResourceModel(splittedLine));
//                break;
//            case JolConstants.REL_LINE_CODE:
//                datasetWrapper.getRelDs().add(JolModelFactory.getRelJolModel(splittedLine));
//                break;
//            case JolConstants.TX_LINE_CODE:
//                datasetWrapper.getTxDs().add(JolModelFactory.getTxModel(splittedLine, iterations));
//                break;
//            case JolConstants.PRONTO_LINE_CODE:
//                datasetWrapper.getResProntoDs().add(JolModelFactory.getProntoModel(splittedLine));
//                break;
//            case JolConstants.RESARTIST_LINE_CODE:
//                datasetWrapper.getResArtistJolModelDs().add(JolModelFactory.getArtistModel(splittedLine));
//                break;
//            case JolConstants.RESCONTR_LINE_CODE:
//                datasetWrapper.getResContributorJolModelDs().add(JolModelFactory.getContribModel(splittedLine));
//                break;
////                case JolConstants.
//        }
//        // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//
//        if (splittedLine.length > JolConstants.RESISWC_SOURCE_POSITION) {
//            if (JolConstants.RESISWC_LINE_CODE.equals(splittedLine[JolConstants.RESISWC_SOURCE_POSITION])) {
//                datasetWrapper.getResIswcTransactionDs().add(JolModelFactory.getResIswcModel(splittedLine));
//                datasetWrapper.getResIswcEnrichedDs().add(JolModelFactory.getResIswcModel(splittedLine));
//            }
//        }
//        // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//        if (splittedLine.length > JolConstants.RESISRC_SOURCE_POSITION) {
//            if (JolConstants.RESISRC_LINE_CODE.equals(splittedLine[JolConstants.RESISRC_SOURCE_POSITION])) {
//                datasetWrapper.getResIsrcTransactionDs().add(JolModelFactory.getResIsrcModel(splittedLine));
//                datasetWrapper.getResIsrcEnrichedDs().add(JolModelFactory.getResIsrcModel(splittedLine));
//            }
//        }
//        // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//        if (splittedLine.length > JolConstants.RESTITLE_SOURCE_POSITION) {
//            if (JolConstants.RESTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESTITLE_SOURCE_POSITION])) {
//                datasetWrapper.getResTitleTransactionalDs().add(JolModelFactory.getResTitleModel(splittedLine));
//                datasetWrapper.getResTitleEnrichedDs().add(JolModelFactory.getResTitleModel(splittedLine));
//            }
//        }
//        // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//        if (splittedLine.length > JolConstants.RESMWTITLE_SOURCE_POSITION) {
//            if (JolConstants.RESMWTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESMWTITLE_SOURCE_POSITION])) {
//                datasetWrapper.getResTitleTransactionalDs().add(JolModelFactory.getResTitleModel(splittedLine));
//                datasetWrapper.getResTitleEnrichedDs().add(JolModelFactory.getResTitleModel(splittedLine));
//            }
//        }
    }

    private static IgniteConfiguration getIgniteConfiguration() {
//        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
////        CacheConfiguration datasetWrapperCache = getCache("datasetWrapperCache");
////        igniteConfiguration.setCacheConfiguration(datasetWrapperCache);
//        igniteConfiguration.setClientMode(true);
//        igniteConfiguration.setIgniteInstanceName("ignite");
//        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
//        TcpDiscoveryVmIpFinder tcpDiscoveryVmIpFinder = new TcpDiscoveryVmIpFinder();
//        // need to be changed when it come to real cluster
//        tcpDiscoveryVmIpFinder.setAddresses(Arrays.asList("192.168.2.29:47500"));
//        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
//        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);
//
//        DataStorageConfiguration dataStorageConfiguration = new DataStorageConfiguration();
//        igniteConfiguration.setWorkDirectory("/home/gbozsik/");
//
//        dataStorageConfiguration.setStoragePath(IGNITE_PERSISTENCE_FILE_PATH + "/store");
//        dataStorageConfiguration.setWalArchivePath(IGNITE_PERSISTENCE_FILE_PATH + "/walArchive");
//        dataStorageConfiguration.setWalPath(IGNITE_PERSISTENCE_FILE_PATH + "/walStore");
//
//        dataStorageConfiguration.setPageSize(4 * 1024);
//
//        DataRegionConfiguration dataRegionConfiguration = new DataRegionConfiguration();
//        dataRegionConfiguration.setName("dataconf");
//        dataRegionConfiguration.setInitialSize(100L * 1000 * 1000);
//        dataRegionConfiguration.setMaxSize(20000L * 1000 * 1000);
////        dataRegionConfiguration.setPersistenceEnabled(true);
//        dataStorageConfiguration.setDataRegionConfigurations(dataRegionConfiguration);
//        DataStorageConfiguration dataStorageConfiguration_2 = new DataStorageConfiguration();
//        dataStorageConfiguration_2.setPageSize(4 * 1024);
//        dataStorageConfiguration_2.setDataRegionConfigurations(dataRegionConfiguration);
//        igniteConfiguration.setDataStorageConfiguration(dataStorageConfiguration);
//
////        CacheConfiguration datasetWrapperCache = getCache("datasetWrapperCache");
////        igniteConfiguration.setCacheConfiguration(datasetWrapperCache);
//
////        CacheConfiguration employeeCache = new CacheConfiguration("employeeCache");
////        datasetWrapperCache.setIndexedTypes(Integer.class, EmployeeDTO.class);
////        igniteConfiguration.setCacheConfiguration(employeeCache);
//
//        ConnectorConfiguration connectorConfiguration = new ConnectorConfiguration();
//        connectorConfiguration.setPort(11211);
//        // common ignite configuration
//        igniteConfiguration.setMetricsLogFrequency(0);
//        igniteConfiguration.setQueryThreadPoolSize(2);
//        igniteConfiguration.setDataStreamerThreadPoolSize(1);
//        igniteConfiguration.setManagementThreadPoolSize(2);
//        igniteConfiguration.setPublicThreadPoolSize(2);
//        igniteConfiguration.setSystemThreadPoolSize(2);
//        igniteConfiguration.setRebalanceThreadPoolSize(1);
//        igniteConfiguration.setAsyncCallbackPoolSize(2);
//        igniteConfiguration.setPeerClassLoadingEnabled(false);
//        BinaryConfiguration binaryConfiguration = new BinaryConfiguration();
//        binaryConfiguration.setCompactFooter(false);
//        igniteConfiguration.setBinaryConfiguration(binaryConfiguration);
        // cluster tcp configuration
//        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
//        TcpDiscoveryVmIpFinder tcpDiscoveryVmIpFinder = new TcpDiscoveryVmIpFinder();
//        // need to be changed when it come to real cluster
//        tcpDiscoveryVmIpFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
//        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
//        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);

//        CacheConfiguration alerts = new CacheConfiguration();
//        alerts.setCopyOnRead(false);
//        // as we have one node for now
//        alerts.setBackups(1);
//        alerts.setAtomicityMode(CacheAtomicityMode.ATOMIC);
//        alerts.setName("datasetWrapperCache");
//
//        alerts.setDataRegionName(DATA_CONFIG_NAME);
//        alerts.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_ASYNC);
//        alerts.setIndexedTypes(Long.class, DatasetWrapper.class);
//
//        CacheConfiguration alertsConfig = new CacheConfiguration();
//        alertsConfig.setCopyOnRead(false);
//        // as we have one node for now
//        alertsConfig.setBackups(1);
//        alertsConfig.setAtomicityMode(CacheAtomicityMode.ATOMIC);
//        alertsConfig.setName("employeeCache");
//        alertsConfig.setIndexedTypes(Integer.class, EmployeeDTO.class);
//        alertsConfig.setDataRegionName(DATA_CONFIG_NAME);
//        alertsConfig.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_ASYNC);
//        igniteConfiguration.setCacheConfiguration(alerts, alertsConfig);
//        return igniteConfiguration;
        return null;
    }

}

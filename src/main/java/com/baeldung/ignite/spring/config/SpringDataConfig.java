package com.baeldung.ignite.spring.config;

import com.baeldung.ignite.spring.dto.EmployeeDTO;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import com.baeldung.ignite.spring.repository.DatasetWrapperRepository;
import com.baeldung.ignite.spring.repository.EmployeeRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.apache.ignite.configuration.BinaryConfiguration;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.ConnectorConfiguration;
import org.apache.ignite.configuration.DataRegionConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@EnableIgniteRepositories(basePackageClasses = {EmployeeRepository.class, DatasetWrapperRepository.class})
@ComponentScan(basePackages = "com.baeldung.ignite.spring.repository")
public class SpringDataConfig {

    private static final String DATA_CONFIG_NAME = "MyDataRegionConfiguration";
    private static final String IGNITE_PERSISTENCE_FILE_PATH = "/home/gbozsik/IdeaProjects/artisjus/poc/ignite-spring-data/data/";

    @Bean
    public IgniteConfiguration igniteConfiguration() {
        IgniteConfiguration igniteConfiguration = getBaseigniteConf();
        igniteConfiguration.setClientMode(false);
        igniteConfiguration.setIgniteInstanceName("ignite");
        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder tcpDiscoveryVmIpFinder = new TcpDiscoveryVmIpFinder();
        // need to be changed when it come to real cluster
        tcpDiscoveryVmIpFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);
        return igniteConfiguration;
    }

    private IgniteConfiguration getBaseigniteConf() {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        DataStorageConfiguration dataStorageConfiguration = new DataStorageConfiguration();
        igniteConfiguration.setWorkDirectory("/home/gbozsik/");

        dataStorageConfiguration.setStoragePath(IGNITE_PERSISTENCE_FILE_PATH + "/store");
        dataStorageConfiguration.setWalArchivePath(IGNITE_PERSISTENCE_FILE_PATH + "/walArchive");
        dataStorageConfiguration.setWalPath(IGNITE_PERSISTENCE_FILE_PATH + "/walStore");

        dataStorageConfiguration.setPageSize(4 * 1024);

        DataRegionConfiguration dataRegionConfiguration = new DataRegionConfiguration();
        dataRegionConfiguration.setName(DATA_CONFIG_NAME);
        dataRegionConfiguration.setInitialSize(100L * 1000 * 1000);
        dataRegionConfiguration.setMaxSize(20000L * 1000 * 1000);
//        dataRegionConfiguration.setPersistenceEnabled(true);
        dataStorageConfiguration.setDataRegionConfigurations(dataRegionConfiguration);
        DataStorageConfiguration dataStorageConfiguration_2 = new DataStorageConfiguration();
        dataStorageConfiguration_2.setPageSize(4 * 1024);
        dataStorageConfiguration_2.setDataRegionConfigurations(dataRegionConfiguration);
        igniteConfiguration.setDataStorageConfiguration(dataStorageConfiguration);

        CacheConfiguration cache = new CacheConfiguration("datasetWrapperCache");
        cache.setIndexedTypes(Long.class, DatasetWrapper.class);
        igniteConfiguration.setCacheConfiguration(cache);

        ConnectorConfiguration connectorConfiguration = new ConnectorConfiguration();
        connectorConfiguration.setPort(11211);
        // common ignite configuration
        igniteConfiguration.setMetricsLogFrequency(0);
        igniteConfiguration.setQueryThreadPoolSize(2);
        igniteConfiguration.setDataStreamerThreadPoolSize(1);
        igniteConfiguration.setManagementThreadPoolSize(2);
        igniteConfiguration.setPublicThreadPoolSize(2);
        igniteConfiguration.setSystemThreadPoolSize(2);
        igniteConfiguration.setRebalanceThreadPoolSize(1);
        igniteConfiguration.setAsyncCallbackPoolSize(2);
        igniteConfiguration.setPeerClassLoadingEnabled(false);
        BinaryConfiguration binaryConfiguration = new BinaryConfiguration();
        binaryConfiguration.setCompactFooter(false);
        igniteConfiguration.setBinaryConfiguration(binaryConfiguration);
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
        return igniteConfiguration;
    }



    @Bean(destroyMethod = "close")
    Ignite igniteInstance(IgniteConfiguration igniteConfiguration) throws IgniteException {
        final Ignite ignite = Ignition.start("/home/gbozsik/IdeaProjects/artisjus/poc/ignite-spring-data/src/main/resources/ignite.xml");
//        final Ignite ignite = Ignition.start("/home/gbozsik/IdeaProjects/artisjus/poc/ignite-sample-manager/ignite.xml");
        // Activate the cluster. Automatic topology initialization occurs
        // only if you manually activate the cluster for the very first time.
        ignite.cluster().active(true);
	    /*// Get all server nodes that are already up and running.
	    Collection<ClusterNode> nodes = ignite.cluster().forServers().nodes();
		// Set the baseline topology that is represented by these nodes.
	    ignite.cluster().setBaselineTopology(nodes);*/
        return ignite;
    }


    @Bean
    public IgniteConfiguration igniteConfiguration_2() {
        IgniteConfiguration igniteConfiguration = getBaseigniteConf();
        igniteConfiguration.setClientMode(true);
        igniteConfiguration.setIgniteInstanceName("igniteClient");
        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder tcpDiscoveryVmIpFinder = new TcpDiscoveryVmIpFinder();
        // need to be changed when it come to real cluster
        tcpDiscoveryVmIpFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47509"));
        tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
        igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);
        return igniteConfiguration;
    }

    @Bean(destroyMethod = "close")
    Ignite ignite(IgniteConfiguration igniteConfiguration_2) throws IgniteException {
        final Ignite ignite_2 = Ignition.start("/home/gbozsik/IdeaProjects/artisjus/poc/ignite-spring-data/src/main/resources/igniteclient.xml");
//        final Ignite ignite = Ignition.start("/home/gbozsik/IdeaProjects/artisjus/poc/ignite-sample-manager/ignite.xml");
        // Activate the cluster. Automatic topology initialization occurs
        // only if you manually activate the cluster for the very first time.
        ignite_2.cluster().active(true);
	    /*// Get all server nodes that are already up and running.
	    Collection<ClusterNode> nodes = ignite.cluster().forServers().nodes();
		// Set the baseline topology that is represented by these nodes.
	    ignite.cluster().setBaselineTopology(nodes);*/
        return ignite_2;
    }


//    @Bean
//    public CacheConfiguration cacheInstance() {
//        CacheConfiguration cache = new CacheConfiguration("datasetWrapperCache");
//        cache.setIndexedTypes(Long.class, DatasetWrapper.class);
//        return cache;
//    }

//    @Bean
//    public Ignite igniteInstance() {
//        IgniteConfiguration config = new IgniteConfiguration();
//        CacheConfiguration cache = new CacheConfiguration("employeeCache");
//        cache.setIndexedTypes(Integer.class, EmployeeDTO.class);
//        config.setCacheConfiguration(cache);
//        return Ignition.start(config);
//    }
//
//    @Bean
//    public CacheConfiguration cacheInstance() {
//        CacheConfiguration cache = new CacheConfiguration("employeeCache");
//        cache.setIndexedTypes(Integer.class, EmployeeDTO.class);
//        return cache;
//    }
}

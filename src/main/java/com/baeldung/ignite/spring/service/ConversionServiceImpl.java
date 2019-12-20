package com.baeldung.ignite.spring.service;

import com.baeldung.ignite.spring.converter.JolConverter;
import com.baeldung.ignite.spring.factory.JolModelFactory;
import com.baeldung.ignite.spring.factory.enums.JolConstants;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper2;
import com.baeldung.ignite.spring.repository.DatasetWrapper2Repository;
import com.baeldung.ignite.stream.CacheConfig;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.IgniteDataStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    private SplittedLineListService splittedLineListService;
    @Autowired
    private DatasetWrapper2Repository resourceModelRepository;
    @Autowired
    private Ignite igniteInstance;
    @Autowired
    private JolConverter jolConverter;
    @Autowired
    private DatasetWrapper2Repository datasetWrapper2Repository;

    private List<DatasetWrapper2> datasetWrapper2List;

    @Override
    public DatasetWrapper getDatasetWrapper(String filepath) {
        List<String[]> splittedLineList = getSplittedLineList(filepath);
        return createDatasets();
    }

    private List<String[]> getSplittedLineList(String filepath) {
        return splittedLineListService.getSplittedlineList(filepath);
    }

    private DatasetWrapper createDatasets() {
//        DatasetWrapper datasetWrapper = new DatasetWrapper();
//        datasetWrapper.setId(3L);
//        long iterations = 0;
//        for (String[] splittedLine : splittedLineList) {
//            iterations++;
//            switch (splittedLine[JolConstants.LINE_CODE_POSITION]) {
//                case JolConstants.RES_LINE_CODE:
//                    datasetWrapper.getResDs().add(JolModelFactory.getResourceModel(splittedLine));
//                    break;
//                case JolConstants.REL_LINE_CODE:
//                    datasetWrapper.getRelDs().add(JolModelFactory.getRelJolModel(splittedLine));
//                    break;
//                case JolConstants.TX_LINE_CODE:
//                    datasetWrapper.getTxDs().add(JolModelFactory.getTxModel(splittedLine, iterations));
//                    break;
//                case JolConstants.PRONTO_LINE_CODE:
//                    datasetWrapper.getResProntoDs().add(JolModelFactory.getProntoModel(splittedLine));
//                    break;
//                case JolConstants.RESARTIST_LINE_CODE:
//                    datasetWrapper.getResArtistJolModelDs().add(JolModelFactory.getArtistModel(splittedLine));
//                    break;
//                case JolConstants.RESCONTR_LINE_CODE:
//                    datasetWrapper.getResContributorJolModelDs().add(JolModelFactory.getContribModel(splittedLine));
//                    break;
////                case JolConstants.
//            }
//            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//
//            if (splittedLine.length > JolConstants.RESISWC_SOURCE_POSITION) {
//                if (JolConstants.RESISWC_LINE_CODE.equals(splittedLine[JolConstants.RESISWC_SOURCE_POSITION])) {
//                    datasetWrapper.getResIswcTransactionDs().add(JolModelFactory.getResIswcModel(splittedLine));
//                    datasetWrapper.getResIswcEnrichedDs().add(JolModelFactory.getResIswcModel(splittedLine));
//                }
//            }
//            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//            if (splittedLine.length > JolConstants.RESISRC_SOURCE_POSITION) {
//                if (JolConstants.RESISRC_LINE_CODE.equals(splittedLine[JolConstants.RESISRC_SOURCE_POSITION])) {
//                    datasetWrapper.getResIsrcTransactionDs().add(JolModelFactory.getResIsrcModel(splittedLine));
//                    datasetWrapper.getResIsrcEnrichedDs().add(JolModelFactory.getResIsrcModel(splittedLine));
//                }
//            }
//            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//            if (splittedLine.length > JolConstants.RESTITLE_SOURCE_POSITION) {
//                if (JolConstants.RESTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESTITLE_SOURCE_POSITION])) {
//                    datasetWrapper.getResTitleTransactionalDs().add(JolModelFactory.getResTitleModel(splittedLine));
//                    datasetWrapper.getResTitleEnrichedDs().add(JolModelFactory.getResTitleModel(splittedLine));
//                }
//            }
//            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
//            if (splittedLine.length > JolConstants.RESMWTITLE_SOURCE_POSITION) {
//                if (JolConstants.RESMWTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESMWTITLE_SOURCE_POSITION])) {
//                    datasetWrapper.getResTitleTransactionalDs().add(JolModelFactory.getResTitleModel(splittedLine));
//                    datasetWrapper.getResTitleEnrichedDs().add(JolModelFactory.getResTitleModel(splittedLine));
//                }
//            }
//        }
//        return datasetWrapper;
        return null;
    }

    @Override
    public List<DatasetWrapper2> getLineInDataModel(String line, String fileId, long iterations) {
//        String[] splittedLine = line.split("\\|", -1);
        datasetWrapper2List = new ArrayList<>();
        List<String[]> splittedLineList = jolConverter.readFromFile("/home/gbozsik/Documents/Artisjus/DeezerWorldwidePremiumPlusStandalone_20160301_20160331_HU.jol");
        DatasetWrapper2 datasetWrapper2 = new DatasetWrapper2();
        datasetWrapper2.setId(iterations);
        for (String[] splittedLine : splittedLineList) {
            switch (splittedLine[JolConstants.LINE_CODE_POSITION]) {
                case JolConstants.RES_LINE_CODE:
                    datasetWrapper2.setResDs(JolModelFactory.getResourceModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                    return datasetWrapper2;
//                System.out.println(datasetWrapper2.toString());
                    datasetWrapper2List.add(datasetWrapper2);
                    break;
                case JolConstants.REL_LINE_CODE:
                    datasetWrapper2.setRelDs(JolModelFactory.getRelJolModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                    return datasetWrapper2;
//                System.out.println(datasetWrapper2.toString());
                    datasetWrapper2List.add(datasetWrapper2);
                    break;
                case JolConstants.TX_LINE_CODE:
                    datasetWrapper2.setTxDs(JolModelFactory.getTxModel(splittedLine, fileId, iterations));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                    break;
                case JolConstants.PRONTO_LINE_CODE:
                    datasetWrapper2.setResProntoDs(JolModelFactory.getProntoModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                    break;
                case JolConstants.RESARTIST_LINE_CODE:
                    datasetWrapper2.setResArtistJolModelDs(JolModelFactory.getArtistModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                    break;
                case JolConstants.RESCONTR_LINE_CODE:
                    datasetWrapper2.setResContributorJolModelDs(JolModelFactory.getContribModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                    break;
//                case JolConstants.
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
            if (splittedLine.length > JolConstants.RESISWC_SOURCE_POSITION) {
                if (JolConstants.RESISWC_LINE_CODE.equals(splittedLine[JolConstants.RESISWC_SOURCE_POSITION])) {
                    datasetWrapper2.setResIswcTransactionDs(JolModelFactory.getResIswcModel(splittedLine, fileId));
                    datasetWrapper2.setResIswcEnrichedDs(JolModelFactory.getResIswcModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                }
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
            if (splittedLine.length > JolConstants.RESISRC_SOURCE_POSITION) {
                if (JolConstants.RESISRC_LINE_CODE.equals(splittedLine[JolConstants.RESISRC_SOURCE_POSITION])) {
                    datasetWrapper2.setResIsrcTransactionDs(JolModelFactory.getResIsrcModel(splittedLine, fileId));
                    datasetWrapper2.setResIsrcEnrichedDs(JolModelFactory.getResIsrcModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                }
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
            if (splittedLine.length > JolConstants.RESTITLE_SOURCE_POSITION) {
                if (JolConstants.RESTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESTITLE_SOURCE_POSITION])) {
                    datasetWrapper2.setResTitleTransactionalDs(JolModelFactory.getResTitleModel(splittedLine, fileId));
                    datasetWrapper2.setResTitleEnrichedDs(JolModelFactory.getResTitleModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                }
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
            if (splittedLine.length > JolConstants.RESMWTITLE_SOURCE_POSITION) {
                if (JolConstants.RESMWTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESMWTITLE_SOURCE_POSITION])) {
                    datasetWrapper2.setResTitleTransactionalDs(JolModelFactory.getResTitleModel(splittedLine, fileId));
                    datasetWrapper2.setResTitleEnrichedDs(JolModelFactory.getResTitleModel(splittedLine, fileId));
//                resourceModelRepository.save(fileId, datasetWrapper2);
//                System.out.println(datasetWrapper2.toString());
//                    return datasetWrapper2;
                    datasetWrapper2List.add(datasetWrapper2);
                }
            }
        }
        return datasetWrapper2List;
    }

    @Override
    public void streamToCache(String line, String fileName, long iterations) {
        IgniteCache<Long, List<DatasetWrapper>> datasetCache = igniteInstance.getOrCreateCache(CacheConfig.datasetWrapperCache());
        IgniteDataStreamer<Long, List<DatasetWrapper2>> datasetStreamer = igniteInstance.dataStreamer(datasetCache.getName());
        datasetStreamer.allowOverwrite(true);

        IgniteCompute igniteCompute = igniteInstance.compute();
        igniteCompute.broadcast(() -> {
            System.out.println("hello node");
        });
        igniteCompute.run(() -> {
            LocalDateTime startOfConversion = LocalDateTime.now();
            getLineInDataModel(line, fileName, iterations);
            Duration durationOfConversion = Duration.between(startOfConversion, LocalDateTime.now());
            System.out.println("duration of convertion: " + durationOfConversion);
            LocalDateTime startOfStreaming = LocalDateTime.now();
            datasetWrapper2Repository.save(fileName, datasetWrapper2List);
            Duration durationOStreaming = Duration.between(startOfStreaming, LocalDateTime.now());
            System.out.println("duration of save: " + durationOStreaming);
            datasetWrapper2List.forEach(datasetWrapper2 -> System.out.println(datasetWrapper2));
        });
        igniteCompute.broadcast(() -> System.out.println(Arrays.asList("1", "2").toString()));
//        igniteCompute.run(() -> datasetWrapper2List.forEach(datasetWrapper2 -> System.out.println(datasetWrapper2)));
        System.out.println(iterations);
    }

    private IgniteCompute igniteCompute;

//    private void getIgniteCompute() {
//        IgniteCompute igniteCompute = igniteInstance.compute();
//        this.igniteCompute = igniteCompute;
//    }

    private void dumpList() {
//        igniteCompute.broadcast(() -> System.out.println(datasetWrapper2List));
//        igniteCompute.broadcast(() -> datasetWrapper2List.forEach(datasetWrapper2 -> System.out.println(datasetWrapper2)));
    }
}

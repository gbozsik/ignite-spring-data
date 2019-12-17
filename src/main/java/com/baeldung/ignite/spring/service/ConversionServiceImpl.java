package com.baeldung.ignite.spring.service;

import com.baeldung.ignite.spring.factory.JolModelFactory;
import com.baeldung.ignite.spring.factory.enums.JolConstants;
import com.baeldung.ignite.spring.model.jolmodel.DatasetWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    private SplittedLineListService splittedLineListService;

    private List<String[]> splittedLineList;

    @Override
    public DatasetWrapper getDatasetWrapper() {
        splittedLineList = getSplittedLineList();
        return createDatasets();
    }

    private List<String[]> getSplittedLineList() {
        return splittedLineListService.getSplittedlineList();
    }

    private DatasetWrapper createDatasets() {
        DatasetWrapper datasetWrapper = new DatasetWrapper();
        datasetWrapper.setId(System.currentTimeMillis());
        long iterations = 0;
        for (String[] splittedLine : splittedLineList) {
            iterations++;
            switch (splittedLine[JolConstants.LINE_CODE_POSITION]) {
                case JolConstants.RES_LINE_CODE:
                    datasetWrapper.getResDs().add(JolModelFactory.getResourceModel(splittedLine));
                    break;
                case JolConstants.REL_LINE_CODE:
                    datasetWrapper.getRelDs().add(JolModelFactory.getRelJolModel(splittedLine));
                    break;
                case JolConstants.TX_LINE_CODE:
                    datasetWrapper.getTxDs().add(JolModelFactory.getTxModel(splittedLine, iterations));
                    break;
                case JolConstants.PRONTO_LINE_CODE:
                    datasetWrapper.getResProntoDs().add(JolModelFactory.getProntoModel(splittedLine));
                    break;
                case JolConstants.RESARTIST_LINE_CODE:
                    datasetWrapper.getResArtistJolModelDs().add(JolModelFactory.getArtistModel(splittedLine));
                    break;
                case JolConstants.RESCONTR_LINE_CODE:
                    datasetWrapper.getResContributorJolModelDs().add(JolModelFactory.getContribModel(splittedLine));
                    break;
//                case JolConstants.
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti

            if (splittedLine.length > JolConstants.RESISWC_SOURCE_POSITION) {
                if (JolConstants.RESISWC_LINE_CODE.equals(splittedLine[JolConstants.RESISWC_SOURCE_POSITION])) {
                    datasetWrapper.getResIswcTransactionDs().add(JolModelFactory.getResIswcModel(splittedLine));
                    datasetWrapper.getResIswcEnrichedDs().add(JolModelFactory.getResIswcModel(splittedLine));
                }
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
            if (splittedLine.length > JolConstants.RESISRC_SOURCE_POSITION) {
                if (JolConstants.RESISRC_LINE_CODE.equals(splittedLine[JolConstants.RESISRC_SOURCE_POSITION])) {
                    datasetWrapper.getResIsrcTransactionDs().add(JolModelFactory.getResIsrcModel(splittedLine));
                    datasetWrapper.getResIsrcEnrichedDs().add(JolModelFactory.getResIsrcModel(splittedLine));
                }
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
            if (splittedLine.length > JolConstants.RESTITLE_SOURCE_POSITION) {
                if (JolConstants.RESTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESTITLE_SOURCE_POSITION])) {
                    datasetWrapper.getResTitleTransactionalDs().add(JolModelFactory.getResTitleModel(splittedLine));
                    datasetWrapper.getResTitleEnrichedDs().add(JolModelFactory.getResTitleModel(splittedLine));
                }
            }
            // itt a jol fájban ugyanott elhelyezkedő adatokat két modelbe is betölti
            if (splittedLine.length > JolConstants.RESMWTITLE_SOURCE_POSITION) {
                if (JolConstants.RESMWTITLE_LINE_CODE.equals(splittedLine[JolConstants.RESMWTITLE_SOURCE_POSITION])) {
                    datasetWrapper.getResTitleTransactionalDs().add(JolModelFactory.getResTitleModel(splittedLine));
                    datasetWrapper.getResTitleEnrichedDs().add(JolModelFactory.getResTitleModel(splittedLine));
                }
            }
        }
        return datasetWrapper;
    }
}

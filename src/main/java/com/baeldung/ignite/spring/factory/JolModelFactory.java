/*
 *
 *  Copyright (c) 2017 Sonrisa Informatikai Kft. All Rights Reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Sonrisa Informatikai Kft. ("Confidential Information").
 *  You shall not disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Sonrisa.
 *
 *  SONRISA MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 *  THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 *  TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 *  PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SONRISA SHALL NOT BE LIABLE FOR
 *  ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 *  DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.baeldung.ignite.spring.factory;

import com.baeldung.ignite.spring.factory.enums.JolConstants;
import com.baeldung.ignite.spring.model.jolmodel.RelJolModel;
import com.baeldung.ignite.spring.model.jolmodel.ResArtistJolModel;
import com.baeldung.ignite.spring.model.jolmodel.ResContributorJolModel;
import com.baeldung.ignite.spring.model.jolmodel.ResIsrcJolModel;
import com.baeldung.ignite.spring.model.jolmodel.ResIswcJolModel;
import com.baeldung.ignite.spring.model.jolmodel.ResProntoJolModel;
import com.baeldung.ignite.spring.model.jolmodel.ResTitleModel;
import com.baeldung.ignite.spring.model.jolmodel.ResourceModel;
import com.baeldung.ignite.spring.model.jolmodel.TxJolModel;
import org.springframework.util.StringUtils;


public class JolModelFactory {

    private JolModelFactory() {
    }

    /**
     * String tombkent megkapott sorbol letrehozza a ResIsrcModelt
     *
     * @param row sort reprezentalo string tomb
     * @return ResIsrcJolModel
     */
    public static ResIsrcJolModel getResIsrcModel(final String[] row, String fielId) {
        return new ResIsrcJolModel(fielId, row[JolConstants.BLOCK_ID_POSITION], row[JolConstants.UNIQUE_ID_POSITION]);
    }


    /**
     * String tombkent megkapott sorbol letrehozza a ResIswcModelt
     *
     * @param row sort reprezentalo string tomb
     * @return ResIswcJolModel
     */
    public static ResIswcJolModel getResIswcModel(final String[] row, String fileId) {
        return new ResIswcJolModel(fileId, row[JolConstants.BLOCK_ID_POSITION], row[JolConstants.UNIQUE_ID_POSITION]);
    }

    /**
     * String tombkent megkapott sorbol letrehozza a ResourceModelt
     *
     * @param row sort reprezentalo string tomb
     * @return ResourceModel
     */
    public static ResourceModel getResourceModel(final String[] row, String fileId) {
        final String durationField = row[JolConstants.RES_DURATION_POSITION];
        ResourceModel resourceModel = new ResourceModel(row[JolConstants.BLOCK_ID_POSITION], row[JolConstants.UNIQUE_BLOCK_ID_POSITION],
                row[JolConstants.PROPRIETARY_ID_POSITION],
                StringUtils.isEmpty(durationField) ? null : Long.parseLong(durationField),
                row[JolConstants.RES_MW_ROPRIETARY_ID_POSITION], row[JolConstants.RESOURCE_TYPE_POSITION]);
        resourceModel.setFileId(fileId);
        return resourceModel;
    }

    /**
     * String tombkent megkapott sorbol letrehozza a TxModelt
     *
     * @param row sort reprezentalo string tomb
     * @param rowId spark altal generalt egyedi megkulonbozeto a tx sorokra, meg lesz novelve 1 gyel,
     *              hogy a sorozat 1 gyel induljon es megegye az MS excel.
     * @return TxJolModel
     */
    public static TxJolModel getTxModel(final String[] row, String fileId, final Long rowId) {
        final Integer txUsages = row[JolConstants.TX_USAGES_POSITION].isEmpty() ? null :
                Integer.parseInt(row[JolConstants.TX_USAGES_POSITION]);
        final Integer txReturns = row[JolConstants.TX_RETURNS_POSITION].isEmpty() ? null :
                Integer.parseInt(row[JolConstants.TX_RETURNS_POSITION]);
        final Double txNetRevenue = row[JolConstants.TX_NET_REVENUE_POSITION].isEmpty() ? null :
                Double.parseDouble(row[JolConstants.TX_NET_REVENUE_POSITION]);
        final Double txGrossRevenue = row[JolConstants.TX_GROSS_REVENUE_POSITION].isEmpty() ? null :
                Double.parseDouble(row[JolConstants.TX_GROSS_REVENUE_POSITION]);
        final Double txPriceConsumerPaidExcSalesTax =
                row[JolConstants.TX_PRICE_CONSUMER_PAID_EXC_SALES_TAX_POSITION].isEmpty() ? null :
                Double.parseDouble(row[JolConstants.TX_PRICE_CONSUMER_PAID_EXC_SALES_TAX_POSITION]);
        final Integer freeUnits = row[JolConstants.TX_FREE_UNITS_POSITION].isEmpty() ? null :
                        Integer.parseInt(row[JolConstants.TX_FREE_UNITS_POSITION]);

        return new TxJolModel(fileId, row[JolConstants.BLOCK_ID_POSITION],row[JolConstants.TX_TRANSACTION_ID_POSITION],
                txUsages, txReturns, txNetRevenue, txGrossRevenue,txPriceConsumerPaidExcSalesTax, freeUnits,
                rowId + 1L); //microsoft excel support
    }

    /**
     * String tombkent megkapott sorbol letrehozza a ResProntoModelt
     *
     * @param row sort reprezentalo string tomb
     * @return ResProntoJolModel
     */
    public static ResProntoJolModel getProntoModel(final String[] row, String fileId) {
        return new ResProntoJolModel(fileId, row[JolConstants.BLOCK_ID_POSITION],
                row[JolConstants.UNIQUE_BLOCK_ID_POSITION], Long.parseLong(row[JolConstants.PRONTO_AIRMU_POSITION]),
                Double.parseDouble(row[JolConstants.PRONTO_PERCENT_POSITION]));
    }

    /**
     * String tombkent megkapott sorbol letrehozza a ResTitleModelt
     *
     * @param row sort reprezentalo string tomb
     * @return ResTitleModel
     */
    public static ResTitleModel getResTitleModel(final String[] row, String fileId) {
        return new ResTitleModel(fileId, row[JolConstants.BLOCK_ID_POSITION], row[JolConstants.RESTITLE_TITLE_POSITION]);
    }

    /**
     * String tombkent megkapott sorbol letrehozza a RelJolModelt
     *
     * @param row sort reprezentalo string tomb
     * @return RelJolModel
     */
    public static RelJolModel getRelJolModel(final String[] row, String fileId){
        return RelJolModel.builder()
                .fileId(fileId)
                .blockId(row[JolConstants.BLOCK_ID_POSITION])
                .proprietaryId(row[JolConstants.REL_PROPRIETARY_ID_POSITION])
                .title(row[JolConstants.REL_TITLE_POSITION])
                .displayArtist(row[JolConstants.REL_DISPLAY_ARTIST_POSITION])
                .label(row[JolConstants.REL_LABEL_POSITION])
                .subtitle(row[JolConstants.REL_SUBTITLE_POSITION])
                .icpn(row[JolConstants.REL_ICPN_POSITION])
                .releaseType(row[JolConstants.REL_RELEASE_TYPE_POSITION])
                .pline(row[JolConstants.REL_PLINE_POSITION])
                .build();
    }

    /**
     * String tombkent megkapott sorbol letrehozza a ResArtistJolModel
     *
     * @param row sort reprezentalo string tomb
     * @return ResArtistJolModel
     */
    public static ResArtistJolModel getArtistModel(final String[] row, String fileId) {
        return new ResArtistJolModel(fileId, row[JolConstants.BLOCK_ID_POSITION],
                row[JolConstants.RESARTIST_DISPLAY_ARTIST_POSITION]);
    }

    /**
     * String tombkent megkapott sorbol letrehozza a ResContributorJolModel
     *
     * @param row sort reprezentalo string tomb
     * @return ResContributorJolModel
     */
    public static ResContributorJolModel getContribModel(final String[] row, String fileId) {
        return new ResContributorJolModel(fileId, row[JolConstants.BLOCK_ID_POSITION],
                row[JolConstants.RESCONTR_CONTRIBUTOR_NAMES_POSITION]);
    }
}

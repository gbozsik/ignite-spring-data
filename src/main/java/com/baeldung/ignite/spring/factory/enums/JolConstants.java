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
package com.baeldung.ignite.spring.factory.enums;

/**
 * Ez az osztaly tartalmazza a JOL fajlban talalhato konstansokat, es egyeb JOL specifikus dolgokat
 *
 * @author Szentes Szabolcs
 */
public final class JolConstants {

    public static final String WORD_DELIMITER = "|";

    public static final String ESCAPED_WORD_DELIMITER = "\\" + WORD_DELIMITER;

    public static final int LINE_CODE_POSITION = 0;

    public static final String RES_LINE_CODE = "RES";

    public static final String RESISWC_LINE_CODE = "RESISWC";

    public static final String RESISRC_LINE_CODE = "RESISRC";

    public static final String RESTITLE_LINE_CODE = "RESTITLE";

    public static final String RESMWTITLE_LINE_CODE = "RESMWTITLE";

    public static final String RESARTIST_LINE_CODE = "RESARTIST";

    public static final String RESCONTR_LINE_CODE = "RESCONTR";

    public static final String REL_LINE_CODE = "REL";

    public static final String TX_LINE_CODE = "TX";

    public static final String PRONTO_LINE_CODE = "MRES";

    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd";

    public static final int JOL_FIRST_LINE_LENGTH = 10;

    public static final int JOL_SECOND_LINE_LENGTH = 11;

    public static final String GZIP_EXTENSION = "gz";

    public static final String JOL_EXTENSION = "jol";

    public static final String MASTERLIST_EXTENSION = "csv";

    public static final int RES_LINE_LENGTH = 7;

    public static final int REL_LINE_LENGTH = 13;

    public static final int RESISWC_LINE_LENGTH = 4;

    public static final int RESISRC_LINE_LENGTH = 4;

    public static final int TX_LINE_LENGTH = 10;

    public static final int PRONTO_LINE_LENGTH = 5;

    public static final int RESTITLE_LINE_LENGTH = 5;

    public static final int RESMWTITLE_LINE_LENGTH = 5;

    public static final int AREA_CODE_POSITION = 6;

    public static final int CURRENCY_POSITION = 8;

    public static final int MESSAGE_ID_POSITION = 2;

    public static final int START_DATE_POSITION = 4;

    public static final int END_DATE_POSITION = 5;

    public static final int SENDER_PARTY_ID_POSITION = 6;

    public static final int SUBSCRIBERS_POSITION = 7;

    public static final int NET_REVENUE_POSITION = 9;

    public static final int GROSS_REVENUE_POSITION = 10;

    public static final int RESISWC_SOURCE_POSITION = 3;

    public static final int RESTITLE_TITLE_POSITION = 2;

    public static final int RESTITLE_SOURCE_POSITION = 4;

    public static final int RESMWTITLE_TITLE_POSITION = 2;

    public static final int RESMWTITLE_SOURCE_POSITION = 4;

    public static final int RESISRC_SOURCE_POSITION = 3;

    public static final String ENRICHED = "enriched";

    public static final int SENDER_NAME_POSITION = 7;

    public static final int COMMERCIAL_MODEL_POSITION = 1;

    public static final int USE_TYPE_POSITION = 2;

    public static final int SERVICE_DESCRIPTION_POSITION = 3;

    public static final String HU_ISRC_PREFIX = "HU";

    public static final int BLOCK_ID_POSITION = 1;

    public static final int UNIQUE_ID_POSITION = 2;

    public static final int UNIQUE_BLOCK_ID_POSITION = 2;

    public static final int PROPRIETARY_ID_POSITION = 3;

    public static final int RESOURCE_TYPE_POSITION = 5;

    public static final int RES_MW_ROPRIETARY_ID_POSITION = 6;

    public static final int REL_PROPRIETARY_ID_POSITION = 2;

    public static final int REL_LABEL_POSITION = 7;

    public static final int REL_DISPLAY_ARTIST_POSITION = 9;

    public static final int REL_SUBTITLE_POSITION = 12;

    public static final int REL_ICPN_POSITION = 4;

    public static final int REL_RELEASE_TYPE_POSITION = 6;

    public static final int REL_PLINE_POSITION = 8;

    public static final int REL_TITLE_POSITION = 11;

    public static final int TX_TRANSACTION_ID_POSITION = 2;

    public static final int TX_USAGES_POSITION = 3;

    public static final int TX_RETURNS_POSITION = 4;

    public static final int TX_PRICE_CONSUMER_PAID_EXC_SALES_TAX_POSITION = 7;

    public static final int TX_FREE_UNITS_POSITION = 5;

    public static final int TX_NET_REVENUE_POSITION = 8;

    public static final int TX_GROSS_REVENUE_POSITION = 9;

    public static final int PRONTO_AIRMU_POSITION = 3;

    public static final int PRONTO_PERCENT_POSITION = 4;

    public static final int RES_DURATION_POSITION = 4;

    public static final int RES_RELEASE_ID_POSITION = 2;

    public static final int PRONTO_MATCH_RESOURCE_ID_POSITION = 2;

    public static final int RESCONTR_CONTRIBUTOR_NAMES_POSITION = 2;

    public static final int RESARTIST_DISPLAY_ARTIST_POSITION = 2;

    public static final int RESARTIST_LINE_LENGTH = 6;

    public static final int RESCONTR_LINE_LENGTH = 6;

    private JolConstants() {
    }

}

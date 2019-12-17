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
package com.baeldung.ignite.spring.model.jolmodel;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

/**
 * JOL file-ban levo REL sorok model-je.
 * Elvileg immutable, mivel a JOL sor alapjan letrejon.
 * Azonban a Spark-os belso kodgeneralas miatt szukseg van a bean kompatibilitasra:
 * minden attributumbnak legyen settere is, illetve default konstruktorra.
 * Ezert az attributumok nem lehetnek final-ek, igy csak elvileg immutable, a settereket keretik nem hasznalni...
 *
 * @author Szentes Szabolcs
 */
@Getter
@Setter
@EqualsAndHashCode(of = "blockId")
@ToString
@Builder
public class RelJolModel implements Serializable {

    /*
    A feldolgozaskor hivatkozott attributum nevek
     */
    public static final String BLOCK_ID = "blockId";
    public static final String PROPRIETARY_ID = "proprietaryId";
    public static final String TITLE = "title";
    public static final String DISPLAY_ARTIST = "displayArtist";
    public static final String LABEL = "label";
    public static final String SUBTITLE = "subtitle";
    public static final String ICPN = "icpn";
    public static final String RELEASE_TYPE = "releaseType";
    public static final String PLINE = "pline";

    @QuerySqlField(index = true)
    private String blockId;
    @QuerySqlField
    private String proprietaryId;
    @QuerySqlField
    private String title;
    @QuerySqlField
    private String displayArtist;
    @QuerySqlField
    private String label;
    @QuerySqlField
    private String subtitle;
    @QuerySqlField
    private String icpn;
    @QuerySqlField
    private String releaseType;
    @QuerySqlField
    private String pline;

//    public RelJolModel(String blockId, String proprietaryId, String title, String displayArtist, String label, String subtitle, String icpn, String releaseType, String pline) {
//        this.blockId = blockId;
//        this.proprietaryId = proprietaryId;
//        this.title = title;
//        this.displayArtist = displayArtist;
//        this.label = label;
//        this.subtitle = subtitle;
//        this.icpn = icpn;
//        this.releaseType = releaseType;
//        this.pline = pline;
//    }

    @Tolerate
    public RelJolModel() {
    }
}

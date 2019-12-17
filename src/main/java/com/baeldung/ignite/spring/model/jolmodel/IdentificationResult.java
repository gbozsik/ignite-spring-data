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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

/**
 * Egy azonositas eredmenye
 *
 * @author Kosztolnik Bence
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationResult implements Serializable {

    public static final String AIR_MU = "airMu";
    public static final String PERCENTAGE = "percentage";
    public static final String PERCENTAGE_COMMENT = "percentageComment";

    // az azonositott AIR mukod
    @QuerySqlField(index = true)
    private Long airMu;
    // az azonositas szazalekos pontossaga
    @QuerySqlField(index = true)
    private Double percentage;
    // a szazalekos pontossaghpz fuzott komment
    @QuerySqlField(index = true)
    private String percentageComment;

    /**
     * Eredmeny konstruktor
     * @param percentage az azonositas szazalekos pontossaga
     * @param percentageComment a szazalekos pontossaghpz fuzott komment
     */
}

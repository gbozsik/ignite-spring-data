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

/**
 * Egy azonositas eredmenyet egesziti ki a vegleges azonositasra vonatkozo adatokkal
 * @author Kosztolnik Bence
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class FinalIdentificationResult extends IdentificationResult {
    public static final String RULE = "rule";

    private String rule;

    /**
     * Letrehoz egy vegleges azonositasi eredmenyt egy azonositasi eredmeny alapjan
     * @param identificationResult a veglegesitendo azonositasi eredmeny
     * @param rule a szabaly neve mely alapjan ki lett nevezve veglegesnek
     */
    public FinalIdentificationResult(final IdentificationResult identificationResult, final String rule){
        super();
        super.setAirMu(identificationResult.getAirMu());
        super.setPercentage(identificationResult.getPercentage());
        super.setPercentageComment(identificationResult.getPercentageComment());
        this.rule = rule;
    }
}

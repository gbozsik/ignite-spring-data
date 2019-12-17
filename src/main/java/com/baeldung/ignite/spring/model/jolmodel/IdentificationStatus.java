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

/**Az azonositasi folyamatban ha egy szabaly talalatot erzekel ebbol az osztalybol kapja meg,
 * hogy a {@link hu.sonrisa.artisjus.model.processing.ResourceModel} "identificationStatus" mezojebe,
 * milyen allapotot kell irnia
 * @author Kosztolnik Bence
 */
public class IdentificationStatus {

    public static final String NOT_IDENTIFIED = "NOT_IDENTIFIED";

    public static final String IDENTIFIED = "IDENTIFIED";

    public static final String UNDER_LIMIT = "UNDER_LIMIT";

    private IdentificationStatus(){
    }
}

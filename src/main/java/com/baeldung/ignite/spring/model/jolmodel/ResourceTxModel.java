/*
 *
 *  Copyright (c) 2018 Sonrisa Informatikai Kft. All Rights Reserved.
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

import java.util.Objects;

/**
 * Az elmeleti jogdij kiszamitasahoz szukseges,
 * hogy a {@link ResourceModel}-eken taroljunk hozzajuk tartozo TX sorokhoz kapcsolhato adatokat.
 * Ez az seged osztaly hordozza egy TX sor adatait.
 * Az adatok kesobb az adatpiac eloallitasahoz is hasznalva lesznek.
 *
 * @author Kosztolnik Bence
 */
public class ResourceTxModel extends TxJolModel {

    public static final String PRICE_BASIS = "priceBasis";
    public static final String TARIF_FEE_PERCENTAGE = "tarifFeePercentage";
    public static final String TARIF_FEE_MINIMUM = "tarifFeeMinimum";
    public static final String REL_PERCENT_ROYALTY_FEE = "relPercentRoyaltyFee";
    public static final String REL_MINIMUM_ROYALTY_FEE = "relMinimumRoyaltyFee";
    public static final String PERCENT_ROYALTY_FEE = "percentRoyaltyFee";
    public static final String MINIMUM_ROYALTY_FEE = "minimumRoyaltyFee";
    public static final String USAGE_ROYALTY_FEE = "usageRoyaltyFee";
    public static final String ROYALTY_FEE = "royaltyFee";
    public static final String RES_USAGE_SHARE = "resUsageShare";
    public static final String UNIT_PRICE = "unitPrice";
    public static final String TARGET_ROYALTY_FEE = "targetRoyaltyFee";
    public static final String ROYALTY_TYPE = "royaltyType";

    private double priceBasis;
    private double tarifFeePercentage;
    private double tarifFeeMinimum;
    private double relPercentRoyaltyFee;
    private double relMinimumRoyaltyFee;
    private double percentRoyaltyFee;
    private double minimumRoyaltyFee;
    private double usageRoyaltyFee;
    private double royaltyFee;
    private double resUsageShare;
    private double unitPrice;
    private double targetRoyaltyFee;
    private String royaltyType;


    public ResourceTxModel() {//NOSONAR
        //SPARK
    }

    /**
     * Az os alapjan letrehoz egy uj objektumot
     * @param tx az os
     */
    public ResourceTxModel(final TxJolModel tx) {
        super(tx.getBlockId(),tx.getTransactionId(),tx.getUsages(),tx.getReturns(), tx.getNetRevenue(),
                tx.getGrossRevenue(),tx.getPriceConsumerPaidExcSalesTax(), tx.getFreeUnits(), tx.getEfdTxId());
    }

    public double getPriceBasis() {
        return priceBasis;
    }

    public void setPriceBasis(final double priceBasis) {
        this.priceBasis = priceBasis;
    }

    public double getTarifFeePercentage() {
        return tarifFeePercentage;
    }

    public void setTarifFeePercentage(final double tarifFeePercentage) {
        this.tarifFeePercentage = tarifFeePercentage;
    }

    public double getTarifFeeMinimum() {
        return tarifFeeMinimum;
    }

    public void setTarifFeeMinimum(final double tarifFeeMinimum) {
        this.tarifFeeMinimum = tarifFeeMinimum;
    }

    public double getRelPercentRoyaltyFee() {
        return relPercentRoyaltyFee;
    }

    public void setRelPercentRoyaltyFee(final double relPercentRoyaltyFee) {
        this.relPercentRoyaltyFee = relPercentRoyaltyFee;
    }

    public double getRelMinimumRoyaltyFee() {
        return relMinimumRoyaltyFee;
    }

    public void setRelMinimumRoyaltyFee(final double relMinimumRoyaltyFee) {
        this.relMinimumRoyaltyFee = relMinimumRoyaltyFee;
    }

    public double getPercentRoyaltyFee() {
        return percentRoyaltyFee;
    }

    public void setPercentRoyaltyFee(final double percentRoyaltyFee) {
        this.percentRoyaltyFee = percentRoyaltyFee;
    }

    public double getMinimumRoyaltyFee() {
        return minimumRoyaltyFee;
    }

    public void setMinimumRoyaltyFee(final double minimumRoyaltyFee) {
        this.minimumRoyaltyFee = minimumRoyaltyFee;
    }

    public double getUsageRoyaltyFee() {
        return usageRoyaltyFee;
    }

    public void setUsageRoyaltyFee(final double usageRoyaltyFee) {
        this.usageRoyaltyFee = usageRoyaltyFee;
    }

    public double getRoyaltyFee() {
        return royaltyFee;
    }

    public void setRoyaltyFee(final double royaltyFee) {
        this.royaltyFee = royaltyFee;
    }

    public double getResUsageShare() {
        return resUsageShare;
    }

    public void setResUsageShare(final double resUsageShare) {
        this.resUsageShare = resUsageShare;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(final double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTargetRoyaltyFee() {
        return targetRoyaltyFee;
    }

    public void setTargetRoyaltyFee(final double targetRoyaltyFee) {
        this.targetRoyaltyFee = targetRoyaltyFee;
    }

    public String getRoyaltyType() {
        return royaltyType;
    }

    public void setRoyaltyType(final String royaltyType) {
        this.royaltyType = royaltyType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        ResourceTxModel that = (ResourceTxModel) o;
        return Double.compare(that.getPriceBasis(), getPriceBasis()) == 0 &&
                Double.compare(that.getTarifFeePercentage(), getTarifFeePercentage()) == 0 &&
                Double.compare(that.getTarifFeeMinimum(), getTarifFeeMinimum()) == 0 &&
                Double.compare(that.getRelPercentRoyaltyFee(), getRelPercentRoyaltyFee()) == 0 &&
                Double.compare(that.getRelMinimumRoyaltyFee(), getRelMinimumRoyaltyFee()) == 0 &&
                Double.compare(that.getPercentRoyaltyFee(), getPercentRoyaltyFee()) == 0 &&
                Double.compare(that.getMinimumRoyaltyFee(), getMinimumRoyaltyFee()) == 0 &&
                Double.compare(that.getUsageRoyaltyFee(), getUsageRoyaltyFee()) == 0 &&
                Double.compare(that.getRoyaltyFee(), getRoyaltyFee()) == 0 &&
                Double.compare(that.getResUsageShare(), getResUsageShare()) == 0 &&
                Double.compare(that.getUnitPrice(), getUnitPrice()) == 0 &&
                Double.compare(that.getTargetRoyaltyFee(), getTargetRoyaltyFee()) == 0 &&
                Objects.equals(getRoyaltyType(), that.getRoyaltyType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPriceBasis(), getTarifFeePercentage(), getTarifFeeMinimum(),
                getRelPercentRoyaltyFee(), getRelMinimumRoyaltyFee(), getPercentRoyaltyFee(), getMinimumRoyaltyFee(),
                getUsageRoyaltyFee(), getRoyaltyFee(), getResUsageShare(), getUnitPrice(), getTargetRoyaltyFee(),
                getRoyaltyType());
    }

//    @Override
//    public String toString() {
//        return MoreObjects.toStringHelper(this)
//                .add("priceBasis", priceBasis)
//                .add("tarifFeePercentage", tarifFeePercentage)
//                .add("tarifFeeMinimum", tarifFeeMinimum)
//                .add("relPercentRoyaltyFee", relPercentRoyaltyFee)
//                .add("relMinimumRoyaltyFee", relMinimumRoyaltyFee)
//                .add("percentRoyaltyFee", percentRoyaltyFee)
//                .add("minimumRoyaltyFee", minimumRoyaltyFee)
//                .add("usageRoyaltyFee", usageRoyaltyFee)
//                .add("royaltyFee", royaltyFee)
//                .add("resUsageShare", resUsageShare)
//                .add("unitPrice", unitPrice)
//                .add("targetRoyaltyFee", targetRoyaltyFee)
//                .add("royaltyType", royaltyType)
//                .add("blockId", blockId)
//                .add("transactionId", transactionId)
//                .add("usages", usages)
//                .add("returns", returns)
//                .add("netRevenue", netRevenue)
//                .add("grossRevenue", grossRevenue)
//                .add("priceConsumerPaidExcSalesTax", priceConsumerPaidExcSalesTax)
//                .add("efdTxId", efdTxId)
//                .add("freeUnits", freeUnits)
//                .toString();
//    }
}

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


import lombok.ToString;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.List;
import java.util.Objects;

/**
 * A feldolgozas soran a muveket (resource) tartalmazo absztrakcio, a feldolgozas legelemibb egysege.
 * A JOL file-bol felolvasott ResJolModel-t terjeszti ki a feldolgozas soran kalkulalt attributumokkal,
 * pl.: elmeleti jogdij
 *
 * Azon attributumok, amelyek a JOL fajl RES sorabol jonnek, azok elvileg immutable-ek,
 * a felolvasaskor kitoltesre kerulnek, a tobbi attributum a feldolgoyzas kesobbi lepeseiben.
 *
 * @author Szentes Szabolcs
 */
@ToString
public class ResourceModel extends ResJolModel {

    /* A feldolgozaskor hivatkozott attributum nevek */
    public static final String ENRICHED_ISWC = "enrichedISWC";
    public static final String ENRICHED_ISRC = "enrichedISRC";
    public static final String ENRICHED_TITLES = "enrichedTitles";
    public static final String DOWNLOAD = "download";
    public static final String WORK_GROUP_ID = "workGroupId";
    public static final String PROPRIETARY_IDENTIFICATION_RESULTS = "proprietaryIdentificationResults";
    public static final String PRONTO_IDENTIFICATION_RESULTS = "prontoIdentificationResults";
    public static final String TRANSACTION_ISWC = "transactionISWC";
    public static final String TRANSACTION_ISRC = "transactionISRC";
    public static final String TRANSACTION_TITLES = "transactionTitles";
    public static final String IDENTIFICATION_STATUS = "identificationStatus";
    public static final String TRANSACTION_ISWC_IDENTIFICATION_RESULTS = "transactionISWCIdentificationResults";
    public static final String ENRICHED_ISWC_IDENTIFICATION_RESULTS = "enrichedISWCIdentificationResults";
    public static final String TRANSACTION_ISRC_IDENTIFICATION_RESULTS = "transactionISRCIdentificationResults";
    public static final String ENRICHED_ISRC_IDENTIFICATION_RESULTS = "enrichedISRCIdentificationResults";
    public static final String FINAL_IDENTIFICATION_RESULT = "finalIdentificationResult";
    public static final String ID = "id";
    public static final String REL_PROPRIETARY_ID = "relProprietaryId";
    public static final String REL_TITLE = "relTitle";
    public static final String REL_DISPLAY_ARTIST = "relDisplayArtist";
    public static final String REL_SUBTITLE = "relSubtitle";
    public static final String REL_ICPN = "relIcpn";
    public static final String REL_RELEASE_TYPE = "relReleaseType";
    public static final String REL_PLINE = "relPline";
    public static final String REL_LABEL = "relLabel";
    public static final String DISPLAY_ARTIST_NAMES = "displayArtistNames";
    public static final String CONTRIBUTOR_NAMES = "contributorNames";
    public static final String TRANSACTION_TITLES_ORIGINAL = "transactionTitlesOriginal";
    public static final String ENRICHED_TITLES_ORIGINAL = "enrichedTitlesOriginal";
    public static final String FILE_NAME = "fileName";

    public static final String RESOURCE_TRANSACTIONS = "resourceTransactions";
    public static final String REL_DURATION = "relDuration";
    public static final String NR_OF_RESOURCES = "nrOfResources";
    public static final String MUSIC_SHARE = "musicShare";
    public static final String REL_TX_COUNT = "relTxCount";
    public static final String REL_USAGES = "relUsages";
    public static final String REL_USAGE_SHARE = "relUsageShare";
    public static final String USAGE_SHARE = "usageShare";

    @QuerySqlField(index = true)
    private String workGroupId;
    @QuerySqlField
    private String enrichedISWC;
    @QuerySqlField
    private String enrichedISRC;
    @QuerySqlField
    private List<String> enrichedTitles;
    @QuerySqlField
    private int download;
    @QuerySqlField
    private String identificationStatus = IdentificationStatus.NOT_IDENTIFIED;
    @QuerySqlField
    private List<IdentificationResult> transactionISWCIdentificationResults;
    @QuerySqlField
    private List<IdentificationResult> enrichedISWCIdentificationResults;
    @QuerySqlField
    private List<IdentificationResult> transactionISRCIdentificationResults;
    @QuerySqlField
    private List<IdentificationResult> enrichedISRCIdentificationResults;
    @QuerySqlField
    private List<IdentificationResult> proprietaryIdentificationResults;
    @QuerySqlField
    private List<IdentificationResult> prontoIdentificationResults;
    @QuerySqlField
    private FinalIdentificationResult finalIdentificationResult;
    @QuerySqlField
    private String transactionISWC;
    @QuerySqlField
    private String transactionISRC;
    @QuerySqlField
    private List<String> transactionTitles;
    @QuerySqlField
    private String id;
    @QuerySqlField
    private String relProprietaryId;
    @QuerySqlField
    private String relTitle;
    @QuerySqlField
    private String relDisplayArtist;
    @QuerySqlField
    private String relLabel;
    @QuerySqlField
    private String relSubtitle;
    @QuerySqlField
    private String relIcpn;
    @QuerySqlField
    private String relReleaseType;
    @QuerySqlField
    private String relPline;
    @QuerySqlField
    private String fileName;
    @QuerySqlField
    private List<String> displayArtistNames;
    @QuerySqlField
    private List<String> contributorNames;
    @QuerySqlField
    private List<String> transactionTitlesOriginal;
    @QuerySqlField
    private List<String> enrichedTitlesOriginal;


    //2.0
    //Az uj jogdij kalkulacio miat szukseges mezok talalhatok ez alatt
    //NEM KERULNEK BE A ROW KONSTRUKTORBA, MERT AZ KIVEZETESRE FOG KERULNI!
    //Fejlesztes vegen ossze kell oket fesulni a tobbi mezovel
    @QuerySqlField
    private List<ResourceTxModel> resourceTransactions;
    @QuerySqlField
    private long relDuration;
    @QuerySqlField
    private long nrOfResources;
    @QuerySqlField
    private double musicShare;
    @QuerySqlField
    private int relTxCount;
    @QuerySqlField
    private int relUsages;
    @QuerySqlField
    private double relUsageShare;
    @QuerySqlField
    private double usageShare;

    /**
     * Spark miatt szukseges konstruktor
     */
    public ResourceModel() {
    }

    /**
     * Jol sor felolvasasakor hasznalt konstruktor
     *
     * @param blockId blockId
     * @param relBlockId relBlockId
     * @param proprietaryId idegen azonosito (DSP azonosito)
     * @param duration a mu hossza
     * @param mwProprietaryId mwProprietaryId
     * @param resourceType resource tipusa
     */
    public ResourceModel(final String blockId, final String relBlockId, final String proprietaryId,
                         final Long duration, final String mwProprietaryId, final String resourceType) {
        super(blockId, relBlockId, proprietaryId, mwProprietaryId, duration, resourceType);
    }

    public String getIdentificationStatus() {
        return identificationStatus;
    }

    public void setIdentificationStatus(final String identificationStatus) {
        this.identificationStatus = identificationStatus;
    }

    public List<IdentificationResult> getTransactionISWCIdentificationResults() {
        return transactionISWCIdentificationResults;
    }

    public void setTransactionISWCIdentificationResults(
            final List<IdentificationResult> transactionISWCIdentificationResults) {
        this.transactionISWCIdentificationResults = transactionISWCIdentificationResults;
    }

    public FinalIdentificationResult getFinalIdentificationResult() {
        return finalIdentificationResult;
    }

    public void setFinalIdentificationResult(final FinalIdentificationResult finalIdentificationResult) {
        this.finalIdentificationResult = finalIdentificationResult;
    }

    public String getTransactionISWC() {
        return transactionISWC;
    }

    public void setTransactionISWC(final String transactionISWC) {
        this.transactionISWC = transactionISWC;
    }

    public List<IdentificationResult> getTransactionISRCIdentificationResults() {
        return transactionISRCIdentificationResults;
    }

    public void setTransactionISRCIdentificationResults(
            final List<IdentificationResult> transactionISRCIdentificationResults) {
        this.transactionISRCIdentificationResults = transactionISRCIdentificationResults;
    }

    public List<IdentificationResult> getProntoIdentificationResults() {
        return prontoIdentificationResults;
    }

    public void setProntoIdentificationResults(
            final List<IdentificationResult> prontoIdentificationResults) {
        this.prontoIdentificationResults = prontoIdentificationResults;
    }

    public String getEnrichedISWC() {
        return enrichedISWC;
    }

    public void setEnrichedISWC(final String enrichedISWC) {
        this.enrichedISWC = enrichedISWC;
    }

    public String getTransactionISRC() {
        return transactionISRC;
    }

    public void setTransactionISRC(final String transactionISRC) {
        this.transactionISRC = transactionISRC;
    }

    public String getEnrichedISRC() {
        return enrichedISRC;
    }

    public void setEnrichedISRC(final String enrichedISRC) {
        this.enrichedISRC = enrichedISRC;
    }

    public List<String> getTransactionTitles() {
        return transactionTitles;
    }

    public void setTransactionTitles(final List<String> transactionTitles) {
        this.transactionTitles = transactionTitles;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<String> getEnrichedTitles() {
        return enrichedTitles;
    }

    public void setEnrichedTitles(final List<String> enrichedTitles) {
        this.enrichedTitles = enrichedTitles;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(final int download) {
        this.download = download;
    }

    public List<IdentificationResult> getProprietaryIdentificationResults() {
        return proprietaryIdentificationResults;
    }

    public void setProprietaryIdentificationResults(final List<IdentificationResult> proprietaryIdentificationResults) {
        this.proprietaryIdentificationResults = proprietaryIdentificationResults;
    }

    public String getRelProprietaryId() {
        return relProprietaryId;
    }

    public void setRelProprietaryId(final String relProprietaryId) {
        this.relProprietaryId = relProprietaryId;
    }

    public String getRelTitle() {
        return relTitle;
    }

    public void setRelTitle(final String relTitle) {
        this.relTitle = relTitle;
    }

    public String getRelDisplayArtist() {
        return relDisplayArtist;
    }

    public void setRelDisplayArtist(final String relDisplayArtist) {
        this.relDisplayArtist = relDisplayArtist;
    }

    public String getRelLabel() {
        return relLabel;
    }

    public void setRelLabel(final String relLabel) {
        this.relLabel = relLabel;
    }

    public String getRelSubtitle() {
        return relSubtitle;
    }

    public void setRelSubtitle(final String relSubtitle) {
        this.relSubtitle = relSubtitle;
    }

    public String getRelIcpn() {
        return relIcpn;
    }

    public void setRelIcpn(final String relIcpn) {
        this.relIcpn = relIcpn;
    }

    public String getRelReleaseType() {
        return relReleaseType;
    }

    public void setRelReleaseType(final String relReleaseType) {
        this.relReleaseType = relReleaseType;
    }

    public String getRelPline() {
        return relPline;
    }

    public void setRelPline(final String relPline) {
        this.relPline = relPline;
    }

    public List<String> getDisplayArtistNames() {
        return displayArtistNames;
    }

    public void setDisplayArtistNames(final List<String> displayArtistNames) {
        this.displayArtistNames = displayArtistNames;
    }

    public List<String> getContributorNames() {
        return contributorNames;
    }

    public void setContributorNames(final List<String> contributorNames) {
        this.contributorNames = contributorNames;
    }

    public List<IdentificationResult> getEnrichedISWCIdentificationResults() {
        return enrichedISWCIdentificationResults;
    }

    public void setEnrichedISWCIdentificationResults(
            final List<IdentificationResult> enrichedISWCIdentificationResults) {
        this.enrichedISWCIdentificationResults = enrichedISWCIdentificationResults;
    }

    public List<IdentificationResult> getEnrichedISRCIdentificationResults() {
        return enrichedISRCIdentificationResults;
    }

    public void setEnrichedISRCIdentificationResults(
            final List<IdentificationResult> enrichedISRCIdentificationResults) {
        this.enrichedISRCIdentificationResults = enrichedISRCIdentificationResults;
    }


    public List<String> getTransactionTitlesOriginal() {
        return transactionTitlesOriginal;
    }

    public void setTransactionTitlesOriginal(final List<String> transactionTitlesOriginal) {
        this.transactionTitlesOriginal = transactionTitlesOriginal;
    }

    public List<String> getEnrichedTitlesOriginal() {
        return enrichedTitlesOriginal;
    }

    public void setEnrichedTitlesOriginal(final List<String> enrichedTitlesOriginal) {
        this.enrichedTitlesOriginal = enrichedTitlesOriginal;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }

    public List<ResourceTxModel> getResourceTransactions() {
        return resourceTransactions;
    }

    public void setResourceTransactions(final List<ResourceTxModel> resourceTransactions) {
        this.resourceTransactions = resourceTransactions;
    }

    public long getRelDuration() {
        return relDuration;
    }

    public void setRelDuration(final long relDuration) {
        this.relDuration = relDuration;
    }

    public long getNrOfResources() {
        return nrOfResources;
    }

    public void setNrOfResources(final long nrOfResources) {
        this.nrOfResources = nrOfResources;
    }

    public double getMusicShare() {
        return musicShare;
    }

    public void setMusicShare(final double musicShare) {
        this.musicShare = musicShare;
    }

    public int getRelTxCount() {
        return relTxCount;
    }

    public void setRelTxCount(final int relTxCount) {
        this.relTxCount = relTxCount;
    }

    public int getRelUsages() {
        return relUsages;
    }

    public void setRelUsages(final int relUsages) {
        this.relUsages = relUsages;
    }

    public double getRelUsageShare() {
        return relUsageShare;
    }

    public void setRelUsageShare(final double relUsageShare) {
        this.relUsageShare = relUsageShare;
    }

    public double getUsageShare() {
        return usageShare;
    }

    public void setUsageShare(final double usageShare) {
        this.usageShare = usageShare;
    }

    public String getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(final String workGroupId) {
        this.workGroupId = workGroupId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        ResourceModel that = (ResourceModel) o;
        return getDownload() == that.getDownload() &&
                getRelDuration() == that.getRelDuration() &&
                getNrOfResources() == that.getNrOfResources() &&
                Double.compare(that.getMusicShare(), getMusicShare()) == 0 &&
                getRelTxCount() == that.getRelTxCount() &&
                getRelUsages() == that.getRelUsages() &&
                Double.compare(that.getRelUsageShare(), getRelUsageShare()) == 0 &&
                Double.compare(that.getUsageShare(), getUsageShare()) == 0 &&
                Objects.equals(getEnrichedISWC(), that.getEnrichedISWC()) &&
                Objects.equals(getEnrichedISRC(), that.getEnrichedISRC()) &&
                Objects.equals(getEnrichedTitles(), that.getEnrichedTitles()) &&
                Objects.equals(getIdentificationStatus(), that.getIdentificationStatus()) &&
                Objects.equals(getTransactionISWCIdentificationResults(),
                        that.getTransactionISWCIdentificationResults()) &&
                Objects.equals(getEnrichedISWCIdentificationResults(), that.getEnrichedISWCIdentificationResults()) &&
                Objects.equals(getTransactionISRCIdentificationResults(),
                        that.getTransactionISRCIdentificationResults()) &&
                Objects.equals(getEnrichedISRCIdentificationResults(), that.getEnrichedISRCIdentificationResults()) &&
                Objects.equals(getProprietaryIdentificationResults(), that.getProprietaryIdentificationResults()) &&
                Objects.equals(getProntoIdentificationResults(), that.getProntoIdentificationResults()) &&
                Objects.equals(getFinalIdentificationResult(), that.getFinalIdentificationResult()) &&
                Objects.equals(getTransactionISWC(), that.getTransactionISWC()) &&
                Objects.equals(getTransactionISRC(), that.getTransactionISRC()) &&
                Objects.equals(getTransactionTitles(), that.getTransactionTitles()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getRelProprietaryId(), that.getRelProprietaryId()) &&
                Objects.equals(getRelTitle(), that.getRelTitle()) &&
                Objects.equals(getRelDisplayArtist(), that.getRelDisplayArtist()) &&
                Objects.equals(getRelLabel(), that.getRelLabel()) &&
                Objects.equals(getRelSubtitle(), that.getRelSubtitle()) &&
                Objects.equals(getRelIcpn(), that.getRelIcpn()) &&
                Objects.equals(getRelReleaseType(), that.getRelReleaseType()) &&
                Objects.equals(getRelPline(), that.getRelPline()) &&
                Objects.equals(getFileName(), that.getFileName()) &&
                Objects.equals(getWorkGroupId(), that.getWorkGroupId()) &&
                Objects.equals(getDisplayArtistNames(), that.getDisplayArtistNames()) &&
                Objects.equals(getContributorNames(), that.getContributorNames()) &&
                Objects.equals(getTransactionTitlesOriginal(), that.getTransactionTitlesOriginal()) &&
                Objects.equals(getEnrichedTitlesOriginal(), that.getEnrichedTitlesOriginal()) &&
                Objects.equals(getResourceTransactions(), that.getResourceTransactions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlockId(), getFileName());
    }

//    @Override
//    public String toString() {
//        return MoreObjects.toStringHelper(this)
//                .add("enrichedISWC", enrichedISWC)
//                .add("enrichedISRC", enrichedISRC)
//                .add("enrichedTitles", enrichedTitles)
//                .add("download", download)
//                .add("identificationStatus", identificationStatus)
//                .add("transactionISWCIdentificationResults", transactionISWCIdentificationResults)
//                .add("enrichedISWCIdentificationResults", enrichedISWCIdentificationResults)
//                .add("transactionISRCIdentificationResults", transactionISRCIdentificationResults)
//                .add("enrichedISRCIdentificationResults", enrichedISRCIdentificationResults)
//                .add("proprietaryIdentificationResults", proprietaryIdentificationResults)
//                .add("prontoIdentificationResults", prontoIdentificationResults)
//                .add("finalIdentificationResult", finalIdentificationResult)
//                .add("transactionISWC", transactionISWC)
//                .add("transactionISRC", transactionISRC)
//                .add("transactionTitles", transactionTitles)
//                .add("id", id)
//                .add("relProprietaryId", relProprietaryId)
//                .add("relTitle", relTitle)
//                .add("relDisplayArtist", relDisplayArtist)
//                .add("relLabel", relLabel)
//                .add("relSubtitle", relSubtitle)
//                .add("relIcpn", relIcpn)
//                .add("relReleaseType", relReleaseType)
//                .add("relPline", relPline)
//                .add("fileName", fileName)
//                .add("displayArtistNames", displayArtistNames)
//                .add("contributorNames", contributorNames)
//                .add("transactionTitlesOriginal", transactionTitlesOriginal)
//                .add("enrichedTitlesOriginal", enrichedTitlesOriginal)
//                .add("resourceTransactions", resourceTransactions)
//                .add("relDuration", relDuration)
//                .add("nrOfResources", nrOfResources)
//                .add("musicShare", musicShare)
//                .add("relTxCount", relTxCount)
//                .add("relUsages", relUsages)
//                .add("relUsageShare", relUsageShare)
//                .add("usageShare", usageShare)
//                .add("workGroupId", workGroupId)
//                .toString();
//    }
}

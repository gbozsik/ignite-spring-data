package com.baeldung.ignite.spring.model.jolmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DatasetWrapper implements Serializable {

    @QuerySqlField(index = true)
    private Long id;
    @QuerySqlField
    private List<ResourceModel> resDs = new ArrayList<>();
    @QuerySqlField
    private List<RelJolModel> relDs = new ArrayList<>();
    @QuerySqlField
    private List<TxJolModel> txDs = new ArrayList<>();
    @QuerySqlField
    private List<ResIswcJolModel> resIswcTransactionDs = new ArrayList<>();
    @QuerySqlField
    private List<ResIswcJolModel> resIswcEnrichedDs = new ArrayList<>();
    @QuerySqlField
    private List<ResIsrcJolModel> resIsrcTransactionDs = new ArrayList<>();
    @QuerySqlField
    private List<ResIsrcJolModel> resIsrcEnrichedDs = new ArrayList<>();
    @QuerySqlField
    private List<ResTitleModel> resTitleTransactionalDs = new ArrayList<>();
    @QuerySqlField
    private List<ResTitleModel> resTitleEnrichedDs = new ArrayList<>();
    @QuerySqlField
    private List<ResProntoJolModel> resProntoDs = new ArrayList<>();
    @QuerySqlField
    private List<ResArtistJolModel> resArtistJolModelDs = new ArrayList<>();
    @QuerySqlField
    private List<ResContributorJolModel> resContributorJolModelDs = new ArrayList<>();

    public DatasetWrapper() {
    }
}

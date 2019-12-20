package com.baeldung.ignite.spring.model.jolmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

@Setter
@ToString
@NoArgsConstructor
public class DatasetWrapper2 implements Serializable {

    @Getter
    @QuerySqlField(index = true)
    private Long id;
    @QuerySqlField
    private ResourceModel resDs;
    @QuerySqlField
    private RelJolModel relDs;
    @QuerySqlField
    private TxJolModel txDs;
    @QuerySqlField
    private ResIswcJolModel resIswcTransactionDs;
    @QuerySqlField
    private ResIswcJolModel resIswcEnrichedDs;
    @QuerySqlField
    private ResIsrcJolModel resIsrcTransactionDs;
    @QuerySqlField
    private ResIsrcJolModel resIsrcEnrichedDs;
    @QuerySqlField
    private ResTitleModel resTitleTransactionalDs;
    @QuerySqlField
    private ResTitleModel resTitleEnrichedDs;
    @QuerySqlField
    private ResProntoJolModel resProntoDs;
    @QuerySqlField
    private ResArtistJolModel resArtistJolModelDs;
    @QuerySqlField
    private ResContributorJolModel resContributorJolModelDs;


}

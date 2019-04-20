package com.patent.demo.service;

import com.patent.demo.entity.FppInventionPatent;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wwj
 * @since 2018-07-22
 */
public interface FppInventionPatentService extends IService<FppInventionPatent> {

    //void register(String patentId, String patentName, String inventor, String userId, String userName );

    void reviewPatent(String userId, String userName, String patentId, String patentName);

    void changePatentState(String userId, String userName, String patentId, String patentName, int state);

    boolean selectByState(String patentId, String patentName, String userId, String userName);

    boolean selectByPatentState(String userId, String userName, String patentId, String patentName, int state);

    boolean transferPatent(String userId, String userName, String patentId, String patentName, String transferUserId, String transferUserName);

    List<Map<String, String>> isRenewalFeePatent(String userId, String userName);

    void reviewPayPatent(String userId, String userName, String patentId, String patentName, int state);

    void RecorrectPatent(String userId, String userName, String patentId, String patentName, int state);

    String selectUserByPatent(String param);

    List<FppInventionPatent> selectPatentByUser(String param);

    void register(String applicationNumber, String feeReductionApproval, String applyForApproval,
                  String registeredNumber, String inventionName, String inventor1, String inventor2,
                  String inventor3, int inventorAnnouncePublic, String inventor1Region, String inventor1IdNumber,
                  String applicant1Id, String applicant1Name, String applicant2Id, String applicant2Name, String applicant3Id,
                  String applicant3Name, String contactName, String contactTel, String contactEmail, String contactPostalCode,
                  String contactAddress, String repersentativeId, String repersentativeName, String agencyName, String agencyCode,
                  String agent1Name, String agent1LicenseNumber, String agent1Tel, String agent2Name, String agent2LicenseNumber,
                  String agent2Tel, String divisionApplicationNumber, String daOriginalNumber, String biomaterialsSamplePreservationUnitCode,
                  String bsAddress, int bsIsAlive, String bsDepositNumber, String bsClassificationNaming, int isSequenceListing, int isGeneticResources,
                  String requestPriorityClaimOriginalInstitutionName, String rpcPriorApplicationNumber, int withoutLoseNoveltyGracePeriodStatement,
                  int confidentiality, int isUilityInvention, int isAnnouncedAdvance, String listApplicationDocuments, String attachedFileList, String claim, String specification, String specificationAbstract, String annex);
}




package com.patent.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.patent.demo.entity.FppInventionPatent;
import com.patent.demo.mapper.FppInventionPatentMapper;
import com.patent.demo.service.FppInventionPatentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.patent.demo.util.HashUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wwj
 * @since 2018-07-22
 */
@Service
public class FppInventionPatentServiceImpl extends ServiceImpl<FppInventionPatentMapper, FppInventionPatent> implements FppInventionPatentService {

    @Autowired
    private FppInventionPatentMapper fppInventionPatentMapper;

    private static final Log log = LogFactory.getLog(FppInventionPatent.class);

    //专利状态：1申请中；2申请通过；3未缴年费；4已失效；5已过期。
    private int STATE_APPLICATING = 1;
    private int STATE_COM = 2;
    private int STATE_NOPAYMENT = 3;
    private int STATE_UNABLE = 4;
    private int STATE_EXPIRED = 5;
    private Date DEFAULT_TIME = new Date(1514736000L);

    @Override
    public void register(String applicationNumber, String feeReductionApproval, String applyForApproval,
                         String registeredNumber, String inventionName, String inventor1, String inventor2,
                         String inventor3, int inventorAnnouncePublic, String inventor1Region, String inventor1IdNumber,
                         String applicant1Id, String applicant1Name, String applicant2Id, String applicant2Name,
                         String applicant3Id, String applicant3Name, String contactName, String contactTel, String contactEmail,
                         String contactPostalCode, String contactAddress, String repersentativeId, String repersentativeName,
                         String agencyName, String agencyCode, String agent1Name, String agent1LicenseNumber, String agent1Tel,
                         String agent2Name, String agent2LicenseNumber, String agent2Tel, String divisionApplicationNumber, String daOriginalNumber,
                         String biomaterialsSamplePreservationUnitCode, String bsAddress, int bsIsAlive, String bsDepositNumber, String bsClassificationNaming,
                         int isSequenceListing, int isGeneticResources, String requestPriorityClaimOriginalInstitutionName, String rpcPriorApplicationNumber,
                         int withoutLoseNoveltyGracePeriodStatement, int confidentiality, int isUilityInvention, int isAnnouncedAdvance, String listApplicationDocuments,
                         String attachedFileList, String claim, String specification, String specificationAbstract, String annex) {

        //专利的uuid是hash(representative_id+representative_name+application_number+invention_name)
        Date currentTime = new Date();
        //applicant1等于 repersentative(默认）,以repersentative为准
        FppInventionPatent fppInventionPatent = new FppInventionPatent(applicationNumber, inventionName, inventor1, applicant1Id, applicant1Name);

        fppInventionPatent.setRepresentativeId(repersentativeId);
        fppInventionPatent.setRepresentativeName(repersentativeName);
        fppInventionPatent.setLastestPaymentTime(currentTime);
        fppInventionPatent.setState(STATE_APPLICATING);
        fppInventionPatent.setUuid(HashUtil.hashStr(applicant1Id + applicant1Name + applicationNumber + inventionName));
        fppInventionPatent.setApplicationTime(currentTime);

        fppInventionPatent.setFeeReductionApproval(feeReductionApproval);
        fppInventionPatent.setApplyForApproval(applyForApproval);
        fppInventionPatent.setBiomaterialsSamplePreservationUnitCode(biomaterialsSamplePreservationUnitCode);
        fppInventionPatent.setBsAddress(bsAddress);
        fppInventionPatent.setBsIsAlive(bsIsAlive);
        fppInventionPatent.setBsDepositNumber(bsDepositNumber);
        fppInventionPatent.setBsClassificationNaming(bsClassificationNaming);
        fppInventionPatent.setIsSequenceListing(isSequenceListing);
        fppInventionPatent.setIsGeneticResources(isGeneticResources);
        fppInventionPatent.setRequestPriorityClaimOriginalInstitutionName(requestPriorityClaimOriginalInstitutionName);
        fppInventionPatent.setRpcPriorApplicationNumber(rpcPriorApplicationNumber);
        fppInventionPatent.setConfidentiality(confidentiality);
        fppInventionPatent.setIsUtilityInvention(isUilityInvention);
        fppInventionPatent.setIsAnnouncedAdvance(isAnnouncedAdvance);
        fppInventionPatent.setRegisteredNumber(registeredNumber);
        fppInventionPatent.setInventor2(inventor2);
        fppInventionPatent.setInventor3(inventor3);
        fppInventionPatent.setInventorAnnouncePublic(inventorAnnouncePublic);
        fppInventionPatent.setApplicant2Id(applicant2Id);
        fppInventionPatent.setInventor1Region(inventor1Region);
        fppInventionPatent.setInventor1IdNumber(inventor1IdNumber);
        fppInventionPatent.setApplicant2Name(applicant2Name);
        fppInventionPatent.setApplicant3Id(applicant3Id);
        fppInventionPatent.setApplicant3Name(applicant3Name);
        fppInventionPatent.setContactName(contactName);
        fppInventionPatent.setContactTel(contactTel);
        fppInventionPatent.setContactEmail(contactEmail);
        fppInventionPatent.setContactPostalCode(contactPostalCode);
        fppInventionPatent.setContactAddress(contactAddress);
        fppInventionPatent.setAgencyName(agencyName);
        fppInventionPatent.setAgencyCode(agencyCode);
        fppInventionPatent.setAgent1Name(agent1Name);
        fppInventionPatent.setAgent1LicenseNumber(agent1LicenseNumber);
        fppInventionPatent.setAgent1Tel(agent1Tel);
        fppInventionPatent.setAgent2Name(agent2Name);
        fppInventionPatent.setAgent2LicenseNumber(agent2LicenseNumber);
        fppInventionPatent.setAgent2Tel(agent2Tel);
        fppInventionPatent.setDivisionApplicationNumber(divisionApplicationNumber);
        fppInventionPatent.setDaOriginalNumber(daOriginalNumber);
        fppInventionPatent.setWithoutLoseNoveltyGracePeriodStatement(withoutLoseNoveltyGracePeriodStatement);
        fppInventionPatent.setListApplicationDocuments(listApplicationDocuments);
        fppInventionPatent.setAttachedFileList(attachedFileList);
        fppInventionPatent.setClaim(claim);
        fppInventionPatent.setSpecification(specification);
        fppInventionPatent.setSpecificationAbstract(specificationAbstract);
        fppInventionPatent.setAnnex(annex);

        //空值设置为默认值
        fppInventionPatent.setDaOriginalTime(DEFAULT_TIME);
        fppInventionPatent.setRpcPriorApplicationTime(DEFAULT_TIME);
        fppInventionPatent.setBsDepositTime(DEFAULT_TIME);
        fppInventionPatent.setDivisionSubmissionDate(DEFAULT_TIME);
        this.insertOrUpdate(fppInventionPatent);

    }

    @Override
    public void reviewPatent(String userId, String userName, String patentId, String patentName) {
        changePatentState(userId, userName, patentId, patentName, STATE_COM);
    }

    @Override
    public void changePatentState(String userId, String userName, String patentId, String patentName, int state) {
        FppInventionPatent fppInventionPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppInventionPatent.setState(state);
        this.updateById(fppInventionPatent);
    }

    @Override
    public boolean selectByState(String patentId, String patentName, String userId, String userName) {
        return selectByPatentState(userId, userName, patentId, patentName, STATE_COM);
    }

    @Override
    public boolean selectByPatentState(String userId, String userName, String patentId, String patentName, int state) {
        FppInventionPatent fppInventionPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        return (fppInventionPatent.getState() == state);
    }

    @Override
    public boolean transferPatent(String userId, String userName, String patentId, String patentName, String transferUserId, String transferUserName) {
        FppInventionPatent fppInventionPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppInventionPatent.setRepresentativeId(transferUserId);
        fppInventionPatent.setRepresentativeName(transferUserName);
        this.deleteById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppInventionPatent.setUuid(HashUtil.hashStr(transferUserId + transferUserName + patentId + patentName));
        this.insert(fppInventionPatent);
        return true;
    }

    @Override
    public List<Map<String, String>> isRenewalFeePatent(String userId, String userName) {
        List<FppInventionPatent> maps = this.selectList(new EntityWrapper<FppInventionPatent>()
                .eq("representative_id", userId)
                .eq("representative_name", userName)
                .eq("state", STATE_COM));
        List<Map<String, String>> list = new ArrayList<>();
        if (maps != null) {
            Map<String, String> resultMap = new HashMap<>();
            for (FppInventionPatent map : maps) {
                //判断当前日期是否为缴费日期的一年后
                Date OneYearTime = new Date((map.getLastestPaymentTime().getTime() / 1000 + 60 * 60 * 365 * 24) * 1000);

                //判断当前日是否为申请日期后的20年，若是则专利过期。
                Date ExpirationDate = new Date((map.getApplicationTime().getTime() / 1000 + 20 * 60 * 60 * 365 * 24) * 1000);
                String isExpiration = (ExpirationDate.before(new Date())) ? "1" : null;
                if (OneYearTime.before(new Date())) {
                    resultMap.put("is_expiration", isExpiration);
                    resultMap.put("patent_id", map.getApplicationNumber());
                    resultMap.put("patent_name", map.getInventionName());

                    list.add(resultMap);
                }
            }
        }
        return list;
    }

    @Override
    public void reviewPayPatent(String userId, String userName, String patentId, String patentName, int state) {
        FppInventionPatent fppInventionPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppInventionPatent.setState(state);
        Date OneYearTime = new Date((fppInventionPatent.getLastestPaymentTime().getTime() / 1000 + 60 * 60 * 365 * 24) * 1000);
        fppInventionPatent.setLastestPaymentTime(OneYearTime);
        this.updateById(fppInventionPatent);
    }

    @Override
    public void RecorrectPatent(String userId, String userName, String patentId, String patentName, int state) {

    }

    @Override
    public String selectUserByPatent(String param) {
        FppInventionPatent fppInventionPatent = this.selectById(param);
        log.info(fppInventionPatent);
        return fppInventionPatent.getApplicant1Id();
    }

    @Override
    public List<FppInventionPatent> selectPatentByUser(String param) {
        List<FppInventionPatent> fppInventionPatents = this.selectList(new EntityWrapper<FppInventionPatent>().eq("user_id", param));
        List<FppInventionPatent> fppInventionPatents2 = this.selectList(new EntityWrapper<FppInventionPatent>().eq("user_name", param));

        log.info(fppInventionPatents);
        log.info(fppInventionPatents2);
        return (fppInventionPatents != null) ? fppInventionPatents : fppInventionPatents2;
    }
}

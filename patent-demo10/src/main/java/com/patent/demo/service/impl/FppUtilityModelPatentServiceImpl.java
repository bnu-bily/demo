package com.patent.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.patent.demo.entity.FppUtilityModelPatent;
import com.patent.demo.mapper.FppUtilityModelPatentMapper;
import com.patent.demo.service.FppUtilityModelPatentService;
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
public class FppUtilityModelPatentServiceImpl extends ServiceImpl<FppUtilityModelPatentMapper, FppUtilityModelPatent> implements FppUtilityModelPatentService {

    @Autowired
    private FppUtilityModelPatentMapper fppUtilityModelPatentMapper;

    private static final Log log = LogFactory.getLog(FppUtilityModelPatent.class);

    //专利状态：1申请中；2申请通过；3未缴年费；4已失效；5已过期。
    private int STATE_APPLICATING = 1;
    private int STATE_COM = 2;
    private int STATE_NOPAYMENT = 3;
    private int STATE_UNABLE = 4;
    private int STATE_EXPIRED = 5;
    private Date DEFAULT_TIME = new Date(1514736000L);

    @Override
    public void register(String applicationNumber, String feeReductionApproval, String applyForApproval,
                         String registeredNumber, String inventionName, String inventor, String inventorRegion,
                         String inventorIdNumber, String applicant1Id, String applicant1Name, String applicant2Id,
                         String applicant2Name, String applicant3Id, String applicant3Name, String contactName,
                         String contactTel, String contactEmail, String contactPostalCode, String contactAddress,
                         String repersentativeId, String repersentativeName, String agencyName, String agencyCode,
                         String agent1Name, String agent1LicenseNumber, String agent1Tel, String agent2Name, String agent2LicenseNumber,
                         String agent2Tel, String divisionApplicationNumber, String daOriginalNumber, String requestPriorityClaimOriginalInstitutionName,
                         String rpcPriorApplicationNumber, int withoutLoseNoveltyGracePeriodStatement, int confidentiality, int isUilityInvention,
                         String listApplicationDocuments, String attachedFileList, String claim, String specification, String specificationAbstract, String annex) {
        //专利的uuid是hash(representative_id+representative_name+application_number+invention_name)
        Date currentTime = new Date();
        FppUtilityModelPatent fppUtilityModelPatent = new FppUtilityModelPatent(applicationNumber, inventionName, inventor, applicant1Id, applicant1Name);

        fppUtilityModelPatent.setFeeReductionApproval(feeReductionApproval);
        fppUtilityModelPatent.setApplyForApproval(applyForApproval);

        fppUtilityModelPatent.setRequestPriorityClaimOriginalInstitutionName(requestPriorityClaimOriginalInstitutionName);
        fppUtilityModelPatent.setRpcPriorApplicationNumber(rpcPriorApplicationNumber);
        fppUtilityModelPatent.setConfidentiality(confidentiality);
        fppUtilityModelPatent.setIsUtilityInvention(isUilityInvention);
        fppUtilityModelPatent.setRegisteredNumber(registeredNumber);
        fppUtilityModelPatent.setApplicant2Id(applicant2Id);
        fppUtilityModelPatent.setInventorRegion(inventorRegion);
        fppUtilityModelPatent.setInventorIdNumber(inventorIdNumber);
        fppUtilityModelPatent.setApplicant2Name(applicant2Name);
        fppUtilityModelPatent.setApplicant3Id(applicant3Id);
        fppUtilityModelPatent.setApplicant3Name(applicant3Name);
        fppUtilityModelPatent.setContactName(contactName);
        fppUtilityModelPatent.setContactTel(contactTel);
        fppUtilityModelPatent.setContactEmail(contactEmail);
        fppUtilityModelPatent.setContactPostalCode(contactPostalCode);
        fppUtilityModelPatent.setContactAddress(contactAddress);
        fppUtilityModelPatent.setAgencyName(agencyName);
        fppUtilityModelPatent.setAgencyCode(agencyCode);
        fppUtilityModelPatent.setAgent1Name(agent1Name);
        fppUtilityModelPatent.setAgent1LicenseNumber(agent1LicenseNumber);
        fppUtilityModelPatent.setAgent1Tel(agent1Tel);
        fppUtilityModelPatent.setAgent2Name(agent2Name);
        fppUtilityModelPatent.setAgent2LicenseNumber(agent2LicenseNumber);
        fppUtilityModelPatent.setAgent2Tel(agent2Tel);
        fppUtilityModelPatent.setDivisionApplicationNumber(divisionApplicationNumber);
        fppUtilityModelPatent.setDaOriginalNumber(daOriginalNumber);
        fppUtilityModelPatent.setWithoutLoseNoveltyGracePeriodStatement(withoutLoseNoveltyGracePeriodStatement);
        fppUtilityModelPatent.setListApplicationDocuments(listApplicationDocuments);
        fppUtilityModelPatent.setAttachedFileList(attachedFileList);
        fppUtilityModelPatent.setClaim(claim);
        fppUtilityModelPatent.setSpecification(specification);
        fppUtilityModelPatent.setSpecificationAbstract(specificationAbstract);
        fppUtilityModelPatent.setAnnex(annex);

        fppUtilityModelPatent.setRepresentativeId(applicant1Id);
        fppUtilityModelPatent.setRepresentativeName(applicant1Name);
        fppUtilityModelPatent.setLastestPaymentTime(currentTime);
        fppUtilityModelPatent.setState(STATE_APPLICATING);
        fppUtilityModelPatent.setUuid(HashUtil.hashStr(applicant1Id + applicant1Name + applicationNumber + inventionName));
        fppUtilityModelPatent.setApplicationTime(currentTime);


        //空值设置为默认值
        fppUtilityModelPatent.setDaOriginalTime(DEFAULT_TIME);
        fppUtilityModelPatent.setRpcPriorApplicationTime(DEFAULT_TIME);
        fppUtilityModelPatent.setDivisionSubmissionDate(DEFAULT_TIME);
        this.insertOrUpdate(fppUtilityModelPatent);
    }


    @Override
    public void reviewPatent(String userId, String userName, String patentId, String patentName) {
        changePatentState(userId, userName, patentId, patentName, STATE_COM);
    }

    @Override
    public void changePatentState(String userId, String userName, String patentId, String patentName, int state) {
        FppUtilityModelPatent fppUtilityModelPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppUtilityModelPatent.setState(state);
        this.updateById(fppUtilityModelPatent);
    }

    @Override
    public boolean selectByState(String patentId, String patentName, String userId, String userName) {
        return selectByPatentState(userId, userName, patentId, patentName, STATE_COM);
    }

    @Override
    public boolean selectByPatentState(String userId, String userName, String patentId, String patentName, int state) {
        FppUtilityModelPatent fppUtilityModelPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        return (fppUtilityModelPatent.getState() == state);
    }

    @Override
    public boolean transferPatent(String userId, String userName, String patentId, String patentName, String transferUserId, String transferUserName) {
        FppUtilityModelPatent fppUtilityModelPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppUtilityModelPatent.setRepresentativeId(transferUserId);
        fppUtilityModelPatent.setRepresentativeName(transferUserName);
        this.deleteById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppUtilityModelPatent.setUuid(HashUtil.hashStr(transferUserId + transferUserName + patentId + patentName));
        this.insert(fppUtilityModelPatent);
        return true;
    }

    @Override
    public List<Map<String, String>> isRenewalFeePatent(String userId, String userName) {
        List<FppUtilityModelPatent> maps = this.selectList(new EntityWrapper<FppUtilityModelPatent>()
                .eq("representative_id", userId)
                .eq("representative_name", userName)
                .eq("state", STATE_COM));
        List<Map<String, String>> list = new ArrayList<>();
        if (maps != null) {
            Map<String, String> resultMap = new HashMap<>();
            for (FppUtilityModelPatent map : maps) {
                //判断当前日期是否为缴费日期的一年后
                Date OneYearTime = new Date((map.getLastestPaymentTime().getTime() / 1000 + 60 * 60 * 365 * 24) * 1000);

                //判断当前日是否为申请日期后的10年，若是则专利过期。
                Date ExpirationDate = new Date((map.getApplicationTime().getTime() / 1000 + 10 * 60 * 60 * 365 * 24) * 1000);
                String isExpiration = (ExpirationDate.before(new Date())) ? "1" : null;
                if (OneYearTime.before(new Date())) {
                    resultMap.put("is_expiration", isExpiration);
                    resultMap.put("patent_name", map.getInventionName());
                    resultMap.put("patent_id", map.getApplicationNumber());
                    list.add(resultMap);
                }
            }
        }
        return list;
    }

    @Override
    public void reviewPayPatent(String userId, String userName, String patentId, String patentName, int state) {
        FppUtilityModelPatent fppUtilityModelPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppUtilityModelPatent.setState(state);
        Date OneYearTime = new Date((fppUtilityModelPatent.getLastestPaymentTime().getTime() / 1000 + 60 * 60 * 365 * 24) * 1000);
        fppUtilityModelPatent.setLastestPaymentTime(OneYearTime);
        this.updateById(fppUtilityModelPatent);
    }

    @Override
    public void RecorrectPatent(String userId, String userName, String patentId, String patentName, int state) {

    }

    @Override
    public String selectUserByPatent(String param) {
        FppUtilityModelPatent fppUtilityModelPatent = this.selectById(param);
        log.info(fppUtilityModelPatent);
        return fppUtilityModelPatent.getApplicant1Id();
    }

    @Override
    public List<FppUtilityModelPatent> selectPatentByUser(String param) {
        List<FppUtilityModelPatent> fppUtilityModelPatents = this.selectList(new EntityWrapper<FppUtilityModelPatent>().eq("user_id", param));
        List<FppUtilityModelPatent> fppUtilityModelPatents2 = this.selectList(new EntityWrapper<FppUtilityModelPatent>().eq("user_name", param));

        log.info(fppUtilityModelPatents);
        log.info(fppUtilityModelPatents2);
        return (fppUtilityModelPatents != null) ? fppUtilityModelPatents : fppUtilityModelPatents2;
    }


}

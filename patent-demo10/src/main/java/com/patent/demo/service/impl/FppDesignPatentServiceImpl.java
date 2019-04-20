package com.patent.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.patent.demo.entity.FppDesignPatent;
import com.patent.demo.mapper.FppDesignPatentMapper;
import com.patent.demo.service.FppDesignPatentService;
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
public class FppDesignPatentServiceImpl extends ServiceImpl<FppDesignPatentMapper, FppDesignPatent> implements FppDesignPatentService {

    @Autowired
    private FppDesignPatentMapper fppDesignPatentMapper;

    private static final Log log = LogFactory.getLog(FppDesignPatent.class);

    //专利状态：1申请中；2申请通过；3未缴年费；4已失效；5已过期。
    private int STATE_APPLICATING = 1;
    private int STATE_COM = 2;
    private int STATE_NOPAYMENT = 3;
    private int STATE_UNABLE = 4;
    private int STATE_EXPIRED = 5;
    private Date DEFAULT_TIME = new Date(1514736000L);

    @Override
    public void register(String applicationNumber,
                         String feeReductionApproval, String applyForApproval,
                         String registeredNumber, String inventionName, String designer,
                         String designer1Region, String designer1IdNumber, String applicant1Id,
                         String applicant1Name, String applicant2Id, String applicant2Name, String applicant3Id,
                         String applicant3Name, String contactName, String contactTel, String contactEmail,
                         String contactPostalCode, String contactAddress, String repersentativeId, String repersentativeName,
                         String agencyName, String agencyCode, String agent1Name, String agent1LicenseNumber, String agent1Tel,
                         String agent2Name, String agent2LicenseNumber, String agent2Tel, String divisionApplicationNumber,
                         String daOriginalNumber, String requestForeignPriorityClaimOriginalInstitutionName, String rfpcPriorApplicationNumber,
                         int withoutLoseNoveltyGracePeriodStatement, int similarDesign, int completeProduct, String listApplicationDocuments,
                         String attachedFileList, String claim, String specification, String specificationAbstract, String annex) {


        //专利的uuid是hash(representative_id+representative_name+application_number+invention_name)
        Date currentTime = new Date();
        FppDesignPatent fppDesignPatent = new FppDesignPatent(applicationNumber, inventionName, designer, applicant1Id, applicant1Name);

        fppDesignPatent.setFeeReductionApproval(feeReductionApproval);
        fppDesignPatent.setApplyForApproval(applyForApproval);
        fppDesignPatent.setRegisteredNumber(registeredNumber);
        fppDesignPatent.setDesigner1Region(designer1Region);
        fppDesignPatent.setDesigner1IdNumber(designer1IdNumber);
        fppDesignPatent.setApplicant2Id(applicant2Id);
        fppDesignPatent.setApplicant2Name(applicant2Name);
        fppDesignPatent.setApplicant3Id(applicant3Id);
        fppDesignPatent.setApplicant3Name(applicant3Name);
        fppDesignPatent.setContactName(contactName);
        fppDesignPatent.setContactTel(contactTel);
        fppDesignPatent.setContactEmail(contactEmail);
        fppDesignPatent.setContactPostalCode(contactPostalCode);
        fppDesignPatent.setContactAddress(contactAddress);
        fppDesignPatent.setAgencyName(agencyName);
        fppDesignPatent.setAgencyCode(agencyCode);
        fppDesignPatent.setAgent1Name(agent1Name);
        fppDesignPatent.setAgent1LicenseNumber(agent1LicenseNumber);
        fppDesignPatent.setAgent1Tel(agent1Tel);
        fppDesignPatent.setAgent2Name(agent2Name);
        fppDesignPatent.setAgent2LicenseNumber(agent2LicenseNumber);
        fppDesignPatent.setAgent2Tel(agent2Tel);
        fppDesignPatent.setDivisionApplicationNumber(divisionApplicationNumber);
        fppDesignPatent.setDaOriginalNumber(daOriginalNumber);
        fppDesignPatent.setRequestForeignPriorityClaimOriginalInstitutionName(requestForeignPriorityClaimOriginalInstitutionName);
        fppDesignPatent.setRfpcPriorApplicationNumber(rfpcPriorApplicationNumber);
        fppDesignPatent.setWithoutLoseNoveltyGracePeriodStatement(withoutLoseNoveltyGracePeriodStatement);
        fppDesignPatent.setSimilarDesign(similarDesign);
        fppDesignPatent.setCompleteProduct(completeProduct);
        fppDesignPatent.setListApplicationDocuments(listApplicationDocuments);
        fppDesignPatent.setAttachedFileList(attachedFileList);
        fppDesignPatent.setClaim(claim);
        fppDesignPatent.setSpecification(specification);
        fppDesignPatent.setSpecificationAbstract(specificationAbstract);
        fppDesignPatent.setAnnex(annex);

        //重要项
        fppDesignPatent.setRepresentativeId(repersentativeId);
        fppDesignPatent.setRepresentativeName(repersentativeName);
        fppDesignPatent.setLastestPaymentTime(currentTime);
        fppDesignPatent.setState(STATE_APPLICATING);
        fppDesignPatent.setUuid(HashUtil.hashStr(applicant1Id + applicant1Name + applicationNumber + inventionName));
        fppDesignPatent.setApplicationTime(currentTime);

        //时间空值设置为默认值
        fppDesignPatent.setDaOriginalTime(DEFAULT_TIME);
        fppDesignPatent.setRfpcPriorApplicationTime(DEFAULT_TIME);
        fppDesignPatent.setDivisionSubmissionDate(DEFAULT_TIME);
        this.insertOrUpdate(fppDesignPatent);

    }


    @Override
    public void reviewPatent(String userId, String userName, String patentId, String patentName) {
        changePatentState(userId, userName, patentId, patentName, STATE_COM);
    }

    @Override
    public void changePatentState(String userId, String userName, String patentId, String patentName, int state) {
        FppDesignPatent fppDesignPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppDesignPatent.setState(state);
        this.updateById(fppDesignPatent);
    }

    @Override
    public boolean selectByState(String patentId, String patentName, String userId, String userName) {
        return selectByPatentState(userId, userName, patentId, patentName, STATE_COM);

    }

    @Override
    public boolean selectByPatentState(String userId, String userName, String patentId, String patentName, int state) {
        FppDesignPatent fppDesignPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        return (fppDesignPatent.getState() == state);
    }

    @Override
    public boolean transferPatent(String userId, String userName, String patentId, String patentName, String transferUserId, String transferUserName) {
        FppDesignPatent fppDesignPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppDesignPatent.setRepresentativeId(transferUserId);
        fppDesignPatent.setRepresentativeName(transferUserName);
        this.deleteById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppDesignPatent.setUuid(HashUtil.hashStr(transferUserId + transferUserName + patentId + patentName));
        this.insert(fppDesignPatent);
        return true;
    }

    @Override
    public List<Map<String, String>> isRenewalFeePatent(String userId, String userName) {
        List<FppDesignPatent> maps = this.selectList(new EntityWrapper<FppDesignPatent>()
                .eq("representative_id", userId)
                .eq("representative_name", userName)
                .eq("state", STATE_COM));
        List<Map<String, String>> list = new ArrayList<>();
        if (maps != null) {
            Map<String, String> resultMap = new HashMap<>();
            for (FppDesignPatent map : maps) {
                //判断当前日期是否为缴费日期的一年后
                Date OneYearTime = new Date((map.getLastestPaymentTime().getTime() / 1000 + 60 * 60 * 365 * 24) * 1000);

                //判断当前日是否为申请日期后的10年，若是则专利过期。
                Date ExpirationDate = new Date((map.getApplicationTime().getTime() / 1000 + 10 * 60 * 60 * 365 * 24) * 1000);
                String isExpiration = (ExpirationDate.before(new Date())) ? "1" : null;
                if (OneYearTime.before(new Date())) {
                    resultMap.put("patent_id", map.getApplicationNumber());
                    resultMap.put("patent_name", map.getInventionName());
                    resultMap.put("is_expiration", isExpiration);
                    list.add(resultMap);
                }
            }
        }
        return list;
    }

    @Override
    public void reviewPayPatent(String userId, String userName, String patentId, String patentName, int state) {
        FppDesignPatent fppDesignPatent = this.selectById(HashUtil.hashStr(userId + userName + patentId + patentName));
        fppDesignPatent.setState(state);
        Date OneYearTime = new Date((fppDesignPatent.getLastestPaymentTime().getTime() / 1000 + 60 * 60 * 365 * 24) * 1000);
        fppDesignPatent.setLastestPaymentTime(OneYearTime);
        this.updateById(fppDesignPatent);
    }

    @Override
    public void RecorrectPatent(String userId, String userName, String patentId, String patentName, int state) {

    }

    @Override
    public String selectUserByPatent(String param) {
        FppDesignPatent fppDesignPatent = this.selectById(param);
        log.info(fppDesignPatent);
        return fppDesignPatent.getApplicant1Id();
    }

    @Override
    public List<FppDesignPatent> selectPatentByUser(String param) {
        List<FppDesignPatent> fppDesignPatent = this.selectList(new EntityWrapper<FppDesignPatent>().eq("user_id", param));
        List<FppDesignPatent> fppDesignPatent2 = this.selectList(new EntityWrapper<FppDesignPatent>().eq("user_name", param));

        log.info(fppDesignPatent);
        log.info(fppDesignPatent2);
        return (fppDesignPatent != null) ? fppDesignPatent : fppDesignPatent2;
    }

}
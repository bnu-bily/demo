package com.patent.demo.controller;


import com.patent.demo.entity.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class APIController {

    private final RestTemplate restTemplate;

    @Value("${ip.host}")
    private String host;

    @Value("${ip.port}")
    private String port;

    @Value("${blockchain.host}")
    private String blockHost;

    @Value("${blockchain.port}")
    private String blockPort;

    //状态：1申请中；2通过；3拉黑
    private int APPROVAING_STATE = 1;
    private int APPROVAL_STATE = 2;
    private int BLOCK_STATE = 3;

    //1发明专利;2实用新型专利;3外观设计专利;
    private int PATENT_TYPE_INVENTOR = 1;
    private int PATENT_TYPE_UTILITY_MODEL = 2;
    private int PATENT_TYPE_DESIGN = 3;

    //专利状态：1申请中；2申请通过；3未缴年费；4已失效；5已过期。
    private int STATE_APPLICATING = 1;
    private int STATE_COM = 2;
    private int STATE_NOPAYMENT = 3;
    private int STATE_UNABLE = 4;
    private int STATE_EXPIRED = 5;

    //登录类型:1普通用户登入；2管理员登入；3普通用户登出；4管理员登出
    private int USER_LOGIN = 1;
    private int ADMIN_LOGIN = 2;
    private int USER_LOGOUT = 3;
    private int ADMIN_LOGOUT = 4;


    public APIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 用户注册 注入resident_id_number/organization_code/business_license_number 合为registrationRequesterCode
     */
    @RequestMapping("/userRegister")
    @ResponseBody
    public boolean userRegister(@RequestParam String userId, @RequestParam String userPassword, @RequestParam int registrationRequesterType,
                                @RequestParam String registrationRequesterCode, @RequestParam String patentAgencyCode, @RequestParam String rrName, @RequestParam String rrRegion,
                                @RequestParam String rrAddress, @RequestParam String rrTel, @RequestParam String rrEmail, @RequestParam String rrPostalCode, @RequestParam int rrReceiveInformation,
                                @RequestParam int digitalCertificateForm, @RequestParam String contactName, @RequestParam String contactAddress, @RequestParam String contactTel, @RequestParam String contactEmail,
                                @RequestParam String contactIdNumber, @RequestParam String listOfAccessories,@RequestParam int reputation, @RequestParam String annex) {
        return true;
    }

    /**
     * 用户修改密码
     */
    @RequestMapping("/changeUserPassword")
    @ResponseBody
    public Boolean changeUserPassword(@RequestParam String userId, @RequestParam String userName, @RequestParam String oldPassword, @RequestParam String newPassword) {
        return true;
    }

    /**
     * 用户注销
     */
    @RequestMapping("/cancelUser")
    @ResponseBody
    public Boolean cancelUser(@RequestParam String userId, @RequestParam String userName,@RequestParam String password) {
        return true;
    }

    /**
     * 管理员修改密码
     */
    @RequestMapping("/changeAdminPassword")
    @ResponseBody
    public Boolean changeAdminPassword(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String oldPassword, @RequestParam String newPassword) {
       return true;
    }

    /**
     * 用户登录
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public Boolean userLogin(@RequestParam String userId, @RequestParam String userPassword) {
       return true;
    }

    /**
     * 用户登出
     */
    @RequestMapping("/userLogout")
    @ResponseBody
    public Boolean userLogout(@RequestParam String userId, @RequestParam String userName) {
        return true;
    }

    /**
     * 用户申请专利
     */
    @RequestMapping("/userRegisterDesignPatent")
    @ResponseBody
    public boolean userRegisterPatent(@RequestParam int patentType, @RequestParam String payment, @RequestParam String applicationNumber, @RequestParam String feeReductionApproval,
                                      @RequestParam String applyForApproval, @RequestParam String registeredNumber, @RequestParam String inventionName,
                                      @RequestParam String designer, @RequestParam String designer1Region, @RequestParam String designer1IdNumber,
                                      @RequestParam String applicant1Id, @RequestParam String applicant1Name, @RequestParam String applicant2Id,
                                      @RequestParam String applicant2Name, @RequestParam String applicant3Id, @RequestParam String applicant3Name,
                                      @RequestParam String contactName, @RequestParam String contactTel, @RequestParam String contactEmail,
                                      @RequestParam String contactPostalCode, @RequestParam String contactAddress, @RequestParam String representativeId,
                                      @RequestParam String representativeName, @RequestParam String agencyName, @RequestParam String agencyCode,
                                      @RequestParam String agent1Name, @RequestParam String agent1LicenseNumber, @RequestParam String agent1Tel,
                                      @RequestParam String agent2Name, @RequestParam String agent2LicenseNumber, @RequestParam String agent2Tel,
                                      @RequestParam String divisionApplicationNumber, @RequestParam String daOriginalNumber,
                                      @RequestParam String requestForeignPriorityClaimOriginalInstitutionName, @RequestParam String rfpcPriorApplicationNumber,
                                      @RequestParam int withoutLoseNoveltyGracePeriodStatement, @RequestParam int similarDesign, @RequestParam int completeProduct,
                                      @RequestParam String listApplicationDocuments, @RequestParam String attachedFileList, @RequestParam String claim,
                                      @RequestParam String specification, @RequestParam String specificationAbstract, @RequestParam String annex) {

        return true;
    }

    @RequestMapping("/userRegisterInventionPatent")
    @ResponseBody
    public boolean userRegisterInventionPatent(@RequestParam int patentType, @RequestParam String payment, @RequestParam String applicationNumber, @RequestParam String feeReductionApproval,
                                               @RequestParam String applyForApproval, @RequestParam String registeredNumber, @RequestParam String inventionName, @RequestParam String inventor1,
                                               @RequestParam String inventor2, @RequestParam String inventor3, @RequestParam int inventorAnnouncePublic, @RequestParam String inventor1Region,
                                               @RequestParam String inventor1IdNumber, @RequestParam String applicant1Id, @RequestParam String applicant1Name, @RequestParam String applicant2Id,
                                               @RequestParam String applicant2Name, @RequestParam String applicant3Id, @RequestParam String applicant3Name, @RequestParam String contactName,
                                               @RequestParam String contactTel, @RequestParam String contactEmail, @RequestParam String contactPostalCode, @RequestParam String contactAddress,
                                               @RequestParam String representativeId, @RequestParam String representativeName, @RequestParam String agencyName, @RequestParam String agencyCode,
                                               @RequestParam String agent1Name, @RequestParam String agent1LicenseNumber, @RequestParam String agent1Tel, @RequestParam String agent2Name,
                                               @RequestParam String agent2LicenseNumber, @RequestParam String agent2Tel, @RequestParam String divisionApplicationNumber, @RequestParam String daOriginalNumber,
                                               @RequestParam String biomaterialsSamplePreservationUnitCode, @RequestParam String bsAddress, @RequestParam int bsIsAlive, @RequestParam String bsDepositNumber,
                                               @RequestParam String bsClassificationNaming, @RequestParam int isSequenceListing, @RequestParam int isGeneticResources,
                                               @RequestParam String requestPriorityClaimOriginalInstitutionName, @RequestParam String rpcPriorApplicationNumber, @RequestParam int withoutLoseNoveltyGracePeriodStatement,
                                               @RequestParam int confidentiality, @RequestParam int isUilityInvention, @RequestParam int isAnnouncedAdvance, @RequestParam String listApplicationDocuments,
                                               @RequestParam String attachedFileList, @RequestParam String claim, @RequestParam String specification, @RequestParam String specificationAbstract, @RequestParam String annex) {

        return true;
    }

    @RequestMapping("/userRegisterUtilityModelPatent")
    @ResponseBody
    public boolean userRegisterUtilityModelPatent(@RequestParam int patentType, @RequestParam String payment, @RequestParam String applicationNumber, @RequestParam String feeReductionApproval,
                                                  @RequestParam String applyForApproval, @RequestParam String registeredNumber, @RequestParam String inventionName, @RequestParam String inventor, @RequestParam String inventorRegion,
                                                  @RequestParam String inventorIdNumber, @RequestParam String applicant1Id, @RequestParam String applicant1Name, @RequestParam String applicant2Id,
                                                  @RequestParam String applicant2Name, @RequestParam String applicant3Id, @RequestParam String applicant3Name, @RequestParam String contactName,
                                                  @RequestParam String contactTel, @RequestParam String contactEmail, @RequestParam String contactPostalCode, @RequestParam String contactAddress,
                                                  @RequestParam String representativeId, @RequestParam String representativeName, @RequestParam String agencyName, @RequestParam String agencyCode,
                                                  @RequestParam String agent1Name, @RequestParam String agent1LicenseNumber, @RequestParam String agent1Tel, @RequestParam String agent2Name,
                                                  @RequestParam String agent2LicenseNumber, @RequestParam String agent2Tel, @RequestParam String divisionApplicationNumber, @RequestParam String daOriginalNumber,
                                                  @RequestParam String requestPriorityClaimOriginalInstitutionName, @RequestParam String rpcPriorApplicationNumber, @RequestParam int withoutLoseNoveltyGracePeriodStatement,
                                                  @RequestParam int confidentiality, @RequestParam int isUilityInvention, @RequestParam String listApplicationDocuments,
                                                  @RequestParam String attachedFileList, @RequestParam String claim, @RequestParam String specification, @RequestParam String specificationAbstract, @RequestParam String annex) {

        return true;
    }

    /**
     * 用户补正专利
     */
    @RequestMapping("/userRecorrectPatent")
    @ResponseBody
    public boolean userRecorrectPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        return true;
    }

    /**
     * 用户提出实质审查请求（只有发明专利才有）
     */
    @RequestMapping("/userRequestSubstantiveReview")
    @ResponseBody
    public boolean userRequestSubstantiveReview(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        return true;
    }

    /**
     * 用户转让专利
     */
    @RequestMapping("/userTransferPatent")
    @ResponseBody
    public boolean userTransferPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String transferUserId, @RequestParam String transferUserName, @RequestParam String annex) {
       return true;
    }

    /**
     * 用户续费专利
     */
    @RequestMapping("/userRenewalFeePatent")
    @ResponseBody
    public boolean userRenewalFeePatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String payment) {
        return true;
    }

    /**
     * 用户撤销专利
     */
    @RequestMapping("/userCancelPatent")
    @ResponseBody
    public boolean userCancelPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        return true;
    }

    /**
     * 用户恢复专利
     */
    @RequestMapping("userRestorePatent")
    @ResponseBody
    public boolean userRestorePatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        return true;
    }


    /**
     * 用户或者管理员查询用户（用户ID，用户姓名）；用户查询专利（用户ID,用户姓名，专利ID,专利名字），申请中专利/撤销中专利/转让中专利/补正中专利
     */
    //查询用户
    @RequestMapping("/selectUserByParam")
    @ResponseBody
    public FppUser selectUserByParam(@RequestParam String param) {
        return new FppUser(param);
    }

    //查询专利
    @RequestMapping("/selectPatentOne")
    @ResponseBody
    public FppDesignPatent selectPatentOne(@RequestParam String param) {
        return new FppDesignPatent(param);
    }

    //查询专利列表
    @RequestMapping("/selectPatentByParam")
    @ResponseBody
    public List<List> selectPatentByParam(@RequestParam String param) {

        List<List> list = new LinkedList<>();

        String url = "http://" + host + ":" + port + "/fppInventionPatent/selectPatentByUser?param={param}";
        List<FppInventionPatent> fppInventionPatent = restTemplate.getForObject(url, List.class, param);

        url = "http://" + host + ":" + port + "/fppUtilityModelPatent/selectPatentByUser?param={param}";
        List<FppUtilityModelPatent> fppUtilityModelPatent = restTemplate.getForObject(url, List.class, param);

        url = "http://" + host + ":" + port + "/fppDesignPatent/selectPatentByUser?param={param}";
        List<FppDesignPatent> fppDesignPatent = restTemplate.getForObject(url, List.class, param);

        list.add(fppInventionPatent);
        list.add(fppUtilityModelPatent);
        list.add(fppDesignPatent);

        return list;
    }

    /**
     * 管理员注册
     */
    @RequestMapping("/adminRegister")
    @ResponseBody
    public boolean adminRegister(@RequestParam String adminId, @RequestParam String adminType, @RequestParam String adminPassword,
                                 @RequestParam String registrationCode, @RequestParam String adminName, @RequestParam String adminRegion,
                                 @RequestParam String adminIdNumber, @RequestParam String adminAddress, @RequestParam String adminTel, @RequestParam String adminEmail, @RequestParam String adminPostalCode) {
        return true;
    }

    /**
     * 管理员登录
     */
    @RequestMapping("/adminLogin")
    @ResponseBody
    public Boolean adminLogin(@RequestParam String userId, @RequestParam String userPassword) {
        return true;
    }

    /**
     * 管理员登出
     */
    @RequestMapping("/adminLogout")
    @ResponseBody
    public Boolean adminLogout(@RequestParam String userId, @RequestParam String userName) {
        return true;
    }

    /**
     * 管理员审核用户申请
     */
    @RequestMapping("/adminApprovalRegisterUser")
    @ResponseBody
    public Boolean adminApprovalRegisterUser(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam String userPassword,
                                             @RequestParam int state) {
        return true;
    }

    /**
     * 管理员拉黑用户
     */
    @RequestMapping("/adminBlockUser")
    @ResponseBody
    public boolean adminBlackUser(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName) {
return true;
    }

    /**
     * 管理员撤销拉黑的用户
     */
    @RequestMapping("/adminUnBlackUser")
    @ResponseBody
    public boolean adminUnBlockUser(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName) {
        return true;
    }

    /**
     * 管理员初步审查专利
     */
    @RequestMapping("/adminReviewPatent")
    @ResponseBody
    public boolean adminReviewPatent(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType,
                                     @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        return true;
    }

    /**
     * 管理员审核补正专利
     */
    @RequestMapping("/adminReviewRecorrectPatent")
    @ResponseBody
    public boolean adminReviewCorrectionPatent(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType,
                                               @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        return true;
    }

    /**
     * 管理员实质审查专利
     */
    @RequestMapping("/adminSubstantiveReviewPatent")
    @ResponseBody
    public boolean adminSubstantiveReviewPatent(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType,
                                                @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        return true;
    }

    /**
     * 管理员审核转让专利
     */
    @RequestMapping("/adminReviewTransferPatent")
    @ResponseBody
    public Boolean adminReviewTransferPatent(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam String
                                                     transferUserId, @RequestParam String transferUserName, @RequestParam int patentType,
                                             @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        return true;
    }

    /**
     * 管理员审核续费专利
     */
    @RequestMapping("/adminReviewPayPatent")
    @ResponseBody
    public boolean adminReviewPayPatent(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam String
                                                patentId, @RequestParam String patentName, @RequestParam int patentType, @RequestParam int state) {
        return true;
    }

    /**
     * 管理员审核撤销专利
     */
    @RequestMapping("/adminReviewCancelPatent")
    @ResponseBody
    public Boolean adminReviewCancelPatent(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType,
                                           @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        return true;

    }

    /**
     * 管理员审核恢复专利
     */
    @RequestMapping("/adminReviewRestorePatent")
    @ResponseBody
    public Boolean adminReviewRestorePatent(@RequestParam String adminId, @RequestParam String
            adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType,
                                            @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        return true;
    }

    /**
     * 管理员添加过滤关键词
     */
    @RequestMapping("/addKeyWord")
    @ResponseBody
    public Boolean addKeyWord(@RequestParam String keyWord) {
        return true;
    }

    /**
     * 判断是否专业名称中存在关键词
     */
    @RequestMapping("/containKeyWord")
    @ResponseBody
    public Boolean containKeyWord(@RequestParam String patentName) {
        return true;
    }

    /**
     * 管理员开启或关闭过滤关键词
     */
    @RequestMapping("/isEffectKeyword")
    @ResponseBody
    public Boolean isEffectKeyword(@RequestParam String keyWord, @RequestParam int state) {
        return true;
    }

    /**
     * @param patentType
     * @return
     */
    private String patentTypeProcess(int patentType) {
        if (patentType == 1) return "fppInventionPatent";
        else if (patentType == 2) return "fppUtilityModelPatent";
        else return "fppDesignPatent";
    }

}


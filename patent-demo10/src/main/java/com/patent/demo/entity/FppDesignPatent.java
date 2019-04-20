package com.patent.demo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
public class FppDesignPatent extends Model<FppDesignPatent> {


    private static final long serialVersionUID = 1L;

    /**
     * hashStr(applicant1Id + applicant1Name + applicationNumber + inventionName)
     */
    @TableId
    private String uuid;
    /**
     * 申请号
     */
    @TableField
    private String applicationNumber;
    /**
     * 分案提交日
     */
    @TableField
    private Date divisionSubmissionDate;
    @TableField
    private Date applicationTime;
    /**
     * 费减审批
     */
    @TableField
    private String feeReductionApproval;
    /**
     * 向外申请审批
     */
    @TableField
    private String applyForApproval;
    /**
     * 挂号号码
     */
    @TableField
    private String registeredNumber;
    /**
     * 发明名称
     */
    @TableField
    private String inventionName;
    /**
     * 第一设计人
     */
    @TableField
    private String designer;
    /**
     * 第一设计人国籍（地区）
     */
    @TableField
    private String designer1Region;
    /**
     * 第一设计人身份证号码
     */
    @TableField
    private String designer1IdNumber;
    /**
     * 申请人1账号（user_id）
     */
    @TableField
    private String applicant1Id;
    /**
     * 申请人1姓名（rr_name）
     */
    @TableField
    private String applicant1Name;
    @TableField
    private String applicant2Id;
    @TableField
    private String applicant2Name;
    @TableField
    private String applicant3Id;
    @TableField
    private String applicant3Name;
    /**
     * 联系人姓名
     */
    @TableField
    private String contactName;
    @TableField
    private String contactTel;
    @TableField
    private String contactEmail;
    @TableField
    private String contactPostalCode;
    @TableField
    private String contactAddress;
    /**
     * 专利代表人，默认为申请人之一的1
     */
    @TableField
    private String representativeId;
    /**
     * 代表人姓名
     */
    @TableField
    private String representativeName;
    /**
     * 代理机构名称
     */
    @TableField
    private String agencyName;
    /**
     * 机构代码
     */
    @TableField
    private String agencyCode;
    /**
     * 代理人1姓名
     */
    @TableField
    private String agent1Name;
    /**
     * 代理人1执业证号
     */
    @TableField
    private String agent1LicenseNumber;
    @TableField
    private String agent1Tel;
    @TableField
    private String agent2Name;
    @TableField
    private String agent2LicenseNumber;
    @TableField
    private String agent2Tel;
    /**
     * 分案申请申请号
     */
    @TableField
    private String divisionApplicationNumber;
    /**
     * 分案申请原申请号
     */
    @TableField
    private String daOriginalNumber;
    /**
     * 分案申请原申请日
     */
    @TableField
    private Date daOriginalTime;
    /**
     * 要求外国优先权声明的原受理机构名称
     */
    @TableField
    private String requestForeignPriorityClaimOriginalInstitutionName;
    /**
     * 要求优先权声明的在先申请日
     */
    @TableField
    private Date rfpcPriorApplicationTime;
    /**
     * 要求优先权声明的在先申请号
     */
    @TableField
    private String rfpcPriorApplicationNumber;
    /**
     * 不丧失新颖性宽限期声明：已在中国政府主办或承认的国际展览会上首次展出；已在规定的学术会议或技术会议上首次发表；他人未经申请人同意而泄露其内容。是为1；否为0

     */
    @TableField
    private Integer withoutLoseNoveltyGracePeriodStatement;
    /**
     * 本案为同一产品的相似外观设计，其所包含的项数为几项。
     */
    @TableField
    private Integer similarDesign;
    /**
     * 本案为成套产品的多项外观设计，其所包含的项数为几项
     */
    @TableField
    private Integer completeProduct;
    /**
     * 申请文件清单:请求书；图片或照片；简要说明。是为1，否为0

     */
    @TableField
    private String listApplicationDocuments;
    /**
     * 附加文件清单：优先权转让证明；专利代理委托书；总委托书；在先申请文件副本；在先申请文件副本首页译文；其他证明文件。是为1，否为0
     */
    @TableField
    private String attachedFileList;
    /**
     * 专利状态：1申请中；2已通过；3未缴年费；4已失效；5已过期。
     */
    @TableField
    private Integer state;
    /**
     * 权利要求书(存储为地址）
     */
    @TableField
    private String claim;
    /**
     * 说明书(存储为地址）
     */
    @TableField
    private String specification;
    /**
     * 说明书摘要
     */
    @TableField
    private String specificationAbstract;
    /**
     * 最新缴费时间
     */
    @TableField
    private Date lastestPaymentTime;
    /**
     * 附件（存储为地址）
     */
    @TableField
    private String annex;

    public FppDesignPatent() {
    }

    public FppDesignPatent(String patentId, String patentName, String inventor, String userId, String userName) {
        this.applicationNumber = patentId;
        this.inventionName = patentName;
        this.designer = inventor;
        this.applicant1Id = userId;
        this.applicant1Name = userName;

    }
    public FppDesignPatent( String param) {
        this.applicationNumber="tests1est";
        this.feeReductionApproval="tests1est";

        this.applyForApproval="tests1est";
        this.registeredNumber="tests1est";
        this.inventionName="tests1est";

        this.designer="tests1est";
        this.designer1Region="tests1est";
        this.designer1IdNumber="tests1est";

        this.applicant1Id="tests1est";
        this.applicant1Name="tests1est";
        this.applicant2Id="tests1est";

        this.applicant2Name="tests1est";
        this.applicant3Id="tests1est";
        this.applicant3Name="tests1est";

        this.contactName="tests1est";
        this.contactTel="tests1est";
        this.contactEmail="tests1est";

        this.contactPostalCode="tests1est";
        this.contactAddress="tests1est";
        this.representativeId="tests1est";

        this.representativeName="tests1est";
        this.agencyName="tests1est";
        this.agencyCode="tests1est";

        this.agent1Name="tests1est";
        this.agent1LicenseNumber="tests1est";
        this.agent1Tel="tests1est";

        this.agent2Name="tests1est";
        this.agent2LicenseNumber="tests1est";
        this.agent2Tel="tests1est";

        this.divisionApplicationNumber="tests1est";
        this.daOriginalNumber="tests1est";

        this.requestForeignPriorityClaimOriginalInstitutionName="tests1est";
        this.rfpcPriorApplicationNumber="tests1est";

        this.withoutLoseNoveltyGracePeriodStatement=1;
        this.similarDesign=1;
        this.completeProduct=1;

        this.listApplicationDocuments="tests1est";
        this.attachedFileList="tests1est";
        this.claim="tests1est";

        this.specification="tests1est";
        this.specificationAbstract="tests1est";
        this.annex="test";
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Date getDivisionSubmissionDate() {
        return divisionSubmissionDate;
    }

    public void setDivisionSubmissionDate(Date divisionSubmissionDate) {
        this.divisionSubmissionDate = divisionSubmissionDate;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getFeeReductionApproval() {
        return feeReductionApproval;
    }

    public void setFeeReductionApproval(String feeReductionApproval) {
        this.feeReductionApproval = feeReductionApproval;
    }

    public String getApplyForApproval() {
        return applyForApproval;
    }

    public void setApplyForApproval(String applyForApproval) {
        this.applyForApproval = applyForApproval;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    public String getInventionName() {
        return inventionName;
    }

    public void setInventionName(String inventionName) {
        this.inventionName = inventionName;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDesigner1Region() {
        return designer1Region;
    }

    public void setDesigner1Region(String designer1Region) {
        this.designer1Region = designer1Region;
    }

    public String getDesigner1IdNumber() {
        return designer1IdNumber;
    }

    public void setDesigner1IdNumber(String designer1IdNumber) {
        this.designer1IdNumber = designer1IdNumber;
    }

    public String getApplicant1Id() {
        return applicant1Id;
    }

    public void setApplicant1Id(String applicant1Id) {
        this.applicant1Id = applicant1Id;
    }

    public String getApplicant1Name() {
        return applicant1Name;
    }

    public void setApplicant1Name(String applicant1Name) {
        this.applicant1Name = applicant1Name;
    }

    public String getApplicant2Id() {
        return applicant2Id;
    }

    public void setApplicant2Id(String applicant2Id) {
        this.applicant2Id = applicant2Id;
    }

    public String getApplicant2Name() {
        return applicant2Name;
    }

    public void setApplicant2Name(String applicant2Name) {
        this.applicant2Name = applicant2Name;
    }

    public String getApplicant3Id() {
        return applicant3Id;
    }

    public void setApplicant3Id(String applicant3Id) {
        this.applicant3Id = applicant3Id;
    }

    public String getApplicant3Name() {
        return applicant3Name;
    }

    public void setApplicant3Name(String applicant3Name) {
        this.applicant3Name = applicant3Name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPostalCode() {
        return contactPostalCode;
    }

    public void setContactPostalCode(String contactPostalCode) {
        this.contactPostalCode = contactPostalCode;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(String representativeId) {
        this.representativeId = representativeId;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getAgent1Name() {
        return agent1Name;
    }

    public void setAgent1Name(String agent1Name) {
        this.agent1Name = agent1Name;
    }

    public String getAgent1LicenseNumber() {
        return agent1LicenseNumber;
    }

    public void setAgent1LicenseNumber(String agent1LicenseNumber) {
        this.agent1LicenseNumber = agent1LicenseNumber;
    }

    public String getAgent1Tel() {
        return agent1Tel;
    }

    public void setAgent1Tel(String agent1Tel) {
        this.agent1Tel = agent1Tel;
    }

    public String getAgent2Name() {
        return agent2Name;
    }

    public void setAgent2Name(String agent2Name) {
        this.agent2Name = agent2Name;
    }

    public String getAgent2LicenseNumber() {
        return agent2LicenseNumber;
    }

    public void setAgent2LicenseNumber(String agent2LicenseNumber) {
        this.agent2LicenseNumber = agent2LicenseNumber;
    }

    public String getAgent2Tel() {
        return agent2Tel;
    }

    public void setAgent2Tel(String agent2Tel) {
        this.agent2Tel = agent2Tel;
    }

    public String getDivisionApplicationNumber() {
        return divisionApplicationNumber;
    }

    public void setDivisionApplicationNumber(String divisionApplicationNumber) {
        this.divisionApplicationNumber = divisionApplicationNumber;
    }

    public String getDaOriginalNumber() {
        return daOriginalNumber;
    }

    public void setDaOriginalNumber(String daOriginalNumber) {
        this.daOriginalNumber = daOriginalNumber;
    }

    public Date getDaOriginalTime() {
        return daOriginalTime;
    }

    public void setDaOriginalTime(Date daOriginalTime) {
        this.daOriginalTime = daOriginalTime;
    }

    public String getRequestForeignPriorityClaimOriginalInstitutionName() {
        return requestForeignPriorityClaimOriginalInstitutionName;
    }

    public void setRequestForeignPriorityClaimOriginalInstitutionName(String requestForeignPriorityClaimOriginalInstitutionName) {
        this.requestForeignPriorityClaimOriginalInstitutionName = requestForeignPriorityClaimOriginalInstitutionName;
    }

    public Date getRfpcPriorApplicationTime() {
        return rfpcPriorApplicationTime;
    }

    public void setRfpcPriorApplicationTime(Date rfpcPriorApplicationTime) {
        this.rfpcPriorApplicationTime = rfpcPriorApplicationTime;
    }

    public String getRfpcPriorApplicationNumber() {
        return rfpcPriorApplicationNumber;
    }

    public void setRfpcPriorApplicationNumber(String rfpcPriorApplicationNumber) {
        this.rfpcPriorApplicationNumber = rfpcPriorApplicationNumber;
    }

    public Integer getWithoutLoseNoveltyGracePeriodStatement() {
        return withoutLoseNoveltyGracePeriodStatement;
    }

    public void setWithoutLoseNoveltyGracePeriodStatement(Integer withoutLoseNoveltyGracePeriodStatement) {
        this.withoutLoseNoveltyGracePeriodStatement = withoutLoseNoveltyGracePeriodStatement;
    }

    public Integer getSimilarDesign() {
        return similarDesign;
    }

    public void setSimilarDesign(Integer similarDesign) {
        this.similarDesign = similarDesign;
    }

    public Integer getCompleteProduct() {
        return completeProduct;
    }

    public void setCompleteProduct(Integer completeProduct) {
        this.completeProduct = completeProduct;
    }

    public String getListApplicationDocuments() {
        return listApplicationDocuments;
    }

    public void setListApplicationDocuments(String listApplicationDocuments) {
        this.listApplicationDocuments = listApplicationDocuments;
    }

    public String getAttachedFileList() {
        return attachedFileList;
    }

    public void setAttachedFileList(String attachedFileList) {
        this.attachedFileList = attachedFileList;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSpecificationAbstract() {
        return specificationAbstract;
    }

    public void setSpecificationAbstract(String specificationAbstract) {
        this.specificationAbstract = specificationAbstract;
    }

    public Date getLastestPaymentTime() {
        return lastestPaymentTime;
    }

    public void setLastestPaymentTime(Date lastestPaymentTime) {
        this.lastestPaymentTime = lastestPaymentTime;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "FppDesignPatent{" +
                "uuid=" + uuid +
                ", applicationNumber=" + applicationNumber +
                ", divisionSubmissionDate=" + divisionSubmissionDate +
                ", applicationTime=" + applicationTime +
                ", feeReductionApproval=" + feeReductionApproval +
                ", applyForApproval=" + applyForApproval +
                ", registeredNumber=" + registeredNumber +
                ", inventionName=" + inventionName +
                ", designer=" + designer +
                ", designer1Region=" + designer1Region +
                ", designer1IdNumber=" + designer1IdNumber +
                ", applicant1Id=" + applicant1Id +
                ", applicant1Name=" + applicant1Name +
                ", applicant2Id=" + applicant2Id +
                ", applicant2Name=" + applicant2Name +
                ", applicant3Id=" + applicant3Id +
                ", applicant3Name=" + applicant3Name +
                ", contactName=" + contactName +
                ", contactTel=" + contactTel +
                ", contactEmail=" + contactEmail +
                ", contactPostalCode=" + contactPostalCode +
                ", contactAddress=" + contactAddress +
                ", representativeId=" + representativeId +
                ", representativeName=" + representativeName +
                ", agencyName=" + agencyName +
                ", agencyCode=" + agencyCode +
                ", agent1Name=" + agent1Name +
                ", agent1LicenseNumber=" + agent1LicenseNumber +
                ", agent1Tel=" + agent1Tel +
                ", agent2Name=" + agent2Name +
                ", agent2LicenseNumber=" + agent2LicenseNumber +
                ", agent2Tel=" + agent2Tel +
                ", divisionApplicationNumber=" + divisionApplicationNumber +
                ", daOriginalNumber=" + daOriginalNumber +
                ", daOriginalTime=" + daOriginalTime +
                ", requestForeignPriorityClaimOriginalInstitutionName=" + requestForeignPriorityClaimOriginalInstitutionName +
                ", rfpcPriorApplicationTime=" + rfpcPriorApplicationTime +
                ", rfpcPriorApplicationNumber=" + rfpcPriorApplicationNumber +
                ", withoutLoseNoveltyGracePeriodStatement=" + withoutLoseNoveltyGracePeriodStatement +
                ", similarDesign=" + similarDesign +
                ", completeProduct=" + completeProduct +
                ", listApplicationDocuments=" + listApplicationDocuments +
                ", attachedFileList=" + attachedFileList +
                ", state=" + state +
                ", claim=" + claim +
                ", specification=" + specification +
                ", specificationAbstract=" + specificationAbstract +
                ", lastestPaymentTime=" + lastestPaymentTime +
                ", annex=" + annex +
                "}";
    }
}

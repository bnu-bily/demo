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
public class FppInventionPatent extends Model<FppInventionPatent> {


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
    /**
     * 申请日期
     */
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
     * 第一发明人
     */
    @TableField
    private String inventor1;
    /**
     * 第二发明人
     */
    @TableField
    private String inventor2;
    /**
     * 第三发明人
     */
    @TableField
    private String inventor3;
    /**
     * 三个发明人是否公开姓名；公开为1，不公开为0。e.g:都公开为111
     */
    @TableField
    private Integer inventorAnnouncePublic;
    /**
     * 第一发明人国籍（地区）
     */
    @TableField
    private String inventor1Region;
    /**
     * 第一发明人身份证号码
     */
    @TableField
    private String inventor1IdNumber;
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
     * 专利代表人，默认为申请人之一
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
     * 生物材料样品保藏单位代码
     */
    @TableField
    private String biomaterialsSamplePreservationUnitCode;
    @TableField
    private String bsAddress;
    /**
     * 是否存活：1是；0否
     */
    @TableField
    private Integer bsIsAlive;
    /**
     * 保藏日期
     */
    @TableField
    private Date bsDepositTime;
    /**
     * 保藏编号
     */
    @TableField
    private String bsDepositNumber;
    /**
     * 分类命名
     */
    @TableField
    private String bsClassificationNaming;
    /**
     * 本专利申请是否涉及核苷酸或氨基酸序列表:1是；0否
     */
    @TableField
    private Integer isSequenceListing;
    /**
     * 本专利申请是否涉及的发明创造是依赖于遗传资源完成的:1是；0否
     */
    @TableField
    private Integer isGeneticResources;
    /**
     * 要求优先权声明的原受理机构名称
     */
    @TableField
    private String requestPriorityClaimOriginalInstitutionName;
    /**
     * 要求优先权声明的在先申请日
     */
    @TableField
    private Date rpcPriorApplicationTime;
    /**
     * 要求优先权声明的在先申请号
     */
    @TableField
    private String rpcPriorApplicationNumber;
    /**
     * 不丧失新颖性宽限期声明：已在中国政府主办或承认的国际展览会上首次展出；已在规定的学术会议或技术会议上首次发表；他人未经申请人同意而泄露其内容。是为1；否为0。e.g:选项都为是则为111

     */
    @TableField
    private Integer withoutLoseNoveltyGracePeriodStatement;
    /**
     * 保密请求：本专利申请可能涉及国家重大利益，请求按保密申请处理；已提交保密证明材料。是为1，否为0。e.g:选项都是则为11
     */
    @TableField
    private Integer confidentiality;
    /**
     * 声明本申请人对同样的发明创造是否在申请本发明专利的同日申请了实用新型专利 :1是；0否
     */
    @TableField
    private Integer isUtilityInvention;
    /**
     * 是否请求早日公布该专利申请:1是；0否
     */
    @TableField
    private Integer isAnnouncedAdvance;
    /**
     * 申请文件清单:请求书；说明书摘要；权利要求书；说明书；说明书附图；核苷酸或氨基酸序列表；计算机可读形式的序列表 。是为1，否为0

     */
    @TableField
    private String listApplicationDocuments;
    /**
     * 附加文件清单：实质审查请求书；实质审查参考资料；优先权转让证明；优先权转让证明中文题录；保密证明材料；专利代理委托书；总委托书备案编号；在先申请文件副本；在先申请文件副本中文题录；生物材料样品保藏及存活证明；生物材料样品保藏及存活证明中文题录；向外国申请专利保密审查请求书；其他证明文件（注明文件名称）。是为1，否为0
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

    public FppInventionPatent() {
    }

    public FppInventionPatent(String patentId, String patentName, String inventor, String userId, String userName) {
        this.applicationNumber = patentId;
        this.inventionName = patentName;
        this.inventor1 = inventor;
        this.applicant1Id = userId;
        this.applicant1Name = userName;
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

    public String getInventor1() {
        return inventor1;
    }

    public void setInventor1(String inventor1) {
        this.inventor1 = inventor1;
    }

    public String getInventor2() {
        return inventor2;
    }

    public void setInventor2(String inventor2) {
        this.inventor2 = inventor2;
    }

    public String getInventor3() {
        return inventor3;
    }

    public void setInventor3(String inventor3) {
        this.inventor3 = inventor3;
    }

    public Integer getInventorAnnouncePublic() {
        return inventorAnnouncePublic;
    }

    public void setInventorAnnouncePublic(Integer inventorAnnouncePublic) {
        this.inventorAnnouncePublic = inventorAnnouncePublic;
    }

    public String getInventor1Region() {
        return inventor1Region;
    }

    public void setInventor1Region(String inventor1Region) {
        this.inventor1Region = inventor1Region;
    }

    public String getInventor1IdNumber() {
        return inventor1IdNumber;
    }

    public void setInventor1IdNumber(String inventor1IdNumber) {
        this.inventor1IdNumber = inventor1IdNumber;
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

    public String getBiomaterialsSamplePreservationUnitCode() {
        return biomaterialsSamplePreservationUnitCode;
    }

    public void setBiomaterialsSamplePreservationUnitCode(String biomaterialsSamplePreservationUnitCode) {
        this.biomaterialsSamplePreservationUnitCode = biomaterialsSamplePreservationUnitCode;
    }

    public String getBsAddress() {
        return bsAddress;
    }

    public void setBsAddress(String bsAddress) {
        this.bsAddress = bsAddress;
    }

    public Integer getBsIsAlive() {
        return bsIsAlive;
    }

    public void setBsIsAlive(Integer bsIsAlive) {
        this.bsIsAlive = bsIsAlive;
    }

    public Date getBsDepositTime() {
        return bsDepositTime;
    }

    public void setBsDepositTime(Date bsDepositTime) {
        this.bsDepositTime = bsDepositTime;
    }

    public String getBsDepositNumber() {
        return bsDepositNumber;
    }

    public void setBsDepositNumber(String bsDepositNumber) {
        this.bsDepositNumber = bsDepositNumber;
    }

    public String getBsClassificationNaming() {
        return bsClassificationNaming;
    }

    public void setBsClassificationNaming(String bsClassificationNaming) {
        this.bsClassificationNaming = bsClassificationNaming;
    }

    public Integer getIsSequenceListing() {
        return isSequenceListing;
    }

    public void setIsSequenceListing(Integer isSequenceListing) {
        this.isSequenceListing = isSequenceListing;
    }

    public Integer getIsGeneticResources() {
        return isGeneticResources;
    }

    public void setIsGeneticResources(Integer isGeneticResources) {
        this.isGeneticResources = isGeneticResources;
    }

    public String getRequestPriorityClaimOriginalInstitutionName() {
        return requestPriorityClaimOriginalInstitutionName;
    }

    public void setRequestPriorityClaimOriginalInstitutionName(String requestPriorityClaimOriginalInstitutionName) {
        this.requestPriorityClaimOriginalInstitutionName = requestPriorityClaimOriginalInstitutionName;
    }

    public Date getRpcPriorApplicationTime() {
        return rpcPriorApplicationTime;
    }

    public void setRpcPriorApplicationTime(Date rpcPriorApplicationTime) {
        this.rpcPriorApplicationTime = rpcPriorApplicationTime;
    }

    public String getRpcPriorApplicationNumber() {
        return rpcPriorApplicationNumber;
    }

    public void setRpcPriorApplicationNumber(String rpcPriorApplicationNumber) {
        this.rpcPriorApplicationNumber = rpcPriorApplicationNumber;
    }

    public Integer getWithoutLoseNoveltyGracePeriodStatement() {
        return withoutLoseNoveltyGracePeriodStatement;
    }

    public void setWithoutLoseNoveltyGracePeriodStatement(Integer withoutLoseNoveltyGracePeriodStatement) {
        this.withoutLoseNoveltyGracePeriodStatement = withoutLoseNoveltyGracePeriodStatement;
    }

    public Integer getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(Integer confidentiality) {
        this.confidentiality = confidentiality;
    }

    public Integer getIsUtilityInvention() {
        return isUtilityInvention;
    }

    public void setIsUtilityInvention(Integer isUtilityInvention) {
        this.isUtilityInvention = isUtilityInvention;
    }

    public Integer getIsAnnouncedAdvance() {
        return isAnnouncedAdvance;
    }

    public void setIsAnnouncedAdvance(Integer isAnnouncedAdvance) {
        this.isAnnouncedAdvance = isAnnouncedAdvance;
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
        return "FppInventionPatent{" +
                "uuid=" + uuid +
                ", applicationNumber=" + applicationNumber +
                ", divisionSubmissionDate=" + divisionSubmissionDate +
                ", applicationTime=" + applicationTime +
                ", feeReductionApproval=" + feeReductionApproval +
                ", applyForApproval=" + applyForApproval +
                ", registeredNumber=" + registeredNumber +
                ", inventionName=" + inventionName +
                ", inventor1=" + inventor1 +
                ", inventor2=" + inventor2 +
                ", inventor3=" + inventor3 +
                ", inventorAnnouncePublic=" + inventorAnnouncePublic +
                ", inventor1Region=" + inventor1Region +
                ", inventor1IdNumber=" + inventor1IdNumber +
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
                ", biomaterialsSamplePreservationUnitCode=" + biomaterialsSamplePreservationUnitCode +
                ", bsAddress=" + bsAddress +
                ", bsIsAlive=" + bsIsAlive +
                ", bsDepositTime=" + bsDepositTime +
                ", bsDepositNumber=" + bsDepositNumber +
                ", bsClassificationNaming=" + bsClassificationNaming +
                ", isSequenceListing=" + isSequenceListing +
                ", isGeneticResources=" + isGeneticResources +
                ", requestPriorityClaimOriginalInstitutionName=" + requestPriorityClaimOriginalInstitutionName +
                ", rpcPriorApplicationTime=" + rpcPriorApplicationTime +
                ", rpcPriorApplicationNumber=" + rpcPriorApplicationNumber +
                ", withoutLoseNoveltyGracePeriodStatement=" + withoutLoseNoveltyGracePeriodStatement +
                ", confidentiality=" + confidentiality +
                ", isUtilityInvention=" + isUtilityInvention +
                ", isAnnouncedAdvance=" + isAnnouncedAdvance +
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

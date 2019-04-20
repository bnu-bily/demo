package com.patent.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.patent.demo.entity.FppUser;
import com.patent.demo.mapper.FppUserMapper;
import com.patent.demo.service.FppUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.patent.demo.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wwj
 * @since 2018-07-22
 */
@Service
public class FppUserServiceImpl extends ServiceImpl<FppUserMapper, FppUser> implements FppUserService {

    @Autowired
    private FppUserMapper fppUserMapper;

    //状态：1申请中；2通过；3拉黑
    private int APPROVAING_STATE = 1;
    private int APPROVAL_STATE = 2;
    private int BLOCK_STATE = 3;

    @Override
    public void register(String userId, String userPassword, int registrationRequesterType, String registrationRequesterCode, String patentAgencyCode, String rrName, String rrRegion, String rrAddress, String rrTel, String rrEmail, String rrPostalCode, int rrReceiverInformation, int digitalCertificateForm, String contactName, String contactAddress, String contactTel, String contactEmail, String contactIdNumber, String listOfAccessories, String annex) {
        FppUser fppUser = new FppUser(userId, userPassword);
        fppUser.setState(APPROVAING_STATE);
        fppUser.setUuid(HashUtil.hashStr(userId));
        fppUser.setApplicationTime(new Date());

        fppUser.setRegistrationRequesterType(registrationRequesterType);
        if (registrationRequesterType == 1) {
            fppUser.setResidentIdNumber(registrationRequesterCode);
        } else if (registrationRequesterType == 2) {
            fppUser.setOrganizationCode(registrationRequesterCode);
        } else {
            fppUser.setBusinessLicenseNumber(registrationRequesterCode);
        }
        fppUser.setPatentAgencyCode(patentAgencyCode);
        fppUser.setRrName(rrName);
        fppUser.setRrRegion(rrRegion);
        fppUser.setRrAddress(rrAddress);
        fppUser.setRrTel(rrTel);
        fppUser.setRrEmail(rrEmail);
        fppUser.setRrPostalCode(rrPostalCode);
        fppUser.setRrReceiveInformation(rrReceiverInformation);
        fppUser.setDigitalCertificateForm(digitalCertificateForm);
        fppUser.setContactName(contactName);
        fppUser.setContactAddress(contactAddress);
        fppUser.setContactTel(contactTel);
        fppUser.setContactEmail(contactEmail);
        fppUser.setContactIdNumber(contactIdNumber);
        fppUser.setListOfAccessories(listOfAccessories);
        fppUser.setAnnex(annex);

        this.insert(fppUser);
    }

    @Override
    public void approvalRegisterUser(String userId, String userPassword, String adminId, String adminName) {
        FppUser fppUser = this.selectById(HashUtil.hashStr(userId));
        fppUser.setReviewId(adminId);
        fppUser.setReviewName(adminName);
        fppUser.setState(APPROVAL_STATE);
        this.updateById(fppUser);
    }

    //只有通过认证才能登陆
    @Override
    public FppUser login(String userId, String userPassword) {
        FppUser fppUser = this.selectOne(new EntityWrapper<FppUser>().eq("user_id", userId).eq("user_password", userPassword));
        return (fppUser != null && (APPROVAL_STATE == fppUser.getState())) ? fppUser : null;
    }

    @Override
    public void blackUser(String userId, String userName) {
        blackProcess(userId, userName, BLOCK_STATE);
    }

    @Override
    public void UnBlackUser(String userId, String userName) {
        blackProcess(userId, userName, APPROVAL_STATE);
    }

    private void blackProcess(String userId, String userName, int state) {
        FppUser fppUser = this.selectOne(new EntityWrapper<FppUser>().eq("user_id", userId).eq("rr_name", userName));
        fppUser.setState(state);
        this.updateById(fppUser);
    }

    @Override
    public boolean isUser(String userId, String userName) {
        return isUserInState(userId, userName, APPROVAL_STATE);
    }

    @Override
    public boolean isUserInState(String userId, String userName, int state) {
        FppUser fppUser = this.selectOne(new EntityWrapper<FppUser>().eq("user_id", userId).eq("rr_name", userName));
        return fppUser != null && fppUser.getState() == state;
    }

    /*
      判断用户是否存在
       */
    @Override
    public boolean isExistUser(String userId) {
        return (this.selectOne(new EntityWrapper<FppUser>().eq("user_id", userId)) != null);
    }

    @Override
    public boolean changePassword(String userId, String userName, String oldPassword, String newPassword) {
        FppUser fppUser = this.selectOne(new EntityWrapper<FppUser>().eq("user_id", userId).eq("rr_name", userName).eq("user_password", oldPassword));
        if (fppUser == null) return false;
        fppUser.setUserPassword(newPassword);
        this.updateById(fppUser);
        return true;
    }

}

package com.patent.demo.service;

import com.patent.demo.entity.FppUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wwj
 * @since 2018-07-22
 */
public interface FppUserService extends IService<FppUser> {


    void approvalRegisterUser(String userId, String userPassword, String adminId, String adminName);

    FppUser login(String userId, String userPassword);

    void blackUser(String userId, String userName);

    void UnBlackUser(String userId, String userName);

    boolean isUser(String userId, String userName);

    boolean isUserInState(String userId, String userName, int state);

    boolean isExistUser(String userId);

    void register(String userId, String userPassword, int registrationRequesterType, String registrationRequesterCode, String patentAgencyCode, String rrName, String rrRegion, String rrAddress, String rrTel, String rrEmail, String rrPostalCode, int rrReceiverInformation, int digitalCertificateForm, String contactName, String contactAddress, String contactTel, String contactEmail, String contactIdNumber, String listOfAccessories, String annex);

    boolean changePassword(String userId, String userName, String oldPassword, String newPassword);
}

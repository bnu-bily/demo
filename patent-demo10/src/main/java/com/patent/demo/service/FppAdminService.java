package com.patent.demo.service;

import com.patent.demo.entity.FppAdmin;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wwj
 * @since 2018-07-22
 */
public interface FppAdminService extends IService<FppAdmin> {


    FppAdmin login(String adminId, String adminPassword);

    boolean isAdmin(String adminId);

    void register(String adminId, String adminPassword, String registrationCode, String adminName, String adminRegion, String adminIdNumber, String adminAddress, String adminTel, String adminEmail, String adminPostalCode);

    boolean changePassword(String adminId, String adminName, String oldPassword, String newPassword);
}

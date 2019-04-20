package com.patent.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.patent.demo.entity.FppAdmin;
import com.patent.demo.entity.FppUser;
import com.patent.demo.mapper.FppAdminMapper;
import com.patent.demo.service.FppAdminService;
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
public class FppAdminServiceImpl extends ServiceImpl<FppAdminMapper, FppAdmin> implements FppAdminService {

    @Autowired
    private FppAdminMapper fppAdminMapper;

    //管理员状态:1有效；2失效
    private int ADMIN_ABLE = 1;
    private int ADMIN_UNABLE = 2;

    @Override
    public void register(String adminId, String adminPassword, String registrationCode, String adminName, String adminRegion, String adminIdNumber, String adminAddress, String adminTel, String adminEmail, String adminPostalCode) {
        FppAdmin fppAdmin = new FppAdmin(adminId, adminName, adminPassword);
        fppAdmin.setState(ADMIN_ABLE);
        fppAdmin.setUuid(HashUtil.hashStr(adminId + adminName));
        fppAdmin.setRegistrationTime(new Date());

        fppAdmin.setRegistrationCode(registrationCode);
        fppAdmin.setAdminRegion(adminRegion);
        fppAdmin.setAdminIdNumber(adminIdNumber);
        fppAdmin.setAdminAddress(adminAddress);
        fppAdmin.setAdminTel(adminTel);
        fppAdmin.setAdminEmail(adminEmail);
        fppAdmin.setAdminPostalCode(adminPostalCode);
        this.insert(fppAdmin);
    }

    @Override
    public FppAdmin login(String userId, String userPassword) {
        FppAdmin fppAdmin = fppAdminMapper.selectOne(new FppAdmin(userId, userPassword));
        if (fppAdmin != null && (ADMIN_ABLE == fppAdmin.getState())) {
            return fppAdmin;
        }
        return null;
    }

    @Override
    public boolean isAdmin(String adminId) {
        FppAdmin fppAdmin = this.selectById(adminId);
        return fppAdmin != null;
    }

    @Override
    public boolean changePassword(String adminId, String adminName, String oldPassword, String newPassword) {
        FppAdmin fppAdmin = this.selectOne(new EntityWrapper<FppAdmin>().eq("admin_id", adminId).eq("admin_name", adminName).eq("admin_password", oldPassword));
        if (fppAdmin == null) return false;
        fppAdmin.setAdminPassword(newPassword);
        this.updateById(fppAdmin);
        return true;
    }
}

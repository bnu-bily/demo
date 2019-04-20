package com.patent.demo.service.impl;

import com.patent.demo.entity.FppLoginLogout;
import com.patent.demo.mapper.FppLoginLogoutMapper;
import com.patent.demo.service.FppLoginLogoutService;
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
public class FppLoginLogoutServiceImpl extends ServiceImpl<FppLoginLogoutMapper, FppLoginLogout> implements FppLoginLogoutService {
    @Autowired
    private FppLoginLogoutMapper fppLoginLogoutMapper;

    //登录类型:1普通用户登入；2管理员登入；3普通用户登出；4管理员登出
    private int USER_LOGIN = 1;
    private int ADMIN_LOGIN = 2;
    private int USER_LOGOUT = 3;
    private int ADMIN_LOGOUT = 4;

    @Override
    public boolean login(String userId, String userName, int userType) {
        Date currentTime = new Date();
        FppLoginLogout fppLoginLogout = new FppLoginLogout(userId, userName);
        String uuid = HashUtil.hashStr(userId + userName + currentTime);
        fppLoginLogout.setAccountType(userType);
        FppLoginLogout fppLoginLogout1 = fppLoginLogoutMapper.selectOne(fppLoginLogout);
        if (fppLoginLogout1 != null && (fppLoginLogout1.getLoginTime() != null && fppLoginLogout1.getLogoutTime() == null))
            return false;
        fppLoginLogout.setLoginTime(currentTime);
        fppLoginLogout.setUuid(uuid);
        fppLoginLogout.setAccountType(userType);
        fppLoginLogoutMapper.insert(fppLoginLogout);
        return true;


    }

    @Override
    public boolean logout(String userId, String userName, int userType) {
        FppLoginLogout userLoginLogout = new FppLoginLogout(userId, userName);
        userLoginLogout.setAccountType(userType - 2);
        FppLoginLogout userLoginLogout1 = fppLoginLogoutMapper.selectOne(userLoginLogout);
        if (userLoginLogout1 != null && (userLoginLogout1.getLoginTime() != null && userLoginLogout1.getLogoutTime() == null)) {
            userLoginLogout1.setLogoutTime(new Date());
            userLoginLogout1.setAccountType(userType);
            fppLoginLogoutMapper.updateById(userLoginLogout1);
            return true;
        }
        return false;
    }

}

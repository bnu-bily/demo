package com.patent.demo.service;

import com.patent.demo.entity.FppLoginLogout;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2018-07-22
 */
public interface FppLoginLogoutService extends IService<FppLoginLogout> {

    boolean login(String userId, String userName, int userType);

    boolean logout(String userId, String userName,int userType);
}

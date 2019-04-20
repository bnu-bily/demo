package com.patent.demo.service.impl;

import com.patent.demo.entity.FppAccountKeyCenter;
import com.patent.demo.mapper.FppAccountKeyCenterMapper;
import com.patent.demo.service.FppAccountKeyCenterService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
@Service
public class FppAccountKeyCenterServiceImpl extends ServiceImpl<FppAccountKeyCenterMapper, FppAccountKeyCenter> implements FppAccountKeyCenterService {

    @Autowired
    private FppAccountKeyCenterMapper fppAccountKeyCenterMapper;
}

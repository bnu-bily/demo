package com.patent.demo.service;

import com.patent.demo.entity.FppFilterWord;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2018-10-24
 */
public interface FppFilterWordService extends IService<FppFilterWord> {

    boolean isEffectKeyword(String keyWord, int state);

    boolean containKeyWord(String patentName);
}

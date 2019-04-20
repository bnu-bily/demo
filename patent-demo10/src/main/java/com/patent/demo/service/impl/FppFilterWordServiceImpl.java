package com.patent.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.patent.demo.entity.FppFilterWord;
import com.patent.demo.mapper.FppFilterWordMapper;
import com.patent.demo.service.FppFilterWordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wwj
 * @since 2018-10-24
 */
@Service
public class FppFilterWordServiceImpl extends ServiceImpl<FppFilterWordMapper, FppFilterWord> implements FppFilterWordService {

    @Autowired
    private FppFilterWordMapper fppFilterWordMapper;

    @Override
    public boolean isEffectKeyword(String keyWord, int state) {
        FppFilterWord fppFilterWord = this.selectOne(new EntityWrapper<FppFilterWord>().eq("word", keyWord));
        if (fppFilterWord == null) return false;
        if (state == 0) fppFilterWord.setEndTime(new Date());
        else fppFilterWord.setStartTime(new Date());

        fppFilterWord.setIsEffective(state);
        this.updateById(fppFilterWord);
        return true;
    }

    @Override
    public boolean containKeyWord(String patentName) {
        List<FppFilterWord> maps = this.selectList(new EntityWrapper<FppFilterWord>().eq("is_effective", 1));
        if (maps != null) {
            for (FppFilterWord map : maps) {
                if (patentName.contains(map.getWord())) return true;
            }
        }
        return false;
    }

}
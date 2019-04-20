package com.patent.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.patent.demo.entity.FppOperation;
import com.patent.demo.mapper.FppOperationMapper;
import com.patent.demo.service.FppOperationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.patent.demo.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wwj
 * @since 2018-07-25
 */
@Service
public class FppOperationServiceImpl extends ServiceImpl<FppOperationMapper, FppOperation> implements FppOperationService {

    @Autowired
    private FppOperationMapper fppOperationMapper;

    //操作：1申请用户；2拉黑用户（撤销拉黑）；3初次审查专利；4补正专利；5实质审查专利；6撤销专利；7恢复专利；8续费专利；9更正错误专利；10转让专利；11专利过期.
    private int APPLICATION_USER = 1;
    private int BLOCK_USER = 2;
    private int FIRST_REVIEW_PATENT = 3;
    private int PATENT_RECORRECT = 4;
    private int SUBSTATIVE_REVIEW = 5;
    private int PATENT_CANCEL = 6;
    private int PATENT_RESTORE = 7;
    private int PATENT_RENEWAL_FEE = 8;
    private int PATENT_RECORRECT_ERROR = 9;
    private int PATENT_TRANSFTER = 10;
    private int PATENT_EXPIRATION = 11;

    //是否同意审核通过
    private int IS_AGREE = 1;
    private int IS_NOT_AGREE = 0;
    //值为空时默认的时间1970-01-18 20:45:36
    private Date DEFAULT_TIME = new Date(1514736000L);

    @Override
    public void registerUser(String userId, String userName) {
        Date currentTime = new Date();
        FppOperation fppUserOperation = new FppOperation(userId, userName);
        fppUserOperation.setUuid(HashUtil.hashStr(userId + userName + currentTime));
        fppUserOperation.setOperationType(APPLICATION_USER);
        fppUserOperation.setOperationTime(currentTime);

        fppUserOperation.setPaymentTime(DEFAULT_TIME);
        fppUserOperation.setAnnexSubmitTime(DEFAULT_TIME);
        this.insert(fppUserOperation);
    }


    @Override
    public void registerPatent(String userId, String userName, int patentType, String patentId, String patentName, String payment) {
        Date currentTime = new Date();
        FppOperation fppUserOperation = operatePatent(userId, userName, patentType, patentId, patentName, currentTime, FIRST_REVIEW_PATENT);

        if (payment != null) {
            fppUserOperation.setPaymentTime(currentTime);
            fppUserOperation.setPayment(payment);
        }
        this.insert(fppUserOperation);

    }

    @Override
    public void reviewUser(String adminId, String adminName, String userId, String userName, int state) {
        state = (state == 1) ? IS_AGREE : IS_NOT_AGREE;
        List<FppOperation> maps = this.selectList(new EntityWrapper<FppOperation>()
                .eq("user_id", userId)
                .eq("user_name", userName)
                .eq("operation_type", APPLICATION_USER));
        for (FppOperation map : maps) {
            if (map.getIsAgree() == null && map.getPatentType() == null && map.getPatentId() == null && map.getPatentName() == null) {
                map.setAnnexSubmitTime(DEFAULT_TIME);
                map.setReviewTime(new Date());
                map.setReviewId(adminId);
                map.setReviewName(adminName);

            }
            map.setIsAgree(state);
            //updateById/insertOrUpdate会把值为空的时间戳更新为最新时间
            this.updateById(map);
        }

    }

    @Override
    public void reviewPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state) {
        reviewOperatePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, null, null, state, FIRST_REVIEW_PATENT);
    }

    @Override
    public void preSubstantiveReviewPatent(String userId, String userName, int patentType, String patentId, String patentName) {
        Date currentTime = new Date();
        FppOperation fppUserOperation = operatePatent(userId, userName, patentType, patentId, patentName, currentTime, SUBSTATIVE_REVIEW);

        fppUserOperation.setPaymentTime(DEFAULT_TIME);
        this.insert(fppUserOperation);

    }

    @Override
    public void preRecorrectPatent(String userId, String userName, int patentType, String patentId, String patentName) {
        Date currentTime = new Date();
        FppOperation fppUserOperation = operatePatent(userId, userName, patentType, patentId, patentName, currentTime, PATENT_RECORRECT);

        fppUserOperation.setPaymentTime(DEFAULT_TIME);
        this.insert(fppUserOperation);
    }

    @Override
    public void recorrectPatent(String userId, String userName, int patentType, String patentId, String patentName, String annex) {
        reviewOperatePatent(null, null, userId, userName, patentType, patentId, patentName, annex, null, 1, PATENT_RECORRECT);
    }


    @Override
    public void requestSubstantiveReview(String userId, String userName, int patentType, String patentId, String patentName, String annex) {
        reviewOperatePatent(null, null, userId, userName, patentType, patentId, patentName, annex, null, 1, SUBSTATIVE_REVIEW);
    }

    @Override
    public void reviewRecorrectPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state) {
        reviewOperatePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, null, null, state, PATENT_RECORRECT);
    }


    @Override
    public void substantiveReviewPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state) {
        reviewOperatePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, null, null, state, SUBSTATIVE_REVIEW);
    }

    //不管是拉黑还是恢复都会加多一条记录
    @Override
    public void blackUser(String adminId, String adminName, String userId, String userName) {
        isBlack(adminId, adminName, userId, userName, IS_AGREE);
    }

    @Override
    public void UnBlackUser(String adminId, String adminName, String userId, String userName) {
        isBlack(adminId, adminName, userId, userName, IS_NOT_AGREE);
    }

    private void isBlack(String adminId, String adminName, String userId, String userName, int state) {
        Date currentTime = new Date();
        FppOperation fppUserOperation = new FppOperation(userId, userName);
        fppUserOperation.setUuid(HashUtil.hashStr(userId + userName + currentTime));
        fppUserOperation.setOperationType(BLOCK_USER);
        fppUserOperation.setOperationTime(currentTime);

        fppUserOperation.setPaymentTime(DEFAULT_TIME);
        fppUserOperation.setReviewId(adminId);
        fppUserOperation.setReviewName(adminName);
        fppUserOperation.setReviewTime(currentTime);
        fppUserOperation.setIsAgree(state);
        fppUserOperation.setAnnexSubmitTime(DEFAULT_TIME);
        this.insert(fppUserOperation);
    }

    @Override
    public void transferPatent(String userId, String userName, int patentType, String patentId, String patentName, String transferUserId, String transferUserName, String annex) {
        Date currentTime = new Date();
        FppOperation fppUserOperation = operatePatent(userId, userName, patentType, patentId, patentName, currentTime, PATENT_TRANSFTER);

        fppUserOperation.setTransferUserId(transferUserId);
        fppUserOperation.setTransferUserName(transferUserName);

        fppUserOperation.setPaymentTime(DEFAULT_TIME);
        //annex为转让协议合同等
        fppUserOperation.setAnnex(annex);
        fppUserOperation.setAnnexSubmitTime(currentTime);
        this.insert(fppUserOperation);
    }

    @Override
    public void reviewTransferPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, String transferUserId, String transferUserName, int state) {
        state = (state == 1) ? IS_AGREE : IS_NOT_AGREE;
        List<FppOperation> maps = this.selectList(new EntityWrapper<FppOperation>()
                .eq("user_id", userId)
                .eq("user_name", userName)
                .eq("operation_type", PATENT_TRANSFTER)
                .eq("patent_type", patentType)
                .eq("patent_id", patentId)
                .eq("patent_name", patentName)
                .eq("transfer_user_id", transferUserId)
                .eq("transfer_user_name", transferUserName));

        review(maps, adminId, adminName, state);
    }

    @Override
    public void renewalFeePatent(String userId, String userName, int patentType, String patentId, String patentName) {
        reviewRenewalOrExpiration(userId, userName, patentType, patentId, patentName, PATENT_RENEWAL_FEE);
    }

    @Override
    public void expirationPatent(String userId, String userName, int patentType, String patentId, String patentName) {
        reviewRenewalOrExpiration(userId, userName, patentType, patentId, patentName, PATENT_EXPIRATION);
    }

    @Override
    public void renewalFeePatentPayment(String userId, String userName, int patentType, String patentId, String patentName, String payment) {
        reviewOperatePatent(null, null, userId, userName, patentType, patentId, patentName, null, payment, 1, PATENT_RENEWAL_FEE);
    }

    @Override
    public void reviewPayPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state) {
        reviewOperatePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, null, null, state, PATENT_RENEWAL_FEE);
    }

    @Override
    public void cancelPatent(String userId, String userName, int patentType, String patentId, String patentName, String annex) {
        Date currentTime = new Date();
        operatePatentByAnnex(userId, userName, patentType, patentId, patentName, currentTime, PATENT_CANCEL, annex);
    }

    @Override
    public boolean selectByState(String userId, String userName, int patentType, String patentId, String patentName) {
        List<FppOperation> maps = this.selectList(new EntityWrapper<FppOperation>()
                .eq("user_id", userId)
                .eq("user_name", userName)
                .eq("operation_type", PATENT_CANCEL)
                .eq("patent_type", patentType)
                .eq("patent_id", patentId)
                .eq("patent_name", patentName)
                .eq("is_agree", 1));
        return maps != null;
    }

    @Override
    public void restorePatent(String userId, String userName, int patentType, String patentId, String patentName, String annex) {
        Date currentTime = new Date();
        operatePatentByAnnex(userId, userName, patentType, patentId, patentName, currentTime, PATENT_RESTORE, annex);
    }

    @Override
    public void reviewCancelPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state) {
        reviewOperatePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, null, null, state, PATENT_CANCEL);
    }

    @Override
    public void reviewRestorePatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state) {
        reviewOperatePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, null, null, state, PATENT_RESTORE);
    }

    @Override
    public void recorrectMistake(String userId, String userName, int patentType, String patentId, String patentName, String annex) {
        Date currentTime = new Date();
        operatePatentByAnnex(userId, userName, patentType, patentId, patentName, currentTime, PATENT_RECORRECT_ERROR, annex);

    }

    @Override
    public void reviewRecorrectMistake(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state) {
        reviewOperatePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, null, null, state, PATENT_RECORRECT_ERROR);
    }

    private FppOperation operatePatent(String userId, String userName, int patentType, String patentId, String patentName, Date currentTime, int state) {
        FppOperation fppUserOperation = new FppOperation(userId, userName, patentType, patentId, patentName);
        fppUserOperation.setUuid(HashUtil.hashStr(userId + userName + patentId + patentName + currentTime));
        fppUserOperation.setOperationType(state);
        fppUserOperation.setOperationTime(currentTime);
        return fppUserOperation;
    }

    private void operatePatentByAnnex(String userId, String userName, int patentType, String patentId, String patentName, Date currentTime, int state, String annex) {
        FppOperation fppUserOperation = operatePatent(userId, userName, patentType, patentId, patentName, currentTime, state);

        fppUserOperation.setPaymentTime(DEFAULT_TIME);
        fppUserOperation.setAnnex(annex);
        fppUserOperation.setAnnexSubmitTime(currentTime);
        this.insert(fppUserOperation);
    }

    private void reviewOperatePatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, String annex, String payment, int state, int operationType) {
        state = (state == 1) ? IS_AGREE : IS_NOT_AGREE;
        List<FppOperation> maps = this.selectList(new EntityWrapper<FppOperation>()
                .eq("user_id", userId)
                .eq("user_name", userName)
                .eq("operation_type", operationType)
                .eq("patent_type", patentType)
                .eq("patent_id", patentId)
                .eq("patent_name", patentName));

        if (operationType == FIRST_REVIEW_PATENT) {
            review(maps, adminId, adminName, state);
        } else if (operationType == PATENT_RECORRECT || operationType == SUBSTATIVE_REVIEW) {
            for (FppOperation map : maps) {
                if (map.getIsAgree() == null) {
                    if (map.getAnnex() != null) {
                        map.setReviewId(adminId);
                        map.setReviewName(adminName);
                        map.setReviewTime(new Date());
                        map.setIsAgree(state);
                    } else {
                        //annex（补正书、实质审查书）
                        map.setAnnex(annex);
                        map.setAnnexSubmitTime(new Date());
                    }
                }
                this.updateById(map);
            }
        } else if (operationType == PATENT_RENEWAL_FEE) {
            for (FppOperation map : maps) {
                if (map.getIsAgree() == null) {
                    if (map.getPayment() != null) {
                        map.setReviewId(adminId);
                        map.setReviewName(adminName);
                        map.setReviewTime(new Date());
                        map.setIsAgree(state);
                    } else {
                        map.setPayment(payment);
                        map.setPaymentTime(new Date());
                    }
                }
                this.updateById(map);
            }
        } else if (operationType == PATENT_CANCEL || operationType == PATENT_RESTORE || operationType == PATENT_RECORRECT_ERROR) {
            review(maps, adminId, adminName, state);
        }
    }

    private void review(List<FppOperation> maps, String adminId, String adminName, int state) {
        for (FppOperation map : maps) {
            if (map.getIsAgree() == null) {
                map.setReviewId(adminId);
                map.setReviewName(adminName);
                map.setReviewTime(new Date());
                map.setIsAgree(state);
            }
            this.updateById(map);
        }
    }

    private void reviewRenewalOrExpiration(String userId, String userName, int patentType, String patentId, String patentName, int state) {
        Date currentTime = new Date();
        FppOperation fppUserOperation = operatePatent(userId, userName, patentType, patentId, patentName, currentTime, state);

        fppUserOperation.setPaymentTime(DEFAULT_TIME);
        fppUserOperation.setAnnexSubmitTime(currentTime);
        this.insert(fppUserOperation);
    }
}




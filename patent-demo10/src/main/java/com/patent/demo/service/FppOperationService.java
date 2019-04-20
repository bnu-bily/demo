package com.patent.demo.service;

import com.patent.demo.entity.FppOperation;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wwj
 * @since 2018-07-25
 */
public interface FppOperationService extends IService<FppOperation> {

    void registerUser(String userId, String userName);

    void registerPatent(String userId, String userName, int patentType, String patentId, String patentName, String payment);

    void reviewUser(String adminId, String adminName, String userId, String userName, int state);

    void reviewPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state);

    void preSubstantiveReviewPatent(String userId, String userName, int patentType, String patentId, String patentName);

    void preRecorrectPatent(String userId, String userName, int patentType, String patentId, String patentName);

    void recorrectPatent(String userId, String userName, int patentType, String patentId, String patentName, String annex);

    void reviewRecorrectPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state);

    void requestSubstantiveReview(String userId, String userName, int patentType, String patentId, String patentName, String annex);

    void substantiveReviewPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state);

    void blackUser(String adminId, String adminName, String userId, String userName);

    void UnBlackUser(String adminId, String adminName, String userId, String userName);

    void transferPatent(String userId, String userName, int patentType, String patentId, String patentName, String transferUserId, String transferUserName, String annex);

    void reviewTransferPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, String transferUserId, String transferUserName, int state);

    void renewalFeePatent(String userId, String userName, int patentType, String patentId, String patentName);

    void renewalFeePatentPayment(String userId, String userName, int patentType, String patentId, String patentName, String payment);

    void reviewPayPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state);

    void cancelPatent(String userId, String userName, int patentType, String patentId, String patentName, String annex);

    boolean selectByState(String userId, String userName, int patentType, String patentId, String patentName);

    void restorePatent(String userId, String userName, int patentType, String patentId, String patentName, String annex);

    void reviewCancelPatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state);

    void reviewRestorePatent(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state);

    void recorrectMistake(String userId, String userName, int patentType, String patentId, String patentName, String annex);

    void reviewRecorrectMistake(String adminId, String adminName, String userId, String userName, int patentType, String patentId, String patentName, int state);

    void expirationPatent(String userId, String userName, int patentType, String patentId, String patentName);
}

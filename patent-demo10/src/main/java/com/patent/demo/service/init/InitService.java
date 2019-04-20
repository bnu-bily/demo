package com.patent.demo.service.init;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class InitService {

    @PostConstruct
    public void startBeforeAPP() {
        System.out.println("hello,world!");
        //  backup( "","","","","","");
    }

    /**
     * @param hostIP       ip地址，可以是本机也可以是远程
     * @param userName     数据库的用户名
     * @param password     数据库的密码
     * @param savePath     备份的路径
     * @param fileName     备份的文件名
     * @param databaseName 需要备份的数据库的名称
     * @return
     */

    public static boolean backup(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) {

        fileName += ".sql";
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if (!savePath.endsWith(File.separator)) {
            savePath = savePath + File.separator;
        }

        //拼接命令行的命令
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump").append(" --opt").append(" -h").append(hostIP);
        stringBuilder.append(" --user=").append(userName).append(" --password=").append(password)
                .append(" --lock-all-tables=true");
        stringBuilder.append(" --result-file=").append(savePath + fileName).append(" --default-character-set=utf8 ")
                .append(databaseName);
        try {
            //调用外部执行exe文件的javaAPI
            Process process = Runtime.getRuntime().exec(stringBuilder.toString());
            if (process.waitFor() == 0) {// 0 表示线程正常终止。
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }
}
package com.patent.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.patent.demo.mapper*")

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//		SpringApplication.run(DemoApplication.class, args).addApplicationListener(new ApplicationListener<ApplicationEvent>() {
//			@Override
//			public void onApplicationEvent(ApplicationEvent event) {
//				recover("","","","","");
//			}
//		});
    }

    /**
     * @param filepath 数据库备份的脚本路径
     * @param ip       IP地址
     * @param database 数据库名称
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public static boolean recover(String filepath, String ip, String database, String userName, String password) {

        String stmt1 = "mysqladmin -h " + ip + " -u " + userName + " -p" + password + " create " + database;

        String stmt2 = "mysql -h " + ip + " -u " + userName + " -p " + password + " " + database + " < " + filepath;

        String[] cmd = {"cmd", "/c", stmt2};

        try {
            Runtime.getRuntime().exec(stmt1);
            Runtime.getRuntime().exec(cmd);
            System.out.println("数据已从 " + filepath + " 导入到数据库中");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
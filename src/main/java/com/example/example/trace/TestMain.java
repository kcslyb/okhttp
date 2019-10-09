package com.example.example.trace;

import com.example.example.common.retrofit.RetrofitFactory;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Response;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author kcs
 * @date 2019-10-08 20:54
 **/
public class TestMain {


    public static void main(String[] args) {
        String account = null;
        String pwd = null;
        TestService testService = RetrofitFactory.getRetrofitHelper(TestService.class);
        System.out.println("请输入账号");
        Scanner scanner=new Scanner(System.in);
        if (scanner.hasNext()){
            account = scanner.next();
        }
        System.out.println("请输入密码");
        if (scanner.hasNext()){
            pwd = scanner.next();
        }
        if (!StringUtils.isEmpty(account) && !StringUtils.isEmpty(pwd)) {
            LoginDto loginDto = new LoginDto();
            loginDto.setType("0");
            loginDto.setUsername(account);
            loginDto.setEncryptionPsw(pwd);
            System.out.println("输入的账户为："+account+"\t输入的密码为："+pwd);
            try {
                Response<Object> execute = testService.login(loginDto).execute();
                if (execute.code() == 200) {
                    System.out.println("登录成功");
                }else {
                    System.out.println("登录失败:" + execute.message());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//        try {
//            Response<Object> execute1 = testService.login(loginDto).execute();
//            System.out.println(execute1.code());
//            Response<Object> execute = testService.getTraceCode().execute();
//            System.out.println(execute.body());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

package com.example.example.trace;

import com.example.example.common.retrofit.RetrofitFactory;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kcs
 * @date 2019-10-08 20:54
 **/
public class TestMain {


    public static void main(String[] args) {
        String pwd = null;
        String orderNo = null;
        String orderId = null;
        String batchNumber = null;

        TestMain testMain = new TestMain();
        Map<String, String> mapAccount = testMain.acceptAccountInfo();
        if (!StringUtils.isEmpty(mapAccount.get("account")) && !StringUtils.isEmpty(mapAccount.get("pwd"))) {
            LoginDto loginDto = new LoginDto();
            loginDto.setType("0");
            loginDto.setUsername(mapAccount.get("account"));
            loginDto.setPassword(mapAccount.get("pwd"));
            System.out.println("输入的账户为：" + mapAccount.get("account") + "\t输入的密码为：" + mapAccount.get("pwd"));
            try {
                TestService testService = RetrofitFactory.getRetrofitHelper(TestService.class);
                Response<Object> execute = testService.login(loginDto).execute();
                if (execute.code() == 200) {
                    System.out.println("登录成功");
                    Map<String, String> mapOrder = testMain.acceptOrderInfo();
                    int judge = judge(chooseFun());
                    if (judge == 1) {

                    } else if (judge == 2) {
                        String acceptBatchNumber = testMain.acceptBatchNumber();
                    } else if (judge == 3) {
                        System.out.println("退出程序");
                        System.exit(0);
                    }
                } else {
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

    private static int judge(String code) {
        switch (code) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            default:
                return judge(chooseFun());
        }
    }

    private static String chooseFun() {
        System.out.println("请选择输入功能代码(数字1或者2)后回车：\n\t1、【导出码上放心格式文件】\t\t\t2、【导出所选批号关联追溯码文件】\t\t\t3、【退出】");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String code = scanner.next();
            return code;
        }
        return "-1";
    }


    public Map<String, String> acceptAccountInfo() {
        Map<String, String> map = new HashMap<>();
        System.out.println("请输入账号,输入完毕后回车");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String account = scanner.next();
            map.put("account", account);
        }
        System.out.println("请输入密码,输入完毕后回车");
        if (scanner.hasNext()) {
            String pwd = scanner.next();
            map.put("pwd", pwd);
        }
        return map;
    }

    public Map<String, String> acceptOrderInfo() {
        Map<String, String> map = new HashMap<>();
        System.out.println("请输入订单编号,输入完毕后回车");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String orderNo = scanner.next();
            map.put("orderNo", orderNo);
        }
        System.out.println("请输入订单ID（网页端打开订单详情中地址栏最后一个“/”符号后字符串）,输入完毕后回车");
        if (scanner.hasNext()) {
            String orderId = scanner.next();
            map.put("orderId", orderId);
        }
        return map;
    }

    public String acceptBatchNumber() {
        String batchNumber = null;
        System.out.println("请输入批号,输入完毕后回车");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            batchNumber = scanner.next();
        }
        return batchNumber;
    }

}

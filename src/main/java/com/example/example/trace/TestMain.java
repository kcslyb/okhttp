package com.example.example.trace;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.example.common.retrofit.RetrofitFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import retrofit2.Call;
import retrofit2.Response;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @author kcs
 * @date 2019-10-08 20:54
 **/
public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        Map<String, String> mapAccount = testMain.acceptAccountInfo();
        if (!StringUtils.isEmpty(mapAccount.get("account")) && !StringUtils.isEmpty(mapAccount.get("pwd"))) {
            LoginDto loginDto = new LoginDto();
            loginDto.setType("0");
            loginDto.setUsername(mapAccount.get("account"));
            loginDto.setPassword(mapAccount.get("pwd"));
            try {
                TestService testService = RetrofitFactory.getRetrofitHelper(TestService.class);
                Response<Object> execute = testService.login(loginDto).execute();
                if (execute.code() == 200) {
                    System.out.println("登录成功");
                    String orderNo = testMain.acceptOrderInfo();
                    int judge = judge(chooseFun());
                    if (judge == 1) {
                        Response<PageResponse<CodePackageDto>> execute1 = testService.getTraceCode2(orderNo).execute();
                        if (execute1.code() == 200) {
                            PageResponse<CodePackageDto> body = execute1.body();
                            List<CodePackageDto> list = body.getList();
                            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), CodePackageDto.class, list);
                            try {
                                String fileName = System.currentTimeMillis() + ".xls";
                                File saveFile = new File("./excel/t");
                                if (!saveFile.exists()) {
                                    saveFile.mkdirs();
                                }
                                FileOutputStream fos = new FileOutputStream(new File(saveFile.getPath(),fileName));
                                workbook.write(fos);
                                System.out.println(saveFile.toPath()+fileName);
                                workbook.close();
                                fos.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (judge == 2) {
                        String acceptBatchNumber = testMain.acceptBatchNumber();
                        Response<CodeListDto> execute1 = testService.getTraceCode(orderNo).execute();
                        if (execute1.code() == 200) {
                            List<CodePackageDto> codePackageDtoList = execute1.body().getList();
                            codePackageDtoList.stream().filter(new Predicate<CodePackageDto>() {
                                @Override
                                public boolean test(CodePackageDto codePackageDto) {
                                    return !acceptBatchNumber.equals(codePackageDto.getBatchNumber());
                                }
                            });
                            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), CodePackageDto.class, codePackageDtoList);
                            try {
                                String fileName = System.currentTimeMillis() + ".xls";
                                File saveFile = new File("./excel/t");
                                if (!saveFile.exists()) {
                                    saveFile.mkdirs();
                                }
                                FileOutputStream fos = new FileOutputStream(saveFile.getPath() + fileName);
                                workbook.write(fos);
                                workbook.close();
                                fos.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
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

    public String acceptOrderInfo() {
        System.out.println("请输入订单编号,输入完毕后回车");
        Scanner scanner = new Scanner(System.in);
        String orderNo = null;
        if (scanner.hasNext()) {
            orderNo = scanner.next();
        }
        return orderNo;
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

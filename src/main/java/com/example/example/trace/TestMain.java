package com.example.example.trace;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.example.example.common.retrofit.RetrofitFactory;
import com.example.example.common.util.Constant;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import retrofit2.Response;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author kcs
 * @date 2019-10-08 20:54
 **/
public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();

        Map<String, String> mapAccount = testMain.acceptAccountInfo();
        if (!StringUtils.isEmpty(mapAccount.get("account")) && !StringUtils.isEmpty(mapAccount.get("pwd"))&&!StringUtils.isEmpty(mapAccount.get("code"))) {
            LoginDto loginDto = new LoginDto();
            loginDto.setType("1");
            loginDto.setOrgCode(mapAccount.get("code"));
            loginDto.setUsername(mapAccount.get("account"));
            loginDto.setPassword(mapAccount.get("pwd"));
            try {
                Properties properties = new Properties();
                InputStream is = new BufferedInputStream(new FileInputStream(new File("./url.properties")));
                properties.load(is);
                String url = properties.getProperty("url");
                if (url != null && url.length() > 1) {
                    Constant.apiUrl = url;
                }

                TestService testService = RetrofitFactory.getRetrofitHelper(TestService.class);
                Response<Object> execute = testService.login(loginDto).execute();
                if (execute.code() == 200) {
                    System.out.println("登录成功");
                    String orderNo = testMain.acceptParentCode();
                    int judge = judge(chooseFun());
                    if (judge == 1) {
                        Response<PageResponse<CodePackDto>> execute1 = testService.getCodeRelationship(orderNo).execute();
                        if (execute1.code() == 200) {
                            PageResponse<CodePackDto> body = execute1.body();
                            List<CodePackDto> list = body.getList();
                            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), CodePackDto.class, list);
                            try {
                                String fileName = System.currentTimeMillis() + ".xls";
                                File saveFile = new File("./excel/");
                                if (!saveFile.exists()) {
                                    saveFile.mkdirs();
                                }
                                FileOutputStream fos = new FileOutputStream(new File(saveFile.getPath(), fileName));
                                workbook.write(fos);
                                System.out.println("导出文件位于" + saveFile.getAbsolutePath() + fileName);
                                workbook.close();
                                fos.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println(execute1.message());
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
                                File saveFile = new File("./excel/");
                                if (!saveFile.exists()) {
                                    saveFile.mkdirs();
                                }
                                FileOutputStream fos = new FileOutputStream(saveFile.getPath() + fileName);
                                System.out.println("导出文件位于" + saveFile.getAbsolutePath() + fileName);
                                workbook.write(fos);
                                workbook.close();
                                fos.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println(execute1.message());
                        }
                    } else if (judge == 3) {
                        Response<CodeListDto> execute1 = testService.getTraceCode(orderNo).execute();
                        if (execute1.code() == 200) {
                            List<CodePackageDto> codePackageDtoList = execute1.body().getList();
                            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), CodePackageDto.class, codePackageDtoList);
                            try {
                                String fileName = System.currentTimeMillis() + ".xls";
                                File saveFile = new File("./excel/");
                                if (!saveFile.exists()) {
                                    saveFile.mkdirs();
                                }
                                FileOutputStream fos = new FileOutputStream(saveFile.getPath() + fileName);
                                System.out.println("导出文件位于" + saveFile.getAbsolutePath() + fileName);
                                workbook.write(fos);
                                workbook.close();
                                fos.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println(execute1.message());
                        }
                    } else if (judge == 4) {
                        System.out.println("退出程序");
                        System.exit(0);
                    }
                } else {
                    System.out.println("登录失败:" + execute.errorBody().string());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("登录信息有误");
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
            case "4":
                return 4;
            default:
                return judge(chooseFun());
        }
    }

    private static String chooseFun() {
        System.out.println("请选择输入功能代码(数字1或者2)后回车：\n\t1、【导出追溯码关联关系excel】");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String code = scanner.next();
            return code;
        }
        return "-1";
    }


    public Map<String, String> acceptAccountInfo() {
        Map<String, String> map = new HashMap<>();
        System.out.println("请输入系统代码,输入完毕后回车");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String code = scanner.next();
            map.put("code", code);
        }
        System.out.println("请输入账号,输入完毕后回车");
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

    public String acceptParentCode() {
        System.out.println("请输入父级追溯码,输入完毕后回车");
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

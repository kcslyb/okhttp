package com.example.example.trace;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author kcs
 * @date 2019-10-08 20:51
 **/
public interface TestService {
    /**
     * login
     * @param loginDto 请求实体
     * @return 请求结果
     */
    @POST("login")
    Call<Object> login(@Body LoginDto loginDto);

    /**
     * 更新运单状态
     * @return 请求结果
     */
    @GET("3pl-code/SO71010019100003/trace-code/list?pageNo=1&pageSize=10&type=1&sourceOrgId=XUcLvOJwmT7ZTVFiM32&directOrgId=FO7CWJLpqNsN4wbdWcf")
    Call<Object> getTraceCode();
}

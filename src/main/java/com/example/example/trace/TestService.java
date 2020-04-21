package com.example.example.trace;

import retrofit2.Call;
import retrofit2.http.*;

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
     * 关联追溯码
     * orderNo orderNo
     * @return 请求结果
     */
    @GET("3pl-code/trace-code/list?pageNo=1&pageSize=100000")
    Call<CodeListDto> getTraceCode(@Query("orderNo")String orderNo);

    /**
     * 复核追溯码
     * orderNo orderNo
     * @return 请求结果
     */
    @GET("3pl-code/trace-code?pageNo=1&pageSize=100000")
    Call<PageResponse<CodePackageDto>> getTraceCode2(@Query("orderNo")String orderNo);
}

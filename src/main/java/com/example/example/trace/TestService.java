package com.example.example.trace;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
    @GET("3pl-code/{orderNo}/trace-code/list")
    Call<CodeListDto> getTraceCode(@Path("orderNo")String orderNo);

    /**
     * 复核追溯码
     * orderNo orderNo
     * @return 请求结果
     */
    @GET("3pl-code/{orderNo}/trace-code?pageNo=1&pageSize=10000&type=1")
    Call<PageResponse<CodePackageDto>> getTraceCode2(@Path("orderNo")String orderNo);
}

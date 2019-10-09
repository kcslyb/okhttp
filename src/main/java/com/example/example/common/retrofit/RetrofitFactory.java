package com.example.example.common.retrofit;


import com.example.example.common.util.Constant;
import com.example.example.common.util.OkHttpUtil;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author kcs
 * @date 2019-09-20 22:37
 **/
public class RetrofitFactory {
    public static <T>T getRetrofitHelper(Class T) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.apiUrl)
                .client(OkHttpUtil.getInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return (T) retrofit.create(T);
    }
}

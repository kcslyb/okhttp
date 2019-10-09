package com.example.example.common.retrofit;


import com.example.example.common.util.Constant;
import com.example.example.common.util.OkHttpUtil;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Date;

/**
 * @author kcs
 * @date 2019-09-20 22:37
 **/
public class RetrofitFactory {
    public static <T>T getRetrofitHelper(Class T) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.apiUrl)
                .client(OkHttpUtil.getInstance())
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();
        return (T) retrofit.create(T);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.pi.esd.retrofit.utils;

import com.ng.emts.pi.esd.retrofit.demo.RedditService;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 *
 * @author babatunde.adeyemi
 */
public class APIUtils {
    public static final String BASE_URL = "https://www.reddit.com";
    
    public static RedditService getRedditService() {
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                                        .build();
        
        return retrofit.create(RedditService.class);
    }
}

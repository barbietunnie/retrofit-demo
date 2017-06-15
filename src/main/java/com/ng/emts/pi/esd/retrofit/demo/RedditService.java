/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.pi.esd.retrofit.demo;

import com.ng.emts.pi.esd.retrofit.data.RedditRequest;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author babatunde.adeyemi
 */
public interface RedditService {
    @GET("/r/gifs/top/.json?limit=10&sort=hot")
    Call<RedditRequest> getTopGifs();
}

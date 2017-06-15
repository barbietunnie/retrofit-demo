/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ng.emts.pi.esd.retrofit.demo;

import com.ng.emts.pi.esd.retrofit.data.RedditRequest;
import com.ng.emts.pi.esd.retrofit.utils.APIUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author babatunde.adeyemi
 */
public class Main {

    public static void main(String[] args) {
        RedditService service = APIUtils.getRedditService();

        // Synchronous call
        makeSynchronousRequest();

        // Asynchronous call
//        makeAsynchronousRequest();
    }

    private static void makeSynchronousRequest() {
        try {
            RedditService service = APIUtils.getRedditService();
            Response<RedditRequest> response = service.getTopGifs().execute();
            RedditRequest data = response.body();

            int statusCode = response.code();

            System.out.println("Status code: " + statusCode + ", Kind: " + data.getKind());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void makeAsynchronousRequest() {
        RedditService service = APIUtils.getRedditService();
        service.getTopGifs().enqueue(new Callback<RedditRequest>() {
            @Override
            public void onResponse(Call<RedditRequest> call, Response<RedditRequest> response) {
                int statusCode = response.code();
                RedditRequest data = response.body();

                System.out.println("Status code: " + statusCode + ", Kind: " + data.getKind());
            }

            @Override
            public void onFailure(Call<RedditRequest> call, Throwable thrwbl) {
                thrwbl.printStackTrace();
            }
        });
    }

}

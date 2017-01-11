package com.example.service;

import com.example.entities.SimSimiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jerry on 2017/1/11.
 */
public interface SimSimiService {

    /**
     * @param msg bot response message
     * @return SimSimiResponse {@link SimSimiResponse}
     * @see <a href="http://developer.simsimi.com/api">http://developer.simsimi.com/api</a>
     */
    @GET("request.p")
    Call<SimSimiResponse> chat(@Query("text") String msg);
}

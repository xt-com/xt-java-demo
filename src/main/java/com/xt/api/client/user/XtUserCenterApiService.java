package com.xt.api.client.user;

import com.xt.api.dto.CommonResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtUserCenterApiService {

    @GET("/v4/referal/invite/statistics")
    Call<CommonResponse> getUserStatistics(@Query("uid") String uid,@Query("startTime") String startTime,
                                           @Query("endTime") String endTime);
}

package com.xt.api.client.user;

import com.xt.api.dto.CommonResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * @author zhouzhuang
 * @create 2023/9/20 14:28
 */
public interface XtUserCenterApiService {

    @GET("/v4/referal/invite/statistics")
    Call<CommonResponse> getUserStatistics(@Query("uid") String uid,@Query("startTime") String startTime,
                                           @Query("endTime") String endTime);


    @GET("/v4/referal/invite/single/user/info")
    Call<CommonResponse> getUserInfo(@Query("uid") Long uid);

    @GET("/v4/referal/multi/single/user/info")
    Call<CommonResponse> getBatchUserInfo(@Query("uidList") List<Long> uidList, @Query("pageNum") Integer pageNum, @Query("pageSize") Integer pageSize);
}

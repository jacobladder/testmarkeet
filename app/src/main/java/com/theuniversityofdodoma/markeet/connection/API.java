package com.theuniversityofdodoma.markeet.connection;

import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackCategory;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackDevice;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackFeaturedNews;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackInfo;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackNewsInfo;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackNewsInfoDetails;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackOrder;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackProduct;
import com.theuniversityofdodoma.markeet.connection.callbacks.CallbackProductDetails;
import com.theuniversityofdodoma.markeet.data.Constant;
import com.theuniversityofdodoma.markeet.model.Checkout;
import com.theuniversityofdodoma.markeet.model.DeviceInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    String CACHE = "Cache-Control: max-age=0";
    String AGENT = "User-Agent: Markeet";
    String SECURITY = "Security: " + Constant.SECURITY_CODE;

    /* Recipe API transaction ------------------------------- */

    @Headers({CACHE, AGENT})
    @GET("services/info")
    Call<CallbackInfo> getInfo(
            @Query("version") int version
    );

    /* Fcm API ----------------------------------------------------------- */
    @Headers({CACHE, AGENT, SECURITY})
    @POST("services/insertOneFcm")
    Call<CallbackDevice> registerDevice(
            @Body DeviceInfo deviceInfo
    );

    /* News Info API ---------------------------------------------------- */

    @Headers({CACHE, AGENT})
    @GET("services/listFeaturedNews")
    Call<CallbackFeaturedNews> getFeaturedNews();

    @Headers({CACHE, AGENT})
    @GET("services/listNews")
    Call<CallbackNewsInfo> getListNewsInfo(
            @Query("page") int page,
            @Query("count") int count,
            @Query("q") String query
    );

    @Headers({CACHE, AGENT})
    @GET("services/getNewsDetails")
    Call<CallbackNewsInfoDetails> getNewsDetails(
            @Query("id") long id
    );

    /* Category API ---------------------------------------------------  */
    @Headers({CACHE, AGENT})
    @GET("services/listCategory")
    Call<CallbackCategory> getListCategory();


    /* Product API ---------------------------------------------------- */

    @Headers({CACHE, AGENT})
    @GET("services/listProduct")
    Call<CallbackProduct> getListProduct(
            @Query("page") int page,
            @Query("count") int count,
            @Query("q") String query,
            @Query("category_id") long category_id
    );

    @Headers({CACHE, AGENT})
    @GET("services/getProductDetails")
    Call<CallbackProductDetails> getProductDetails(
            @Query("id") long id
    );

    /* Checkout API ---------------------------------------------------- */
    @Headers({CACHE, AGENT, SECURITY})
    @POST("services/submitProductOrder")
    Call<CallbackOrder> submitProductOrder(
            @Body Checkout checkout
    );

}

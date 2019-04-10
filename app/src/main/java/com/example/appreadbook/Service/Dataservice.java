package com.example.appreadbook.Service;

import com.example.appreadbook.Model.CHUONG;
import com.example.appreadbook.Model.NOIDUNG;
import com.example.appreadbook.Model.TRUYEN;

import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    //Lấy các Truyen
    @GET("GETTRUYEN.php")
    Call<List<TRUYEN>> GETTRUYEN();

    //Lấy các Truyen moi
    @GET("GETTRUYENMOI.php")
    Call<List<TRUYEN>> GETTRUYENMOI();


    //Lấy Truyen theo id
    @FormUrlEncoded
    @POST("GETTRUYENBYID.php")
    Call<TRUYEN> GETTRUYENBYID(@Field("ID") int ID);


    //Lấy Truyen theo id thể loại
    @FormUrlEncoded
    @POST("GETTRUYENBYIDTL.php")
    Call<List<TRUYEN>> GETTRUYENBYIDTL(@Field("IDTHELOAI") int IDTHELOAI);


    //Lấy chuong theo id truyen
    @FormUrlEncoded
    @POST("GETCHUONGTHEOID.php")
    Call<List<CHUONG>> GETCHUONGTHEOID(@Field("ID") int ID);

    //Lấy id chuong theo id truyen
    @FormUrlEncoded
    @POST("GETARRIDCHUONGBYIDTR.php")
    Call<List<Integer>> GETARRIDCHUONGBYIDTR(@Field("ID") int ID);

    //Lấy các Truyen
    @FormUrlEncoded
    @POST("NOIDUNG.php")
    Call<List<NOIDUNG>> GETNOIDUNG(@Field("IDCHUONG") int IDCHUONG);

    //Lấy thể loại của truyển thông qua id
    @FormUrlEncoded
    @POST("GETTTNDBYIDTRUYENBY.php")
    Call<TRUYEN> GETTTNDBYIDTRUYENBY(@Field("ID") int ID);
}
package com.example.m.smtf;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RemoteService {

    @GET("/flim_detail")//해당 url로 갔을때 [{p_name:"", p_price:"", p_description:"", p_subclass:"", p_category:"", p_origin:"", p_picture:"", p_link:""}] 식의 데이터를 가져온다는걸 알 수 있음
    Call <List<FilmDetail>> getFlimDetail();//다른 조건사항이 없으니 응답받은 위와 같은 데이터를 아래 제네릭 표현의 Call객체로 저장시킴

    @GET("/daily_boxoffice")//해당 url로 갔을때 [{p_name:"", p_price:"", p_description:"", p_subclass:"", p_category:"", p_origin:"", p_picture:"", p_link:""}] 식의 데이터를 가져온다는걸 알 수 있음
    Call <List<DailyBoxoffice>> getDailyBoxoffice();

    @GET("/weekly_boxoffice")
    Call<List<WeeklyBoxoffice>> getWeeklyBoxoffice();
//
//    @GET("/subclass/{p_subclass}")//해당 url로 갔을때 [{p_name:"", p_price:"", p_description:"", p_subclass:"", p_category:"", p_origin:"", p_picture:"", p_link:""}] 식의 데이터를 가져온다는걸 알 수 있음
//    Call <List<product>> getSubclass(@Path("p_subclass") String p_subclass);

    /*
    <> : 제네릭표현
    http://arabiannight.tistory.com/entry/%EC%9E%90%EB%B0%94Java-ArrayListT-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4Generics%EB%9E%80 참조
    Call <Product> 이면 Product와 동일한 형태를 갖는(아마, Product.java와 동일한 자료형, 메소드를 갖는)
    [{p_name:"", p_price:"", p_description:"", p_subclass:"", p_category:"", p_origin:"", p_picture:"", p_link:""}]Call 객체를 생성
    Call <List<product>>이면 List<Product>와 동일한 형태를 갖는(현재 Product는 7개의 변수를 갖고 있고 그거의 리스트 형태이면 대략 이런식
    [{p_name:"", p_price:"", p_description:"", p_subclass:"", p_category:"", p_origin:"", p_picture:"", p_link:""},
    {p_name:"", p_price:"", p_description:"", p_subclass:"", p_category:"", p_origin:"", p_picture:"", p_link:""},
    {p_name:"", p_price:"", p_description:"", p_subclass:"", p_category:"", p_origin:"", p_picture:"", p_link:""},
    ...] 이런식의 product의 리스트 형태를 갖을 수 있는 Call 객체를 생성
     */




}
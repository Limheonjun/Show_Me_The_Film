package com.example.m.smtf;

public class DailyBoxoffice {
    String movieNm;             //영화명
    String openDt;              //영화 개봉일
    String salesAmt;            //오늘 매출액
    String audiCnt;             //오늘 관객수
    String date;                //박스오피스 조회일자
    String rank;                //오늘 박스오피스 순위
    String rankOldAndNew;      //랭킹 신규진입여부
    String audiAcc;             //누적관객수
    String repNationNm;
    String repGenreNm;

    public String getRepNationNm() {
        return repNationNm;
    }

    public void setRepNationNm(String repNationNm) {
        this.repNationNm = repNationNm;
    }

    public String getRepGenreNm() {
        return repGenreNm;
    }

    public void setRepGenreNm(String repGenreNm) {
        this.repGenreNm = repGenreNm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankOldAndNew() {
        return rankOldAndNew;
    }

    public void setRankOldAndNew(String rankOldAndNew) {
        this.rankOldAndNew = rankOldAndNew;
    }

    public String getAudiAcc() {
        return audiAcc;
    }

    public void setAudiAcc(String audiAcc) {
        this.audiAcc = audiAcc;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getSalesAmt() {
        return salesAmt;
    }

    public void setSalesAmt(String salesAmt) {
        this.salesAmt = salesAmt;
    }

    public String getAudiCnt() {
        return audiCnt;
    }

    public void setAudiCnt(String audiCnt) {
        this.audiCnt = audiCnt;
    }
}

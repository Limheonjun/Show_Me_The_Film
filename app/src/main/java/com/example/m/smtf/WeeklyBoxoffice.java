package com.example.m.smtf;

public class WeeklyBoxoffice {
    String movieNm; //영화제목
    String openDt; // 영화개봉일
    String salesAmt; //해당일 매출액
    String audiCnt; // 해당일 관객수
    String date;
    String rank; // 랭킹
    String rankOldAndNew; //랭킹신규진입여부
    String audiAcc; // 누적관객수

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
}

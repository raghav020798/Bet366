package com.example.raghav.bet366;

/**
 * Created by Raghav on 01-11-2017.
 */

public class Schedule {

    private int mHomeImgResId = NO_IMAGE_PROVIDED ;
    private int mAwayImgResId = NO_IMAGE_PROVIDED ;
    private String mAwayTeamName;
    private String mHomeTeamName;
    private String mDate;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Schedule(String HomeTeamName, String AwayTeamName, String Date, int HomeImgResId, int AwayImgResId){
        mHomeTeamName = HomeTeamName;
        mAwayTeamName = AwayTeamName;
        mDate = Date;
        mHomeImgResId = HomeImgResId;
        mAwayImgResId = AwayImgResId;
    }

    String getmAwayTeamName(){
        return mAwayTeamName;
    }
    String getmHomeTeamName(){
        return mHomeTeamName;
    }
    String getmDate(){
        return mDate;
    }
    int getmHomeImgResId(){
        return mHomeImgResId;
    }
    int getmAwayImgResId(){
        return mAwayImgResId;
    }
    public boolean hasHomeImage() {
        return mHomeImgResId != NO_IMAGE_PROVIDED;
    }
    public boolean hasAwayImage() {
        return mAwayImgResId != NO_IMAGE_PROVIDED;
    }

}

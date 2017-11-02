package com.example.raghav.bet366;

/**
 * Created by Raghav on 30-10-2017.
 */

public class Leagues  {
    private String mLeagueName;
    private String mLeagueRegion;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Leagues(String LeagueName, String LeagueRegion, int imageResourceId){
        mLeagueName = LeagueName;
        mLeagueRegion = LeagueRegion;
        mImageResourceId = imageResourceId;
    }

   public String getmLeagueName(){
       return mLeagueName;
   }

   public String getmLeagueRegion(){
       return mLeagueRegion;
   }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}

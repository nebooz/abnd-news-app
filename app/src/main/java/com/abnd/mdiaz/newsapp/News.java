package com.abnd.mdiaz.newsapp;

import android.graphics.Bitmap;

/**
 * Created by neboo on 11-Aug-16.
 */
public class News {
    private String mTitle;
    private String mSection;
    private String mAuthor;
    private String mDate;
    private String mTrailText;
    private String mUrl;
    private Bitmap mThumbnail;

    public News(String title, String section, String author, String date, String trailText, String url, Bitmap thumbnail) {
        mTitle = title;
        mSection = section;
        mAuthor = author;
        mDate = date;
        mTrailText = trailText;
        mUrl = url;
        mThumbnail = thumbnail;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDate() {
        return mDate;
    }

    public String getTrailText() {
        return mTrailText;
    }

    public String getUrl(){
        return mUrl;
    }

    public Bitmap getThumbnail(){
        return mThumbnail;
    }

}

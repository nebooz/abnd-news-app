package com.abnd.mdiaz.newsapp;

/**
 * Created by neboo on 11-Aug-16.
 */
public class News {
    private String mTitle;
    private String mSection;
    private String mDate;
    private String mUrl;

    public News(String title, String section, String date, String url) {
        mTitle = title;
        mSection = section;
        mDate = date;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl(){
        return mUrl;
    }

}

package com.abnd.mdiaz.newsapp;

import android.graphics.Bitmap;

/**
 * Created by neboo on 11-Aug-16.
 */
public class News {
    private String mTitle;
    private String mAuthors;
    private String mDescription;
    private Bitmap mImage;

    public News(String title, String authors, String description, Bitmap image) {
        mTitle = title;
        mAuthors = authors;
        mDescription = description;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthors() {
        return mAuthors;
    }

    public String getDescription() {
        return mDescription;
    }

    public Bitmap getImage() {
        return mImage;
    }

}

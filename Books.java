package com.nitharshanaan.bookshelf;

/**
 * Created by nitha on 4/18/2017.
 */

public class Books {

    private String mTitle;

    private String mAuthor;

    private String mImage;

    private String mPublisher;

    public Books(String mTitle, String mAuthor, String mImage, String mPublisher) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mImage = mImage;
        this.mPublisher = mPublisher;
    }

    public String getmTitle() {
        return mTitle;
    }


    public String getmAuthor() {
        return mAuthor;
    }


    public String getmImage() {
        return mImage;
    }


    public String getmPublisher() {
        return mPublisher;
    }


}

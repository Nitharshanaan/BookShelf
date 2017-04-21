package com.nitharshanaan.bookshelf;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nitha on 4/18/2017.
 */

public class Books implements Parcelable {

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



    protected Books(Parcel in) {
        mTitle = in.readString();
        mAuthor = in.readString();
        mImage = in.readString();
        mPublisher = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mAuthor);
        dest.writeString(mImage);
        dest.writeString(mPublisher);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Books> CREATOR = new Parcelable.Creator<Books>() {
        @Override
        public Books createFromParcel(Parcel in) {
            return new Books(in);
        }

        @Override
        public Books[] newArray(int size) {
            return new Books[size];
        }
    };
}
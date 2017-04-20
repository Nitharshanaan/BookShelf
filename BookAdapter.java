package com.nitharshanaan.bookshelf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by nitha on 4/19/2017.
 */

public class BookAdapter extends ArrayAdapter<Books> {

    public BookAdapter(Activity context, ArrayList<Books> booksArrayList) {
        super(context, 0, booksArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Books books = getItem(position);

        TextView titleLayout = (TextView) convertView.findViewById(R.id.title);

        String title = books.getmTitle();

        titleLayout.setText(title);

        TextView authorLayout = (TextView) convertView.findViewById(R.id.authors);

        String author = books.getmAuthor();

        authorLayout.setText(author);

        TextView publishersLayout = (TextView) convertView.findViewById(R.id.publisher);

        String publisher = books.getmPublisher();

        publishersLayout.setText(publisher);

        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        new DownloadImageTask(image).execute(books.getmImage());

//        TextView imageLayout = (TextView) convertView.findViewById(R.id.image);
//
//        String image = books.getmImage();
//
//        publishersLayout.setText(image);

        return convertView;

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urlDisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }
}

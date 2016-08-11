package com.abnd.mdiaz.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, ArrayList<News> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_layout, parent, false);
        }

        News news = getItem(position);

        ImageView bookImage = (ImageView) listItemView.findViewById(R.id.book_image);

        if (news.getImage() == null) {
            bookImage.setImageResource(R.drawable.no_image);
        } else {
            bookImage.setImageBitmap(news.getImage());
        }

        TextView titleText = (TextView) listItemView.findViewById(R.id.title_text);
        titleText.setText(news.getTitle());

        TextView authorsText = (TextView) listItemView.findViewById(R.id.authors_text);
        authorsText.setText(news.getAuthors());

        TextView descriptionText = (TextView) listItemView.findViewById(R.id.description_text);
        descriptionText.setText(news.getDescription());

        return listItemView;

    }

}

package com.abnd.mdiaz.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        TextView titleText = (TextView) listItemView.findViewById(R.id.title_text);
        titleText.setText(news.getTitle());

        TextView sectionText = (TextView) listItemView.findViewById(R.id.section_text);
        sectionText.setText(news.getSection());

        TextView dateText = (TextView) listItemView.findViewById(R.id.date_text);
        dateText.setText(news.getDate());

        return listItemView;

    }

}

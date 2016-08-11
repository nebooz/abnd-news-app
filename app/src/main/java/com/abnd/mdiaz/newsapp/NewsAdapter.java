package com.abnd.mdiaz.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> mNewsList = new ArrayList<>();

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
        mNewsList = news;
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
        dateText.setText(formatDate(news.getDate()));

        return listItemView;

    }

    private String formatDate(String date) {

        SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat dateOutput = new SimpleDateFormat("LLL dd, yyyy - h:mm a");
        String dateReturn = null;
        try {
            dateReturn = dateOutput.format(dateInput.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateReturn;

    }

    public void setNewsList(List<News> newsList) {

        mNewsList.addAll(newsList);
        notifyDataSetChanged();

    }

}

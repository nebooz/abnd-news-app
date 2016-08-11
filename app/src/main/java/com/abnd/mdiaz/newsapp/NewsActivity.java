package com.abnd.mdiaz.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final String TARGET_URL =
            "http://content.guardianapis.com/search?tag=technology%2Fgames&from-date=2016-01-01&order-by=newest&page-size=20&api-key=test";
    private NewsAdapter mAdapter;
    private ListView mNewsListView;
    private TextView mEmptyStateTextView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mAdapter = new NewsAdapter(NewsActivity.this, new ArrayList<News>());
        mNewsListView = (ListView) findViewById(R.id.list);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        mProgressBar = (ProgressBar) findViewById(R.id.loading_spinner);

        mNewsListView.setEmptyView(mEmptyStateTextView);

        mNewsListView.setAdapter(mAdapter);

        checkConnectivity();

        mNewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News currentNews = mAdapter.getItem(position);
                Uri uri = Uri.parse(currentNews.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    private void checkConnectivity() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            getSupportLoaderManager().initLoader(0, null, this);

        } else {

            mEmptyStateTextView.setText(R.string.no_internet);
            mProgressBar.setVisibility(View.GONE);

        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new NewsLoader(NewsActivity.this, TARGET_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {

        mEmptyStateTextView.setText(R.string.no_earthquakes);

        mProgressBar.setVisibility(View.GONE);

        mAdapter.clear();
        mAdapter.setNewsList(data);

    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

        mAdapter.setNewsList(new ArrayList<News>());

    }
}

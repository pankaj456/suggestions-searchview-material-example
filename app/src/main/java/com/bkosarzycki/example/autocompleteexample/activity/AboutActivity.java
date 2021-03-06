package com.bkosarzycki.example.autocompleteexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bkosarzycki.example.autocompleteexample.AutoCompleteApp;
import com.bkosarzycki.example.autocompleteexample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.activity_about_repo_address) TextView mRepoAddressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        AutoCompleteApp.getApp(this).getDaggerMainComponent().inject(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("AutoComplete example");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.fab)
    public void fabClick(View view) {
        String addr = mRepoAddressTextView.getText().toString();
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(addr));
        startActivity(myIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    public static void start(Activity activity) {
        Intent myIntent = new Intent(activity, AboutActivity.class);
        activity.startActivity(myIntent);
    }
}

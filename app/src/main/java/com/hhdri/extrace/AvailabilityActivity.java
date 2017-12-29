package com.hhdri.extrace;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import java.util.List;


public class AvailabilityActivity extends AppCompatActivity {

    Context CONTEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CONTEXT = this;
        new DownloadPriceTask().execute("https://www.exchanging.ir/prices.xml");
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private class DownloadPriceTask extends AsyncTask<String, Void, List<EMoney>> {
        @Override
        protected List<EMoney> doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                PriceTable priceTable = new PriceTable(connection.getInputStream());
                return priceTable.geteMonies();
            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(List<EMoney> list){
            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.reserves_list);
            EMoneyAdapter eMoneyAdapter = new EMoneyAdapter(CONTEXT, list);
            recyclerView.setAdapter(eMoneyAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(CONTEXT));
        }
    }
}

package com.landsoft.demoasycntask;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by TRANTUAN on 28-Nov-17.
 */

public class Download extends AsyncTask<Integer,Integer,String> {
    ProgressBar progressBar;
    TextView tvStatus;
    int count = 0;

    public Download(ProgressBar progressBar, TextView tvStatus) {
        this.progressBar = progressBar;
        this.tvStatus = tvStatus;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setProgress(0);
        progressBar.setMax(1000);
        progressBar.setVisibility(View.VISIBLE);
        tvStatus.setVisibility(View.VISIBLE);
        tvStatus.setText("dang ngu");
    }

    @Override
    protected String doInBackground(Integer... integers) {
        int thamSoTruyenVao = integers[0];
        for (; count <= thamSoTruyenVao; count++){
            try {
                Thread.sleep(1000);
                publishProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Da download thanh cong";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int thamSoNhanDoIn = values[0];
        progressBar.setProgress(thamSoNhanDoIn*100);
        Log.d("progressUpdate", "onProgressUpdate: " +thamSoNhanDoIn );
        tvStatus.setText("downloading .." + thamSoNhanDoIn);
    }

    @Override
    protected void onPostExecute(String s) {
       tvStatus.setText(s);
        progressBar.setVisibility(View.GONE);
    }
}

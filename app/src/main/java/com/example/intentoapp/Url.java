package com.example.intentoapp;

import android.os.AsyncTask;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

public class Url extends AsyncTask<String, Void, Boolean> {

    int numero;

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Boolean doInBackground(String... params) {
        this.numero = 5;

        try{
            final URL url = new URL("https://github.com/esteban1810/IntentoApp/raw/main/inteoapp.apk");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("HEAD");
            int responseCode = huc.getResponseCode();

            if (responseCode != 404) {
                System.out.println("GOOD");
                return true;
            } else {
                System.out.println("BAD");
                return false;
            }
        } catch (Exception e){
            System.out.println("NADA");
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        boolean bResponse = result;
        if (bResponse==true){
            System.out.println("Exito");
        }else{
            System.out.println("F");
        }
    }
}
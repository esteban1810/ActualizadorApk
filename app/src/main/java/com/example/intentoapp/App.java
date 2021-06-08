package com.example.intentoapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import net.mftd313.updatelibrary.UpdateLibrary;
import net.mftd313.updatelibrary.listeners.UpdateDownloadStartedListener;
import net.mftd313.updatelibrary.listeners.UpdateInstallStartedListener;
import net.mftd313.updatelibrary.listeners.UpdateReadyToDownloadListener;
import net.mftd313.updatelibrary.listeners.UpdateReadyToInstallListener;

import java.net.HttpURLConnection;
import java.net.URL;

public class App extends AsyncTask<String, Void, String> {
    String cadena = "Pedro";

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... params) {
        String base = "https://github.com/esteban1810/IntentoApp/raw/main/intentoapp_";
        String direccion;
        for(int x=1;x<10;x++){
            for(int y=0;y<10;y++){
                for(int z=0;z<10;z++){
                    direccion = base+x+"_"+y+"_"+z+".apk";
                    try{
//                        final URL url = new URL("https://github.com/esteban1810/IntentoApp/raw/main/intentoapp.apk");
                        final URL url = new URL(direccion);
                        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                        huc.setRequestMethod("HEAD");
                        int responseCode = huc.getResponseCode();

                        if (responseCode != 404) {
                            System.out.println("GOOD");
                            return direccion;
                        } else {
                            System.out.println("BAD");
                            continue;
                        }
                    } catch (Exception e){
                        System.out.println("NADA");
                        continue;
                    }
                }
            }
        }
        return  "F";
    }

    @Override
    protected void onPostExecute(String result) {
//        cadena = " Gutierrez";
//        boolean bResponse = true;
//        if (bResponse==true){
//            System.out.println("Exito");
//        }else{
//            System.out.println("F");
//        }

//        String url = this.getUrlCompuesta();
//        String url = result;
//        System.out.println("truena");
//
////        final ProgressDialog progressDialog = new ProgressDialog(Actualizar.this);
//        final ProgressDialog progressDialog = new ProgressDialog(Actualizar.this);
//
//        System.out.println("truena");
////        UpdateLibrary.with(Actualizar.this)
//        UpdateLibrary.with(Actualizar.this)
//
//                // while downloading notification
//                .setDownloadingNotificationTitle(getString(R.string.app_name))
//                .setDownloadingNotificationText(getString(R.string.downloading_new_version))
//
//                // before installing notification
//                .setDownloadedNotificationSmallIconResource(R.mipmap.ic_launcher)
//                .setDownloadedNotificationLargeIconResource(R.mipmap.ic_launcher)
//                .setDownloadedNotificationTitle(getString(R.string.app_name))
//                .setDownloadedNotificationText(getString(R.string.download_completed))
//
//                .setUpdateReadyToDownloadListener(new UpdateReadyToDownloadListener() {
//                    @Override
//                    public void onReadyToDownload(final Context context, Uri uri) {
//                        UpdateLibrary.getUpdateManager().download(context);
//                        progressDialog.hide();
//                    }
//                })
//                .setUpdateDownloadStartedListener(new UpdateDownloadStartedListener() {
//                    @Override
//                    public void onDownloadStarted(Context context, Uri uri) {
//                        progressDialog.setMessage(getString(R.string.downloading_new_version));
//                        progressDialog.show();
//                    }
//                })
//
////                .setUpdateDownloadFailedListener(new UpdateDownloadFailedListener() {
////                    @Override
////                    public void onDownloadFailed(Context context, Uri uri) {
////                        progressDialog.hide();
////                        Snackbar.make(fab, getString(R.string.download_failed), Snackbar.LENGTH_LONG)
////                                .show();
////                        fab.show();
////                    }
////                })
//
//                .setUpdateReadyToInstallListener(new UpdateReadyToInstallListener() {
//                    @Override
//                    public void onReadyToInstall(final Context context, Uri uri) {
//                        UpdateLibrary.getUpdateManager().install(context);
//                        progressDialog.hide();
//                    }
//                })
//                .setUpdateInstallStartedListener(new UpdateInstallStartedListener() {
//                    @Override
//                    public void onInstallStarted(Context context, Uri uri) {
//                        progressDialog.setMessage(getString(R.string.installing_new_version));
//                        progressDialog.show();
//                    }
//                })
//
//                .init(Uri.parse(url));
    }
}

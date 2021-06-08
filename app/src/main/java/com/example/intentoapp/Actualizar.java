package com.example.intentoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.mftd313.updatelibrary.UpdateLibrary;
import net.mftd313.updatelibrary.listeners.UpdateDownloadStartedListener;
import net.mftd313.updatelibrary.listeners.UpdateInstallStartedListener;
import net.mftd313.updatelibrary.listeners.UpdateReadyToDownloadListener;
import net.mftd313.updatelibrary.listeners.UpdateReadyToInstallListener;

import java.io.File;

public class Actualizar extends AppCompatActivity {

    MainActivity main;
    String url;
    String nombreApk;

    public Actualizar(MainActivity mainActivity){
        this();
        this.main = mainActivity;
    }

    public Actualizar(){
        this.url = "https://github.com/esteban1810/IntentoApp/raw/main/";
        this.nombreApk = "intentoapp.apk";
    }

    public void setUrl(String path){
        this.url = path;
    }

    public void setNombreApk(String nombreApk){
        this.nombreApk=nombreApk+".apk";
    }

    public void borrarNombreApk(){
        this.nombreApk="";
    }

    public String getUrlCompuesta(){
        return this.url+this.nombreApk;
    }

    public void actualizar(){
        String url = this.getUrlCompuesta();
        System.out.println("truena");

        final ProgressDialog progressDialog = new ProgressDialog(Actualizar.this);

        System.out.println("truena");
        UpdateLibrary.with(Actualizar.this)

                // while downloading notification
                .setDownloadingNotificationTitle(getString(R.string.app_name))
                .setDownloadingNotificationText(getString(R.string.downloading_new_version))

                // before installing notification
                .setDownloadedNotificationSmallIconResource(R.mipmap.ic_launcher)
                .setDownloadedNotificationLargeIconResource(R.mipmap.ic_launcher)
                .setDownloadedNotificationTitle(getString(R.string.app_name))
                .setDownloadedNotificationText(getString(R.string.download_completed))

                .setUpdateReadyToDownloadListener(new UpdateReadyToDownloadListener() {
                    @Override
                    public void onReadyToDownload(final Context context, Uri uri) {
                        UpdateLibrary.getUpdateManager().download(context);
                        progressDialog.hide();
                    }
                })
                .setUpdateDownloadStartedListener(new UpdateDownloadStartedListener() {
                    @Override
                    public void onDownloadStarted(Context context, Uri uri) {
                        progressDialog.setMessage(getString(R.string.downloading_new_version));
                        progressDialog.show();
                    }
                })

//                .setUpdateDownloadFailedListener(new UpdateDownloadFailedListener() {
//                    @Override
//                    public void onDownloadFailed(Context context, Uri uri) {
//                        progressDialog.hide();
//                        Snackbar.make(fab, getString(R.string.download_failed), Snackbar.LENGTH_LONG)
//                                .show();
//                        fab.show();
//                    }
//                })

                .setUpdateReadyToInstallListener(new UpdateReadyToInstallListener() {
                    @Override
                    public void onReadyToInstall(final Context context, Uri uri) {
                        UpdateLibrary.getUpdateManager().install(context);
                        progressDialog.hide();
                    }
                })
                .setUpdateInstallStartedListener(new UpdateInstallStartedListener() {
                    @Override
                    public void onInstallStarted(Context context, Uri uri) {
                        progressDialog.setMessage(getString(R.string.installing_new_version));
                        progressDialog.show();
                    }
                })

                .init(Uri.parse(url));
    }
}

/*
package com.example.intentoapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.ActivityManager;
        import android.app.ProgressDialog;
        import android.content.Context;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import net.mftd313.updatelibrary.UpdateLibrary;
        import net.mftd313.updatelibrary.listeners.UpdateDownloadStartedListener;
        import net.mftd313.updatelibrary.listeners.UpdateInstallStartedListener;
        import net.mftd313.updatelibrary.listeners.UpdateReadyToDownloadListener;
        import net.mftd313.updatelibrary.listeners.UpdateReadyToInstallListener;

        import org.w3c.dom.Text;

        import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        String path = getFilesDir()+"/intentoapp.apk";
        getExternalFilesDir(getFilesDir().getAbsolutePath());
        File arch = new File(path);
        tv.setText(arch.exists()+"");
    }



    public void actualizar(String nombreApk){
        String url = "https://github.com/esteban1810/IntentoApp/raw/main/"+nombreApk+".apk";

        final ProgressDialog progressDialog = new ProgressDialog(this);

        UpdateLibrary.with(MainActivity.this)

                // while downloading notification
                .setDownloadingNotificationTitle(getString(R.string.app_name))
                .setDownloadingNotificationText(getString(R.string.downloading_new_version))

                // before installing notification
                .setDownloadedNotificationSmallIconResource(R.mipmap.ic_launcher)
                .setDownloadedNotificationLargeIconResource(R.mipmap.ic_launcher)
                .setDownloadedNotificationTitle(getString(R.string.app_name))
                .setDownloadedNotificationText(getString(R.string.download_completed))

                .setUpdateReadyToDownloadListener(new UpdateReadyToDownloadListener() {
                    @Override
                    public void onReadyToDownload(final Context context, Uri uri) {
                        UpdateLibrary.getUpdateManager().download(context);
                        progressDialog.hide();
                    }
                })
                .setUpdateDownloadStartedListener(new UpdateDownloadStartedListener() {
                    @Override
                    public void onDownloadStarted(Context context, Uri uri) {
                        progressDialog.setMessage(getString(R.string.downloading_new_version));
                        progressDialog.show();
                    }
                })

//                .setUpdateDownloadFailedListener(new UpdateDownloadFailedListener() {
//                    @Override
//                    public void onDownloadFailed(Context context, Uri uri) {
//                        progressDialog.hide();
//                        Snackbar.make(fab, getString(R.string.download_failed), Snackbar.LENGTH_LONG)
//                                .show();
//                        fab.show();
//                    }
//                })

                .setUpdateReadyToInstallListener(new UpdateReadyToInstallListener() {
                    @Override
                    public void onReadyToInstall(final Context context, Uri uri) {
                        UpdateLibrary.getUpdateManager().install(context);
                        progressDialog.hide();
                    }
                })
                .setUpdateInstallStartedListener(new UpdateInstallStartedListener() {
                    @Override
                    public void onInstallStarted(Context context, Uri uri) {
                        progressDialog.setMessage(getString(R.string.installing_new_version));
                        progressDialog.show();
                    }
                })

                .init(Uri.parse(url));
    }

    public void actualizacionAut(View view){
        this.actualizar("intentoapp");
    }

    public void actualizacionPorNombre(View view){
        String nombreApk = et.getText().toString().trim();
        actualizar("intentoapp");
    }
}
*/
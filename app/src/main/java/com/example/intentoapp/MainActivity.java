package com.example.intentoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.mftd313.updatelibrary.UpdateLibrary;
import net.mftd313.updatelibrary.listeners.UpdateDownloadStartedListener;
import net.mftd313.updatelibrary.listeners.UpdateInstallStartedListener;
import net.mftd313.updatelibrary.listeners.UpdateReadyToDownloadListener;
import net.mftd313.updatelibrary.listeners.UpdateReadyToInstallListener;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    Button btnAut;
    Button btnNom;
    TextView tv;
    EditText et;
    String x,y,z;
    String url; // Ejemplo: https://github.com/esteban1810/IntentoApp/rax/main
    String nombreApk; // Ejem: intento1_1_1.apk


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        btnAut = (Button)findViewById(R.id.btnAct);
        btnNom = (Button)findViewById(R.id.btnNom);
//        setxyz();
    }


    public void actualizacionAut(View view){
//        btnAut.setEnabled(false);
        btnAut.setActivated(false);
//        Actual act = new Actual(MainActivity.this);
//        setXYZ(tv.getText().toString());
//        act.execute("https://github.com/esteban1810/IntentoApp/raw/main","intentoapp",x,y,z);
//        btnAut.setEnabled(true);
    }

    public void actualizacionPorNombre(View view){
        btnNom.setEnabled(false);
        Actual act = new Actual(MainActivity.this);
        setXYZ(et.getText().toString().trim());
        act.execute("https://github.com/esteban1810/IntentoApp/raw/main","intentoapp_"+x+"_"+y+"_"+z);
        btnNom.setEnabled(true);
    }


    public void setXYZ(String version){
        String xyz[] = version.split("\\.");
        x = xyz[0];
        y = xyz[1];
        z = xyz[2];
    }
}
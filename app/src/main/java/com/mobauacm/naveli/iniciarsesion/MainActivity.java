package com.mobauacm.naveli.iniciarsesion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WebView wv;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView) this.findViewById(R.id.webView);

        if (existeInternet()) {
            wv.loadUrl("http://comedoraba.esy.es/abaadmin/index.php");
        }else {
            showSnackBar("No hay internet. Verifica la conexión a la red.");
        }
    }

    public boolean existeInternet() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.main), msg, Snackbar.LENGTH_LONG)
                .show();
    }
}

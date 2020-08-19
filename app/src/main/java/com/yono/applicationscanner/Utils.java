package com.yono.applicationscanner;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class Utils {

    public void LoadingDialog(Context context, String messsage){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(messsage);
        progressDialog.show();
    }

    public void PesanToast(Context context, int message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}

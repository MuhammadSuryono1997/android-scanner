package com.yono.applicationscanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworckChecker extends BroadcastReceiver {

    private static Boolean status = false;
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null){
            if (activeNetwork.getType() == connectivityManager.TYPE_WIFI
                    || activeNetwork.getType() == connectivityManager.TYPE_MOBILE){
                status = true;
            }else{
                status = false;
            }
        }else{
            status = false;
        }
    }


    public Boolean getJaringan(){
        return status;
    }
}

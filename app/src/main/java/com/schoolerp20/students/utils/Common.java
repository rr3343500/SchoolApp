package com.schoolerp20.students.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.retrofit.RetrofitIO;


public class Common {

    public static final String BASE_URL="http://schoolerp20.com";
    public static String pdfdetaile;
    public static String videourl;
    public static String subjectid;

    public static ApiServise getAPI(){
        return RetrofitIO.getClient( BASE_URL ).create( ApiServise.class );
    }
    public static boolean isConnectToInflate(Context context){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService( Context.CONNECTIVITY_SERVICE );
        if (connectivityManager!=null)
        {
            NetworkInfo[] infos=connectivityManager.getAllNetworkInfo();
            if (infos!=null)
            {
                for (int i=0;i<infos.length;i++){
                    if (infos[i].getState()== NetworkInfo.State.CONNECTED)
                        return true;
                }

            }
        }
        return false;
    }
}

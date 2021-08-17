package com.schoolerp20.students;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.modal.Loginone;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class Login extends AppCompatActivity {
TextView txt_login;
    ApiServise apiServise;
    CompositeDisposable compositeDisposable=new CompositeDisposable(  );
    EditText username,passwort;
    KProgressHUD hud;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        apiServise = Common.getAPI();
        txt_login=findViewById( R.id.txt_login );
        username=findViewById( R.id.username );
        passwort=findViewById( R.id.password );
        user=new User( Login.this );
        txt_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().isEmpty()) {
                    username.setError( "Enter the name" );
                    username.requestFocus();
                    return;
                }

                if (passwort.getText().toString().isEmpty()) {
                    passwort.setError( "Enter the Password" );
                    passwort.requestFocus();
                    return;
                }
                hud = KProgressHUD.create( Login.this )
                        .setStyle( KProgressHUD.Style.SPIN_INDETERMINATE )
                        .setLabel( "Please wait" )
                        .setMaxProgress( 100 )
                        .show();
                compositeDisposable.add( apiServise.login( "demo@123",username.getText().toString(),passwort.getText().toString() )
                        .subscribeOn( Schedulers.io() )
                        .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<Loginone>() {
                    @Override
                    public void accept(Loginone loginone) throws Exception {
                     if (loginone.msg.equals( "success" )){
                         hud.dismiss();
                         user.setUserid( loginone.value.login_id );
                         user.setName( loginone.value.name );
                         user.setPassword( loginone.value.pass );
                         user.setImage( loginone.value.img );
                         user.setClass_name( loginone.value.class_name );
                         user.setSection( loginone.value.section );
                         user.setAddress( loginone.value.address );
                         user.setDesig( loginone.value.admi_date );
                         user.setSalary( loginone.value.dob );
                         user.setQualification( loginone.value.vehicle );
                         user.setBloodgroup( loginone.value.mob1 );
                         user.setAadharcard( loginone.value.aadhar );
                         user.setPancard( loginone.value.mother_occupation );
                         user.setVoterid( loginone.value.father_occupation );
                         user.setSamagraid( loginone.value.ssmid );
                         user.setDoj( loginone.value.gender );
                         user.setAccountno( loginone.value.admission_fee );
                         user.setVehicleno( loginone.value.vehicle_no );
                         startActivity( new Intent( Login.this,MainActivity.class ) );
                         finish();
                     }else {
                         hud.dismiss();
                         Toast.makeText( Login.this, "Wrong Password", Toast.LENGTH_SHORT ).show();
                     }
                    }
                } ,throwable -> {
                     hud.dismiss();
                    Toast.makeText( Login.this, ""+throwable.getMessage(), Toast.LENGTH_SHORT ).show();
                }));
            }
        } );
    }
}

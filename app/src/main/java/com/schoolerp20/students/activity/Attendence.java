package com.schoolerp20.students.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.adapter.AdapterAttendence;
import com.schoolerp20.students.modal.Attendenceone;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Attendence extends AppCompatActivity {
    ApiServise apiServise;
    CompositeDisposable compositeDisposable=new CompositeDisposable(  );
    KProgressHUD hud;
    User user;
    RecyclerView similarprode;
    ProgressBar progressBar;
    ImageView backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_attendence );
        apiServise = Common.getAPI();
        user=new User( Attendence.this );
        backarrow=findViewById( R.id.backarrow );
        similarprode = findViewById( R.id.subcategory );
        similarprode.setLayoutManager( new GridLayoutManager( Attendence.this, 1 ) );
        similarprode.setHasFixedSize( true );
        similarprode.setNestedScrollingEnabled( true );
        progressBar = findViewById( R.id.progressbar );
        progressBar.setVisibility( View.VISIBLE );

        compositeDisposable.add( apiServise.attendence( user.getUserid(),user.getPassword(),"true" )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
        .subscribe( new Consumer<Attendenceone>() {
            @Override
            public void accept(Attendenceone attendenceone) throws Exception {
                  progressBar.setVisibility( View.GONE );
                if (attendenceone.msg.equals( "success" )){
                    AdapterAttendence attendence=new AdapterAttendence( Attendence.this,attendenceone );
                    similarprode.setAdapter( attendence );
                }else {
                    Toast.makeText( Attendence.this, "Not Data", Toast.LENGTH_SHORT ).show();
                }
            }
        },throwable -> {
         progressBar.setVisibility( View.GONE );
        } ));

        backarrow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );

    }
}

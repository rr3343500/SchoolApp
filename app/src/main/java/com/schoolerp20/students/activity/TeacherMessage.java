package com.schoolerp20.students.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.adapter.AdapterTeacherMessage;
import com.schoolerp20.students.modal.TeacherMessageOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class TeacherMessage extends AppCompatActivity {
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
        setContentView( R.layout.activity_teacher_message );
        apiServise = Common.getAPI();
        user=new User( TeacherMessage.this );
        similarprode = findViewById( R.id.subcategory );
        similarprode.setLayoutManager( new GridLayoutManager( TeacherMessage.this, 1 ) );
        similarprode.setHasFixedSize( true );
        similarprode.setNestedScrollingEnabled( true );
        progressBar = findViewById( R.id.progressbar );
        backarrow=findViewById( R.id.backarrow );
        progressBar.setVisibility( View.VISIBLE );
        compositeDisposable.add( apiServise.teachermessage( "true",user.getUserid(),user.getPassword() )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<TeacherMessageOne>() {
                    @Override
                    public void accept(TeacherMessageOne liveClassessOne) throws Exception {
                        progressBar.setVisibility( View.GONE );
                        AdapterTeacherMessage attendence = new AdapterTeacherMessage( TeacherMessage.this, liveClassessOne );
                        similarprode.setAdapter( attendence );
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
package com.schoolerp20.students.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.adapter.AdapterDairy;
import com.schoolerp20.students.adapter.AdapterExampaper;
import com.schoolerp20.students.adapter.AdapterExampaperClasses;
import com.schoolerp20.students.modal.ClassesMessageOne;
import com.schoolerp20.students.modal.DailyOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ClassesMessage extends AppCompatActivity {
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
        setContentView( R.layout.activity_classes_message );
        apiServise = Common.getAPI();
        user=new User( ClassesMessage.this );
        backarrow=findViewById( R.id.backarrow );
        similarprode = findViewById( R.id.subcategory );
        similarprode.setLayoutManager( new GridLayoutManager( ClassesMessage.this, 1 ) );
        similarprode.setHasFixedSize( true );
        similarprode.setNestedScrollingEnabled( true );
        progressBar = findViewById( R.id.progressbar );
        progressBar.setVisibility( View.VISIBLE );
        compositeDisposable.add( apiServise.get_teacher_classes( "true",user.getName(),user.getPassword() )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<ClassesMessageOne>() {
                    @Override
                    public void accept(ClassesMessageOne liveClassessOne) throws Exception {
                        progressBar.setVisibility( View.GONE );
                        AdapterExampaperClasses attendence = new AdapterExampaperClasses( ClassesMessage.this, liveClassessOne );
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
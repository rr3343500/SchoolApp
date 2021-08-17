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
import com.schoolerp20.students.modal.DailyOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DailyOneActivity extends AppCompatActivity {
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
        setContentView( R.layout.activity_daily_one );
        apiServise = Common.getAPI();
        user=new User( DailyOneActivity.this);
        backarrow=findViewById( R.id.backarrow );
        similarprode = findViewById( R.id.subcategory );
        similarprode.setLayoutManager( new GridLayoutManager( DailyOneActivity.this, 1 ) );
        similarprode.setHasFixedSize( true );
        similarprode.setNestedScrollingEnabled( true );
        progressBar = findViewById( R.id.progressbar );
        progressBar.setVisibility( View.VISIBLE );
        compositeDisposable.add( apiServise.dairygettwo( Common.subjectid,"true",user.getUserid(),user.getPassword() )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<DailyOne>() {
                    @Override
                    public void accept(DailyOne liveClassessOne) throws Exception {
                        progressBar.setVisibility( View.GONE );
                        //AdapterDairy attendence = new AdapterDairy( Daily.this, liveClassessOne );
                        AdapterDairy attendence = new AdapterDairy( DailyOneActivity.this, liveClassessOne );

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

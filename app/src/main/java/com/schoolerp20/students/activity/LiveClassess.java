package com.schoolerp20.students.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.adapter.AdapterLiveClassesOne;
import com.schoolerp20.students.modal.LiveClassessOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LiveClassess extends AppCompatActivity /*implements AdapterLiveClasses.AddLifecycleCallbackListener*/ {
    ApiServise apiServise;
    CompositeDisposable compositeDisposable=new CompositeDisposable(  );
    KProgressHUD hud;
    User user;
    RecyclerView similarprode,recyclerView;
    ProgressBar progressBar;
    ImageView backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_live_classess );
        apiServise = Common.getAPI();
        user=new User( LiveClassess.this );
       /* similarprode = findViewById( R.id.subcategory );
        similarprode.setLayoutManager( new GridLayoutManager( LiveClassess.this, 1 ) );
        similarprode.setHasFixedSize( true );
        similarprode.setNestedScrollingEnabled( true );*/

         recyclerView = findViewById(R.id.subcategory);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        progressBar = findViewById( R.id.progressbar );
        progressBar.setVisibility( View.VISIBLE );
      //  backarrow=findViewById( R.id.backarrow );*/

       /* String frameVideo = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/47yJ2XCRLZs\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        WebView displayYoutubeVideo = (WebView) findViewById(R.id.mWebView);
        displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");*/

       compositeDisposable.add( apiServise.Liveclassess( "true",user.getUserid(),user.getPassword() )
               .subscribeOn( Schedulers.io() )
               .observeOn( AndroidSchedulers.mainThread() )
       .subscribe( new Consumer<LiveClassessOne>() {
           @Override
           public void accept(LiveClassessOne liveClassessOne) throws Exception {
               progressBar.setVisibility( View.GONE );
               recyclerView.setVisibility( View.VISIBLE );
               AdapterLiveClassesOne attendence = new AdapterLiveClassesOne( LiveClassess.this, liveClassessOne );
               recyclerView.setAdapter( attendence );
              // getLifecycle().addObserver(youTubePlayerView);
           }

       },throwable -> {
           progressBar.setVisibility( View.GONE );

       } ));
      /*  backarrow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );*/


    }

 /*   @Override
    public void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView) {
        getLifecycle().addObserver(youTubePlayerView);
    }*/
}

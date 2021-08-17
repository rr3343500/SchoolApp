package com.schoolerp20.students.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.schoolerp20.students.R;
import com.schoolerp20.students.modal.LiveClassessOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import io.reactivex.disposables.CompositeDisposable;

public class AdapterLiveClasses extends RecyclerView.Adapter<AdapterLiveClasses.ViewHolder> {
    Lifecycle lifecycle;
    LiveClassessOne myShopOne;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiServise apiServise;
    User user;
    KProgressHUD hud;
    public AdapterLiveClasses(Lifecycle lifecycle, LiveClassessOne myShopOne) {
        this.lifecycle = lifecycle;
        this.myShopOne = myShopOne;
        apiServise= Common.getAPI();

    }

    @NonNull
    @Override
    public AdapterLiveClasses.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      /*  View view = LayoutInflater.from( context ).inflate( R.layout.liveclasses_item, parent, false );

        return new AdapterLiveClasses.MyViewHolder( view );*/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate( R.layout.recycler_view_item, parent, false);
        lifecycle.addObserver(youTubePlayerView);

        return new ViewHolder(youTubePlayerView);
    }

  /*  public interface AddLifecycleCallbackListener {
        void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView);
    }*/

    @Override
    public void onBindViewHolder(@NonNull AdapterLiveClasses.ViewHolder holder, int position) {
              /*  String frameVideo = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" src=\""+myShopOne.value.get( position ).url+"\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        holder.displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = holder.displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        holder.displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");*/
      //  holder.displayYoutubeVideo.loadData((this.myShopOne.value.get(position).url), "text/html", "utf-8");
       // String src1 = myShopOne.value.get( position ).url;
        //String frameVideo = "<html><body>Video From YouTube<br><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/watch?v=x_hVW5gI7Bc\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
      //  String frameVideo = "<html><body>Youtube video .. <br> <iframe width='345' height='315' src='https://www.youtube.com/embed/-xE2Q3NrB6Y' frameborder='0' allowfullscreen></iframe></body></html>";
       // String frameVideo = "<html><body>Youtube video .. <br> <iframe width='345' height='315' src="+myShopOne.value.get( position ).url+" frameborder='0' allowfullscreen></iframe></body></html>";

     /*   holder.displayYoutubeVideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        WebSettings webSettings = holder.displayYoutubeVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled( true );
        holder.displayYoutubeVideo.loadData(myShopOne.value.get( position ).url, "text/html", "utf-8");*/

       // WebSettings webSettings =  holder.displayYoutubeVideo.getSettings();
       // webSettings.setJavaScriptEnabled(false);

       /* String frameVideo = "<html><body>Youtube video .. <br> <iframe width=\"320\" height=\"315\" src=\"https://www.youtube.com/embed/watch?v=x_hVW5gI7Bc\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        holder.displayYoutubeVideo.loadData(frameVideo, "text/html", "utf-8");
        //  holder.displayYoutubeVideo.loadUrl("http://www.youtube.com/");
        holder.displayYoutubeVideo.setWebViewClient(new WebViewClient());*/
      //  holder.displayYoutubeVideo.setWebViewClient( new WebViewClient() );
      //  holder.displayYoutubeVideo.setWebChromeClient( new WebChromeClient() );
       // holder.displayYoutubeVideo.getSettings().setJavaScriptEnabled( true );
       // String frameVideo = "<html><body>Youtube video .. <br> <iframe width=\"320\" height=\"315\" src=\"https://www.youtube.com/watch?v=x_hVW5gI7Bc\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
      //  holder.displayYoutubeVideo.loadUrl( myShopOne.value.get( position ).url );
        // holder.displayYoutubeVideo.loadUrl( "https://www.youtube.com/embed/47yJ2XCRLZs" );
       //  holder.displayYoutubeVideo.loadUrl( "https://www.youtube.com/embed/-xE2Q3NrB6Y" );
         //  holder.displayYoutubeVideo.loadData(myShopOne.value.get( position ).url, "text/html", "utf-8");
     /*   holder.youTubePlayerView.enterFullScreen();
        holder.youTubePlayerView.exitFullScreen();
        holder.youTubePlayerView.isFullScreen();
        holder.youTubePlayerView.toggleFullScreen();*/

     /*  holder.youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });*/
        String isone = myShopOne.value.get( position ).url.substring( myShopOne.value.get( position ).url.lastIndexOf( "/" ) + 1 );

        holder.cueVideo(isone);

    }
    @Override
    public int getItemCount() {
        return myShopOne.value.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        private YouTubePlayerView youTubePlayerView;
        private YouTubePlayer youTubePlayer;
        private String currentVideoId;

        ViewHolder(YouTubePlayerView playerView) {
            super(playerView);
            youTubePlayerView = playerView;

            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer initializedYouTubePlayer) {
                    youTubePlayer = initializedYouTubePlayer;
                    youTubePlayer.cueVideo(currentVideoId, 0);
                }
            });
        }

        void cueVideo(String videoId) {
            currentVideoId = videoId;

            if(youTubePlayer == null)
                return;

            youTubePlayer.cueVideo(videoId, 0);
        }
    }
}
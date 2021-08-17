package com.schoolerp20.students.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.modal.LiveClassessOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import io.reactivex.disposables.CompositeDisposable;

public class AdapterLiveClassesOne extends RecyclerView.Adapter<AdapterLiveClassesOne.ViewHolder> {
    // Lifecycle lifecycle;
    Context lifecycle;
    LiveClassessOne myShopOne;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiServise apiServise;
    User user;
    KProgressHUD hud;
    public AdapterLiveClassesOne(Context lifecycle, LiveClassessOne myShopOne) {
        this.lifecycle = lifecycle;
        this.myShopOne = myShopOne;
        apiServise= Common.getAPI();

    }

    @NonNull
    @Override
    public AdapterLiveClassesOne.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( lifecycle ).inflate( R.layout.exampepar_itemone, parent, false );

        return new AdapterLiveClassesOne.ViewHolder( view );
      /*  YouTubePlayerView youTubePlayerView = (YouTubePlayerView) LayoutInflater.from(parent.getContext()).inflate( R.layout.recycler_view_item, parent, false);
        lifecycle.addObserver(youTubePlayerView);

        return new ViewHolder(youTubePlayerView);*/
    }

  /*  public interface AddLifecycleCallbackListener {
        void addLifeCycleCallBack(YouTubePlayerView youTubePlayerView);
    }*/

    @Override
    public void onBindViewHolder(@NonNull AdapterLiveClassesOne.ViewHolder holder, int position) {
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
       /* String isone = myShopOne.value.get( position ).url.substring( myShopOne.value.get( position ).url.lastIndexOf( "/" ) + 1 );

        holder.cueVideo(isone);*/

        holder.name.setText( new StringBuilder( "" ).append( myShopOne.value.get( position ).class_name+myShopOne.value.get( position ).section) );
        holder.email.setText( new StringBuilder( "" ).append( myShopOne.value.get( position ).teacher_name) );
        holder.phone.setText( new StringBuilder( "" ).append( myShopOne.value.get( position ).subject) );

        holder.view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent browserIntent = new Intent( "android.intent.action.VIEW", Uri.parse( myShopOne.value.get( position ).url ) );
               // lifecycle.startActivity( browserIntent );
               // ((Activity)lifecycle).finish();
                try {
                    holder.webView.getSettings().setJavaScriptEnabled(true);
                    holder.webView.loadUrl(myShopOne.value.get( position ).url);
                }catch (Exception s){
                    Toast.makeText( lifecycle, "No Live Class", Toast.LENGTH_SHORT ).show();
                }
            }
        } );

    }
    @Override
    public int getItemCount() {
        return myShopOne.value.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView email,phone,name,view;
        WebView webView;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            email=itemView.findViewById( R.id.email );
            phone=itemView.findViewById( R.id.phone );
            name=itemView.findViewById( R.id.name );
            view=itemView.findViewById( R.id.viewall );
            webView=itemView.findViewById( R.id.webview );
        }
    }
}

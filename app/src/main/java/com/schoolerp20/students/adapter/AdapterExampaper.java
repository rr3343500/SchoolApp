package com.schoolerp20.students.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.modal.ExampaperOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import io.reactivex.disposables.CompositeDisposable;

public class AdapterExampaper extends RecyclerView.Adapter<AdapterExampaper.MyViewHolder> {
    Context context;
    ExampaperOne myShopOne;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiServise apiServise;
    User user;
    KProgressHUD hud;
    public AdapterExampaper(Context context, ExampaperOne myShopOne) {
        this.context = context;
        this.myShopOne = myShopOne;
        apiServise= Common.getAPI();

    }

    @NonNull
    @Override
    public AdapterExampaper.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.invoicehostoryitemone, parent, false );

        return new AdapterExampaper.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExampaper.MyViewHolder holder, int position) {
        holder.email.setText( new StringBuilder(  ).append( myShopOne.value.get( position ).paper) );


    }

    @Override
    public int getItemCount() {
        return myShopOne.value.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            email=itemView.findViewById( R.id.email );

        }
    }
}

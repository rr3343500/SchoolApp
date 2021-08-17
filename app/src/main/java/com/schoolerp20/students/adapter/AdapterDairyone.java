package com.schoolerp20.students.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.activity.DailyOneActivity;
import com.schoolerp20.students.activity.PdfActivityOne;
import com.schoolerp20.students.modal.SubjectNameOne;
import com.schoolerp20.students.utils.Common;

import io.reactivex.disposables.CompositeDisposable;

public class AdapterDairyone extends RecyclerView.Adapter<AdapterDairyone.MyViewHolder> {
    Context context;
    SubjectNameOne myShopOne;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    String pdf;
  //  ApiServise apiServise;
   // User user;
    KProgressHUD hud;
    public AdapterDairyone(Context context, SubjectNameOne myShopOne, String pdf) {
        this.context = context;
        this.myShopOne = myShopOne;
        this.pdf=pdf;
     //   apiServise= Common.getAPI();

    }

    @NonNull
    @Override
    public AdapterDairyone.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.invoicehostoryitemone, parent, false );

        return new AdapterDairyone.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDairyone.MyViewHolder holder, int position) {

        holder.email.setText( new StringBuilder(  ).append( myShopOne.value.get( position ).name) );

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pdf.equals( "dairy" )) {
                    Common.subjectid=myShopOne.value.get( position ).subject_id;
                    context.startActivity( new Intent( context, DailyOneActivity.class ) );
                }
                if (pdf.equals( "pdf" )){
                    Common.subjectid=myShopOne.value.get( position ).subject;
                    context.startActivity( new Intent( context, PdfActivityOne.class ) );
                }
            }
        } );

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


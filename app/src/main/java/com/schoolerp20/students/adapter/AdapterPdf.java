package com.schoolerp20.students.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.activity.PdfDetaile;
import com.schoolerp20.students.modal.PDFone;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import org.sufficientlysecure.htmltextview.HtmlTextView;

import io.reactivex.disposables.CompositeDisposable;

public class AdapterPdf extends RecyclerView.Adapter<AdapterPdf.MyViewHolder> {
    Context context;
    PDFone myShopOne;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiServise apiServise;
    User user;
    KProgressHUD hud;
    public AdapterPdf(Context context, PDFone myShopOne) {
        this.context = context;
        this.myShopOne = myShopOne;
        apiServise= Common.getAPI();

    }

    @NonNull
    @Override
    public AdapterPdf.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.invoicehostoryitemoneone, parent, false );

        return new AdapterPdf.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPdf.MyViewHolder holder, int position) {
        // holder.studentname.setText( myShopOne.value.get( position ).c );
        holder.name.setText( new StringBuilder( "" ).append( myShopOne.value.get( position ).title) );
        holder.email.setText( new StringBuilder( "" ).append( myShopOne.value.get( position ).teacher_name) );
        holder.phone.setText( new StringBuilder( "" ).append( myShopOne.value.get( position ).create_at) );
      //  holder.description.setText( myShopOne.value.get( position ) );
        holder.view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Common.pdfdetaile="http://schoolerp20.com/teacher/images/"+myShopOne.value.get( position ).document;
              context.startActivity( new Intent( context, PdfDetaile.class ) );

               // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://modelschoolbhind.com/school1/teacher/images/"+myShopOne.value.get( position ).document));
               // context.startActivity(browserIntent);
            }
        } );

    }



    @Override
    public int getItemCount() {
        return myShopOne.value.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView email,phone,name,view;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            email=itemView.findViewById( R.id.email );
            phone=itemView.findViewById( R.id.phone );
            name=itemView.findViewById( R.id.name );
            view=itemView.findViewById( R.id.viewall );

        }
    }
}

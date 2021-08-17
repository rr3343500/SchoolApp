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
import com.schoolerp20.students.modal.ClassesMessageOne;
import com.schoolerp20.students.modal.ExampaperOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import io.reactivex.disposables.CompositeDisposable;

public class AdapterExampaperClasses  extends RecyclerView.Adapter<AdapterExampaperClasses.MyViewHolder> {
    Context context;
    ClassesMessageOne myShopOne;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiServise apiServise;
    User user;
    KProgressHUD hud;
    public AdapterExampaperClasses(Context context, ClassesMessageOne myShopOne) {
        this.context = context;
        this.myShopOne = myShopOne;
        apiServise= Common.getAPI();

    }

    @NonNull
    @Override
    public AdapterExampaperClasses.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.exampepar_itemclassesone, parent, false );

        return new AdapterExampaperClasses.MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExampaperClasses.MyViewHolder holder, int position) {
        // holder.studentname.setText( myShopOne.value.get( position ).c );
        holder.name.setText( new StringBuilder( "Class " ).append( myShopOne.value.get( position ).class_name) );
        holder.email.setText( new StringBuilder( "Subject " ).append( myShopOne.value.get( position ).subject_name) );
        holder.phone.setText( new StringBuilder( "("+myShopOne.value.get( position ).day+") " ).append( myShopOne.value.get( position ).start_time)
        .append( " - "+myShopOne.value.get( position ).end_time ));

        holder.view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Common.detailehistory=myShopOne.value.data.get( position );
                // context.startActivity( new Intent( context, HistoryFullDetaile.class ) );
                if (holder.description.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition( holder.taran,new AutoTransition() );
                    holder.description.setVisibility( View.VISIBLE );
                    // holder.view.setText( "See less.." );
                    // arrow.setImageResource( R.drawable.ic_keyboard_arrow_up_black_24dp );
                }else {
                    TransitionManager.beginDelayedTransition( holder.taran,new AutoTransition() );
                    holder.description.setVisibility( View.GONE );
                    // holder.view.setText( "View all.." );
                    // arrow.setImageResource( R.drawable.ic_keyboard_arrow_right_black_24dp );
                }
            }
        } );

    }



    @Override
    public int getItemCount() {
        return myShopOne.value.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView email,phone,name,view;
        HtmlTextView description;
        LinearLayout taran;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            email=itemView.findViewById( R.id.email );
            phone=itemView.findViewById( R.id.phone );
            name=itemView.findViewById( R.id.name );
            view=itemView.findViewById( R.id.viewall );
            description=itemView.findViewById( R.id.description );
            taran=itemView.findViewById( R.id.tarans );
        }
    }
}

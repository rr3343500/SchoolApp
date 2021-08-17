package com.schoolerp20.students.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.modal.Attendenceone;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;


import io.reactivex.disposables.CompositeDisposable;

public class AdapterAttendence extends RecyclerView.Adapter<AdapterAttendence.MyViewHolder> {
    Context context;
    Attendenceone myShopOne;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiServise apiServise;
    User user;
    KProgressHUD hud;

    public AdapterAttendence(Context context, Attendenceone myShopOne) {
        this.context = context;
        this.myShopOne = myShopOne;
        apiServise= Common.getAPI();
        user=new User( context );
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.attendence_item, parent, false );

        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.studentname.setText( myShopOne.value.get( position ).date );

      if (myShopOne.value.get( position ).attend_val.equals( "1" )){
          holder.present.setBackgroundColor( Color.parseColor( "#4F8351") );
          holder.present.setTextColor( Color.WHITE );

      }
      if (myShopOne.value.get( position ).attend_val.equals( "2" )){
          holder.absent.setBackgroundColor( Color.parseColor( "#E53935") );
          holder.absent.setTextColor( Color.WHITE );

      }
   /*   holder.present.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              hud = KProgressHUD.create( context )
                      .setStyle( KProgressHUD.Style.SPIN_INDETERMINATE )
                      .setLabel( "Please wait" )
                      .setMaxProgress( 100 )
                      .show();
              compositeDisposable.add( apiServise.present( "true",user.getName(),user.getPassword(),myShopOne.value.get( position ).enroll_no,user.getClass_name(),"1" )
                      .subscribeOn( Schedulers.io() )
                      .observeOn( AndroidSchedulers.mainThread() )
                      .subscribe( new Consumer<PresentOne>() {
                          @Override
                          public void accept(PresentOne liveClassessOne) throws Exception {
                              hud.dismiss();
                              if (liveClassessOne.value.equals( "Add Successfully" )){
                                  holder.present.setBackgroundColor( Color.parseColor( "#4F8351") );
                                  holder.absent.setBackgroundColor( Color.WHITE );
                                  holder.present.setTextColor( Color.WHITE );
                                  holder.absent.setTextColor( Color.BLACK );

                              }
                          }

                      },throwable -> {
                          hud.dismiss();
                      } ));
          }
      } );


      holder.absent.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              hud = KProgressHUD.create( context )
                      .setStyle( KProgressHUD.Style.SPIN_INDETERMINATE )
                      .setLabel( "Please wait" )
                      .setMaxProgress( 100 )
                      .show();
              compositeDisposable.add( apiServise.present( "true",user.getName(),user.getPassword(),myShopOne.value.get( position ).enroll_no,user.getClass_name(),"0" )
                      .subscribeOn( Schedulers.io() )
                      .observeOn( AndroidSchedulers.mainThread() )
                      .subscribe( new Consumer<PresentOne>() {
                          @Override
                          public void accept(PresentOne liveClassessOne) throws Exception {
                              hud.dismiss();
                              if (liveClassessOne.value.equals( "Add Successfully" )){
                                  holder.absent.setBackgroundColor( Color.parseColor( "#E53935") );
                                  holder.present.setBackgroundColor( Color.WHITE );
                                  holder.absent.setTextColor( Color.WHITE );
                                  holder.present.setTextColor( Color.BLACK );

                              }

                          }

                      },throwable -> {
                          hud.dismiss();
                      } ));
          }
      } );*/

    }



    @Override
    public int getItemCount() {
        return myShopOne.value.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView studentname,absent,present;
        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            studentname=itemView.findViewById( R.id.studentname );
            absent=itemView.findViewById( R.id.absent );
            present=itemView.findViewById( R.id.present );

        }
    }
}

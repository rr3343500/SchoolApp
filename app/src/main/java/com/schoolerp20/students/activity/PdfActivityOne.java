package com.schoolerp20.students.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.schoolerp20.students.R;
import com.schoolerp20.students.adapter.AdapterDairyone;
import com.schoolerp20.students.adapter.AdapterPdf;
import com.schoolerp20.students.modal.PDFone;
import com.schoolerp20.students.modal.SubjectNameOne;
import com.schoolerp20.students.modal.User;
import com.schoolerp20.students.retrofit.ApiServise;
import com.schoolerp20.students.utils.Common;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PdfActivityOne extends AppCompatActivity {
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
        setContentView( R.layout.activity_pdf_one );
        apiServise = Common.getAPI();
        user=new User( PdfActivityOne.this );
        backarrow=findViewById( R.id.backarrow );
        similarprode = findViewById( R.id.subcategory );
        similarprode.setLayoutManager( new GridLayoutManager( PdfActivityOne.this, 1 ) );
        similarprode.setHasFixedSize( true );
        similarprode.setNestedScrollingEnabled( true );
        progressBar = findViewById( R.id.progressbar );
        progressBar.setVisibility( View.VISIBLE );
        //    pdfView=findViewById( R.id.idPDFView );
        compositeDisposable.add( apiServise.pdfget( "true",Common.subjectid,user.getUserid(),user.getPassword() )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<PDFone>() {
                    @Override
                    public void accept(PDFone liveClassessOne) throws Exception {
                        progressBar.setVisibility( View.GONE );
                        //  AdapterDairy attendence = new AdapterDairy( Daily.this, liveClassessOne );
                        //  similarprode.setAdapter( attendence );
                         AdapterPdf adapterPdf =new AdapterPdf( PdfActivityOne.this,liveClassessOne );
                       // AdapterDairyone adapterPdf = new AdapterDairyone( PdfActivityOne.this, liveClassessOne );
                        similarprode.setAdapter( adapterPdf );

                    }

                },throwable -> {
                    progressBar.setVisibility( View.GONE );
                    Toast.makeText( this, ""+throwable, Toast.LENGTH_SHORT ).show();

                } ));

        backarrow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    }
}
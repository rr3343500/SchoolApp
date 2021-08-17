package com.schoolerp20.students.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class PdfActivity extends AppCompatActivity {
    ApiServise apiServise;
    CompositeDisposable compositeDisposable=new CompositeDisposable(  );
    KProgressHUD hud;
    User user;
    RecyclerView similarprode;
    ProgressBar progressBar;
    ImageView backarrow;

    // url of our PDF file.
    //String pdfurl = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
    String pdfurl="http://modelschoolbhind.com/school1/teacher/images/pdf0707201594111545.pdf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pdf );
        apiServise = Common.getAPI();
        user=new User( PdfActivity.this );
        backarrow=findViewById( R.id.backarrow );
        similarprode = findViewById( R.id.subcategory );
        similarprode.setLayoutManager( new GridLayoutManager( PdfActivity.this, 1 ) );
        similarprode.setHasFixedSize( true );
        similarprode.setNestedScrollingEnabled( true );
        progressBar = findViewById( R.id.progressbar );
        progressBar.setVisibility( View.VISIBLE );
    //    pdfView=findViewById( R.id.idPDFView );
        compositeDisposable.add( apiServise.pdfgettwo( "true",user.getUserid(),user.getPassword() )
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Consumer<SubjectNameOne>() {
                    @Override
                    public void accept(SubjectNameOne liveClassessOne) throws Exception {
                        progressBar.setVisibility( View.GONE );
                      //  AdapterDairy attendence = new AdapterDairy( Daily.this, liveClassessOne );
                      //  similarprode.setAdapter( attendence );
                       // AdapterPdf adapterPdf =new AdapterPdf( PdfActivity.this,liveClassessOne );
                        AdapterDairyone adapterPdf = new AdapterDairyone( PdfActivity.this, liveClassessOne,"pdf" );
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


        //  new RetrivePDFfromUrl().execute(pdfurl);
    }

    // create an async task class for loading pdf file from URL.
  /*  class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility( View.VISIBLE );
        }

        @Override
        protected InputStream doInBackground(String... strings) {
            // we are using inputstream
            // for getting out PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // below is the step where we are
                // creating our connection.
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    // response is success.
                    // we are getting input stream from url
                    // and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                // this is the method
                // to handle errors.
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async
            // task we are loading our pdf in our pdf view.
            progressBar.setVisibility( View.GONE );
            pdfView.fromStream(inputStream).load();
        }
    }*/
}
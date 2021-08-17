package com.schoolerp20.students.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.schoolerp20.students.R;
import com.schoolerp20.students.utils.Common;


public class PdfDetaile extends AppCompatActivity {
    ProgressBar progressBar;
   // PDFView pdfView;
    //http://modelschoolbhind.com/school1/teacher/images/pdf1108201597131068.jpg
  //  String pdfurl="http://modelschoolbhind.com/school1/teacher/images/pdf1803211616056723.pdf";
    WebView webView;
    String googleDocs = "https://docs.google.com/viewer?url=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pdf_detaile );
         webView = (WebView) findViewById( R.id.webbbb);
         progressBar = findViewById( R.id.progressbar );
        progressBar.setVisibility( View.VISIBLE );
        String dataset= Common.pdfdetaile;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls( true );
        webView.setWebChromeClient( new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged( view, newProgress );
               // getSupportActionBar().
                if (newProgress==100){
                    progressBar.setVisibility( View.GONE );
                }
            }
        } );
        webView.loadUrl( googleDocs+dataset );
        // webView.loadUrl("http://modelschoolbhind.com/school1/teacher/images/pdf0707201594111545.pdf");
       // pdfView=findViewById( R.id.idPDFView );
       /*  new RetrivePDFfromUrl().execute( Common.pdfdetaile );

    }
    // create an async task class for loading pdf file from URL.
    class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {

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
        }*/
    }
}
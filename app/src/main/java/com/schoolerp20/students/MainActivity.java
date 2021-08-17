package com.schoolerp20.students;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.schoolerp20.students.activity.Attendence;
import com.schoolerp20.students.activity.ClassesMessage;
import com.schoolerp20.students.activity.Daily;
import com.schoolerp20.students.activity.ExamPaper;
import com.schoolerp20.students.activity.LiveClassess;
import com.schoolerp20.students.activity.PdfActivity;
import com.schoolerp20.students.activity.PrincipleMessage;
import com.schoolerp20.students.activity.Profile;
import com.schoolerp20.students.activity.TeacherMessage;
import com.schoolerp20.students.activity.VideoHistory;
import com.schoolerp20.students.modal.User;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    CardView attendence,liveclassess,exam,pricipal,pdf;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    User user;
    CircleImageView profile;
    TextView name,classname,section;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        attendence=findViewById( R.id.attendence );
        liveclassess=findViewById( R.id.liveclassess );
        navigationView = findViewById( R.id.navigationView );
        name=findViewById( R.id.name );
        classname=findViewById( R.id.classname );
        section=findViewById( R.id.section );
        drawerLayout = findViewById( R.id.drawer );
        pdf=findViewById( R.id.pdf );
        pricipal=findViewById( R.id.pricipal );
        user=new User( MainActivity.this );
      //  Toast.makeText( MainActivity.this, ""+user.getUserid()+"  "+user.getPassword(), Toast.LENGTH_SHORT ).show();
        profile=findViewById( R.id.profile );
        exam=findViewById( R.id.exam );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Picasso.get().load( new StringBuilder( "http://schoolerp20.com/school1/images/student_img/" )
                .append(user.getImage() ).toString() )
                .placeholder( R.drawable.ic_account_circle_black_24dp ).into( profile);
        name=findViewById( R.id.name );
        name.setText( user.getName());
        classname.setText( user.getClass_name() );
        section.setText( user.getSection() );
        toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.open, R.string.close );
        toggle.getDrawerArrowDrawable().setColor( Color.WHITE );
        drawerLayout.addDrawerListener( toggle );
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer( GravityCompat.START );
                switch (item.getItemId()) {
                    case R.id.nav_home1:
                        startActivity( new Intent( MainActivity.this, Profile.class ) );
                        break;
                    case R.id.nav_heart1:
                        startActivity( new Intent( MainActivity.this, Daily.class ) );
                        //  startActivity( new Intent( MainActivity.this,CartProductSqulite.class ) );
                        break;
                    case R.id.upload:
                        startActivity( new Intent( MainActivity.this, TeacherMessage.class ) );
                        break;
                    case R.id.video:
                        startActivity( new Intent( MainActivity.this, VideoHistory.class ) );
                        break;
                    case R.id.logout:
                        AlertDialog.Builder builder=new AlertDialog.Builder( MainActivity.this );
                        builder.setTitle( "Are You Sure " );
                        builder.setMessage( "Do you want to Logout" );
                        builder.setNegativeButton( "No",(dialog, i) -> {
                            dialog.dismiss();
                        } ).setPositiveButton( "Yes",(dialog, i) -> {
                            //Toast.makeText( getContext(), "Implement late", Toast.LENGTH_SHORT ).show();
                            user.setFirstTimeLaunch( true );
                            startActivity( new Intent( MainActivity.this,Splash.class ) );
                            finish();
                            dialog.dismiss();
                        } );

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor( Color.RED );
                        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED);

                        break;

                }
                return true;
            }
        } );
        bottomNavigationView = findViewById( R.id.bottom_navigation );
        bottomNavigationView.setVisibility( View.VISIBLE );

        bottomNavigationView.setSelectedItemId( R.id.nav_home );
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(R.id.nav_heart1);
        // View badge = LayoutInflater.from(MainActivity.this).inflate(R.layout.badgenotification, bottomNavigationView, false);

        //  text = badge.findViewById(R.id.badge_text_view);
        //  itemView.addView(badge);
        //  bottomNavigationView.setActiveTabColor("#FFFFFE");
        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.nav_home) {

                    return true;


                }
                if (id == R.id.nav_heart1) {
                    startActivity( new Intent( MainActivity.this, Daily.class ) );
                }

                if (id == R.id.nav_heart2) {
                    AlertDialog.Builder builder=new AlertDialog.Builder( MainActivity.this );
                    builder.setTitle( "Are You Sure " );
                    builder.setMessage( "Do you want to Logout" );
                    builder.setNegativeButton( "No",(dialog, i) -> {
                        dialog.dismiss();
                    } ).setPositiveButton( "Yes",(dialog, i) -> {
                        //Toast.makeText( getContext(), "Implement late", Toast.LENGTH_SHORT ).show();
                        user.setFirstTimeLaunch( true );
                        startActivity( new Intent( MainActivity.this,Splash.class ) );
                        finish();
                        dialog.dismiss();
                    } );

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor( Color.RED );
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED);
                }
                return false;
            }
        } );
        liveclassess.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, LiveClassess.class ) );
            }
        } );


        pricipal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, PrincipleMessage.class ) );
            }
        } );
        attendence.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, Attendence.class ) );
            }
        } );
        exam.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, ExamPaper.class ) );
            }
        } );
        pdf.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( MainActivity.this, PdfActivity.class ));
            }
        } );

    }


    //school pdf path
    //http://modelschoolbhind.com/school1/teacher/images/pdf0707201594111545.pdf
    //http://modelschoolbhind.com/school1/teacher/uploaded_video/0503211614928581.mp4
}

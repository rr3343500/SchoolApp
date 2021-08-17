package com.schoolerp20.students.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.schoolerp20.students.R;
import com.schoolerp20.students.modal.User;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {
    User user;
    CircleImageView profile;
    TextView name,classname,section,vehicleno;
    TextView name1,desig,address,classid,voteridid,bloodgroop,pancard,aadarcard,samagarid,salary,joining,salary1,qualification;
    ImageView backarrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );
        name1=findViewById( R.id.name1 );
        classname=findViewById( R.id.classname );
        backarrow=findViewById( R.id.backarrow );
        vehicleno=findViewById( R.id.vehicleno );
        section=findViewById( R.id.section );
        desig=findViewById( R.id.desig );
        address=findViewById( R.id.address );
        classid=findViewById( R.id.classid );
        voteridid=findViewById( R.id.voterid );
        joining=findViewById( R.id.joining );
        salary1=findViewById( R.id.salary1 );
        qualification=findViewById( R.id.qualification );
        bloodgroop=findViewById( R.id.bloodgroup );
        aadarcard=findViewById( R.id.aadharcard );
        user=new User( Profile.this );
        profile=findViewById( R.id.profile );
        pancard=findViewById( R.id.pancard );
        aadarcard=findViewById( R.id.aadharcard );
        samagarid=findViewById( R.id.samagarid );
        salary=findViewById( R.id.salary );
        Picasso.get().load( new StringBuilder( "http://schoolerp20.com/school1/images/student_img/" )
                .append(user.getImage() ).toString() )
                .placeholder( R.drawable.user ).into( profile);
        name=findViewById( R.id.name );
        name.setText( user.getName());
        classname.setText( user.getClass_name() );
        section.setText( user.getSection() );

        name1.setText( user.getName() );
        desig.setText( user.getDesig() );
        address.setText( user.getAddress() );
        classid.setText( user.getClass_name() );
        voteridid.setText( user.getVoterid() );
        bloodgroop.setText( user.getBloodgroup() );
        pancard.setText( user.getPancard() );
        aadarcard.setText( user.getAadharcard() );
        samagarid.setText( user.getSamagraid() );
        salary.setText( user.getAccountno() );
        joining.setText( user.getDoj() );
        salary1.setText( user.getSalary() );
        qualification.setText( user.getQualification() );
        vehicleno.setText( user.getVehicleno() );

        backarrow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );

    }
}
package com.schoolerp20.students.modal;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    Context context;
    String userid,name,password,image,class_name,section,accountno,vehicleno;
    String address,desig,salary,qualification,bloodgroup,aadharcard,pancard,voterid,samagraid,doj;
    SharedPreferences sharedPreferences;
    boolean editor;

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor = sharedPreferences.edit().clear().commit();

    }

    public String getVehicleno() {
        vehicleno=sharedPreferences.getString( "vehicleno","" );
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        sharedPreferences.edit().putString( "vehicleno",vehicleno ).commit();
        this.vehicleno = vehicleno;
    }

    public String getAccountno() {
        accountno=sharedPreferences.getString( "accountno","" );
        return accountno;
    }

    public void setAccountno(String accountno) {
        sharedPreferences.edit().putString( "accountno",accountno ).commit();

        this.accountno = accountno;
    }

    public String getDoj() {
        doj=sharedPreferences.getString( "doj","" );

        return doj;
    }

    public void setDoj(String doj) {
        sharedPreferences.edit().putString( "doj",doj ).commit();

        this.doj = doj;
    }

    public String getAddress() {
        address=sharedPreferences.getString( "address","" );

        return address;
    }

    public void setAddress(String address) {
        sharedPreferences.edit().putString( "address",address ).commit();

        this.address = address;
    }

    public String getDesig() {
        desig=sharedPreferences.getString( "desig","" );

        return desig;
    }

    public void setDesig(String desig) {
        sharedPreferences.edit().putString( "desig",desig ).commit();

        this.desig = desig;
    }

    public String getSalary() {
        salary=sharedPreferences.getString( "salary","" );

        return salary;
    }

    public void setSalary(String salary) {
        sharedPreferences.edit().putString( "salary",salary ).commit();

        this.salary = salary;
    }

    public String getQualification() {
        qualification=sharedPreferences.getString( "qualification","" );

        return qualification;
    }

    public void setQualification(String qualification) {
        sharedPreferences.edit().putString( "qualification",qualification ).commit();

        this.qualification = qualification;
    }

    public String getBloodgroup() {
        bloodgroup=sharedPreferences.getString( "bloodgroup","" );

        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        sharedPreferences.edit().putString( "bloodgroup",bloodgroup ).commit();

        this.bloodgroup = bloodgroup;
    }

    public String getAadharcard() {
        aadharcard=sharedPreferences.getString( "aadharcard","" );

        return aadharcard;
    }

    public void setAadharcard(String aadharcard) {
        sharedPreferences.edit().putString( "aadharcard",aadharcard ).commit();

        this.aadharcard = aadharcard;
    }

    public String getPancard() {
        pancard=sharedPreferences.getString( "pancard","" );

        return pancard;
    }

    public void setPancard(String pancard) {
        sharedPreferences.edit().putString( "pancard",pancard ).commit();

        this.pancard = pancard;
    }

    public String getVoterid() {
        voterid=sharedPreferences.getString( "voterid","" );

        return voterid;
    }

    public void setVoterid(String voterid) {
        sharedPreferences.edit().putString( "voterid",voterid ).commit();

        this.voterid = voterid;
    }

    public String getSamagraid() {
        samagraid=sharedPreferences.getString( "samagraid","" );

        return samagraid;
    }

    public void setSamagraid(String samagraid) {
        sharedPreferences.edit().putString( "samagraid",samagraid ).commit();

        this.samagraid = samagraid;
    }

    public String getUserid() {
        userid=sharedPreferences.getString( "userid","" );

        return userid;
    }

    public void setUserid(String userid) {
        sharedPreferences.edit().putString( "userid",userid ).commit();
        this.userid = userid;
    }

    public String getImage() {
        image=sharedPreferences.getString( "image","" );
        return image;
    }

    public void setImage(String image) {
        sharedPreferences.edit().putString( "image",image ).commit();
        this.image = image;
    }

    public String getName() {
        name=sharedPreferences.getString( "name","" );

        return name;
    }

    public void setName(String name) {
        sharedPreferences.edit().putString( "name",name ).commit();

        this.name = name;
    }

    public String getPassword() {
        password=sharedPreferences.getString( "password","" );

        return password;
    }

    public void setPassword(String password) {
        sharedPreferences.edit().putString( "password",password ).commit();

        this.password = password;
    }

    public String getClass_name() {
        class_name=sharedPreferences.getString( "class_name","" );

        return class_name;
    }

    public void setClass_name(String class_name) {
        sharedPreferences.edit().putString( "class_name",class_name ).commit();

        this.class_name = class_name;
    }

    public String getSection() {
        section=sharedPreferences.getString( "section","" );

        return section;
    }

    public void setSection(String section) {
        sharedPreferences.edit().putString( "section",section ).commit();
        this.section = section;
    }

    public User(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences( "userinfo", Context.MODE_PRIVATE );
    }
}

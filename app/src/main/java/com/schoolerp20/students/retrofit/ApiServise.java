package com.schoolerp20.students.retrofit;



import com.schoolerp20.students.modal.Attendenceone;
import com.schoolerp20.students.modal.ClassesMessageOne;
import com.schoolerp20.students.modal.DailyOne;
import com.schoolerp20.students.modal.ExampaperOne;
import com.schoolerp20.students.modal.LiveClassessOne;
import com.schoolerp20.students.modal.Loginone;
import com.schoolerp20.students.modal.PDFone;
import com.schoolerp20.students.modal.PrincipalOne;
import com.schoolerp20.students.modal.SubjectNameOne;
import com.schoolerp20.students.modal.TeacherMessageOne;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServise {

    @GET("/api/student_api.php")
    Observable<Loginone> login(
            @Query("api_key") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );


    @GET("/api/student_api.php")
    Observable<PrincipalOne> pricipalmessage(
            @Query("get_adminmsg") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );

    @GET("/api/student_api.php")
    Observable<TeacherMessageOne> teachermessage(
            @Query("get_teachermsg") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );

    @GET("/api/student_api.php")
    Observable<LiveClassessOne> Liveclassess(
            @Query("new_live_stream") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );

    @GET("/api/student_api.php")
    Observable<LiveClassessOne> getvideo(
            @Query("getvideo") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );



    @GET("/api/student_api.php")
    Observable<PDFone> pdfget(
            @Query("getpdf") String name1,
            @Query("subject_id") String subject_id,
            @Query("user_id") String name2,
            @Query("password") String name3

    );
    @GET("/api/student_api.php")
    Observable<SubjectNameOne> pdfgettwo(
            @Query("getpdfsubject") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );

  /*  @GET("/api/student_api.php")
    Observable<DailyOne> dairyget(
            @Query("st_diary") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );*/

    @GET("/api/student_api.php")
    Observable<DailyOne> dairygettwo(
            @Query( "subject_id" ) String student_diary,
            @Query("student_diary") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );

    @GET("/api/student_api.php")
    Observable<SubjectNameOne> dairyget(
            @Query("st_diary") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );

    @GET("/api/student_api.php")
    Observable<ExampaperOne> exampaper(
            @Query("get_examtype") String name1,
            @Query("user_id") String name2,
            @Query("password") String name3

    );


    @GET("/api/student_api.php")
    Observable<Attendenceone> attendence(
            @Query("user_id") String name1,
            @Query("password") String name2,
            @Query("st_att") String name3

    );


    @FormUrlEncoded
    @POST("/api/login_api.php")
    Observable<ClassesMessageOne> get_teacher_classes(
            @Query("get_teacher_classes") String get_teacher_classes,
            @Field("user_id") String user_id,
            @Field("password") String password

    );
}

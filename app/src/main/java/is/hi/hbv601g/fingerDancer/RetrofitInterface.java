package is.hi.hbv601g.fingerDancer;

import java.util.HashMap;

import is.hi.hbv601g.fingerDancer.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
    // Post-request calls user object and sends name and password
    @POST("/login")
    Call<User> executeLogin(@Body HashMap<String, String> map);
    // Post-request calls void and sends name,email and password
    @POST("/signup")
    Call<Void> executeSignup(@Body HashMap<String, String> map);
    // Logs user out
    @GET("/logout")
    Call<Void> executeLogout();
    // Checks if user is online
    @GET("/usercheck")
    Call<Void> executeUserCheck();
    // Saves Entity-SavedScore to database
    @POST("/savescore")
    Call<Void> executeSaveScore(@Body HashMap<String, String> map);
    // Gets SavedScore from database
    @GET("/getscore")
    Call<SavedScore> executeGetScore(@Body HashMap<String, String> map);
}

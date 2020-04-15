package is.hi.hbv601g.fingerDancer.Services;

import java.util.HashMap;

import is.hi.hbv601g.fingerDancer.Entities.User;
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

    @GET("/logout")
    Call<Void> executeLogout();

    @GET("/usercheck")
    Call<Void> executeUsercheck();
}

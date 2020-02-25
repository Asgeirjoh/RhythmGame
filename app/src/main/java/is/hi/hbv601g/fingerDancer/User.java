package is.hi.hbv601g.fingerDancer;

public class User {
    private int mId;
    private String mUsername;
    private String mPassword;
    private String mEmail;


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public User(String username, String password, String email, int Id){
        mUsername = username;
        mPassword = password;
        mEmail = email;
        mId = Id;
    }

}
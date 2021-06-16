public class User {
    private String userID;
    private String password;
    private String loginStatus;
    
    public User(String userID, String password, String loginStatus) {
        this.userID = userID;
        this.password = password;
        this.loginStatus = loginStatus;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLoginStatus() {
        return loginStatus;
    }
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    public boolean verifyLogin(){
        
        
        return false;
    }
}
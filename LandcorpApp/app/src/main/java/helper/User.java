package helper;

/**
 * Created by Amir on 30-Jan-16.
 */
public class User {
    public final String Username;
    public final String Password;
    public final boolean IsAdmin;
    public final int RoleId;

    public User(String username, String password, int roleId, boolean isAdmin) {
        Username = username;
        Password = password;
        RoleId = roleId;
        IsAdmin = isAdmin;
    }
}
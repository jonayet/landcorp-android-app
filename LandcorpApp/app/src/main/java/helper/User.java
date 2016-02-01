package helper;

/**
 * Created by Amir on 30-Jan-16.
 */
public class User {
    public final String Username;
    public final String Password;
    public final String FullName;
    public final String Title;
    public final boolean IsAdmin;
    public final int RoleId;

    public User(String username, String password, String fullName, String title, int roleId, boolean isAdmin) {
        Username = username;
        Password = password;
        FullName = fullName;
        Title = title;
        RoleId = roleId;
        IsAdmin = isAdmin;
    }
}
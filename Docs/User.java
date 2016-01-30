public class User {
    public final String Username;
    public final String Password;
    public final boolean IsAdmin;
    public final int RoleId;

    User(String username, String password, int roleId, boolean isAdmin) {
        Username = username;
        Password = password;
        RoleId = roleId;
        IsAdmin = isAdmin;
    }
}

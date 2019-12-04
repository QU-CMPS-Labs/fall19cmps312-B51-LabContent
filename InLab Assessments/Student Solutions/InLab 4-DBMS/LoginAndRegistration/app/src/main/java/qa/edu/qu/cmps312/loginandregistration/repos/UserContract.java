package qa.edu.qu.cmps312.loginandregistration.repos;

import android.provider.BaseColumns;

public interface UserContract {
    class UsersTable implements BaseColumns
    {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USER_EMAIL = "user_email";
        public static final String COLUMN_NAME_USER_PASSWORD = "user_password";
        public static final String COLUMN_NAME_USER_NAME = "user_name";
    }
}

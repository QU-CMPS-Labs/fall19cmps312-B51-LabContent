package qa.edu.qu.cmps312.loginandregistration.repos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import qa.edu.qu.cmps312.loginandregistration.models.User;

public class UserDao implements UserContract {

    private UserDBHelper dbHelper;
    private SQLiteDatabase db;

    public UserDao(Context context)
    {
        this.dbHelper = new UserDBHelper(context);
    }
    public long addUser(User user)
    {
        db = dbHelper.getWritableDatabase();

        ContentValues values = changeUserToContentValuesObject(user);

        return db.insert(UsersTable.TABLE_NAME, null, values);
    }
    private ContentValues changeUserToContentValuesObject(User user)
    {
        ContentValues values = new ContentValues();
        values.put(UsersTable.COLUMN_NAME_USER_EMAIL, user.getEmail());
        values.put(UsersTable.COLUMN_NAME_USER_PASSWORD, user.getPassword());
        values.put(UsersTable.COLUMN_NAME_USER_NAME, user.getFullName());
        return values;
    }
    public User getUser(String email) {
        db = dbHelper.getReadableDatabase();
        String columns[] = {UsersTable._ID, UsersTable.COLUMN_NAME_USER_NAME,UsersTable.COLUMN_NAME_USER_EMAIL,UsersTable.COLUMN_NAME_USER_PASSWORD};
        String selection = UsersTable.COLUMN_NAME_USER_EMAIL + " = ?";
        String selectionArgs[] = {email};
        Cursor cursor = db.query(UsersTable.TABLE_NAME, columns, selection, selectionArgs, null, null, null, null);
        if(cursor.moveToFirst()){
            return changeCursorToUser(cursor);
        }else
            return  null;
    }

    public User changeCursorToUser(Cursor cursor){
        int emailIndex = cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_USER_EMAIL);
        int nameIndex = cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_USER_NAME);
        int passIndex = cursor.getColumnIndexOrThrow(UsersTable.COLUMN_NAME_USER_PASSWORD);
        User user = new User(cursor.getString(nameIndex), cursor.getString(emailIndex), cursor.getString(passIndex));
        return user;
    }

}

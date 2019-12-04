package qa.edu.qu.cmps312.loginandregistration.repos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UserDBHelper extends SQLiteOpenHelper implements UserContract {

    public static final String DATABASE_NAME = "usersdb";
    public static final int VERSION = 1;

    //Creating the table
    public static final String SQL_CREATE_TODO_TABLE =
            "CREATE TABLE "+UsersTable.TABLE_NAME+"( "+
                    UsersTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    UsersTable.COLUMN_NAME_USER_NAME+" TEXT, "+
                    UsersTable.COLUMN_NAME_USER_EMAIL+" TEXT, "+
                    UsersTable.COLUMN_NAME_USER_PASSWORD+" TEXT )";

    //doping the table

    public static final String SQL_DELETE_TODO_TABLE =
            "DROP TABLE IF EXISTS '"+UsersTable.TABLE_NAME+"';";

    public UserDBHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_TODO_TABLE);
        onCreate(db);
    }
}

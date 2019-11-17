package su.ac.th.finalexam07600516.UserDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userdata")
public class USER {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "fullname")
    public String fullname;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    public USER( String fullname, String username, String password) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }
}


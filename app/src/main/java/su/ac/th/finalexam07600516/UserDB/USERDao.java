package su.ac.th.finalexam07600516.UserDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface USERDao {
    @Query("SELECT * FROM userdata")
    List<USER> getAllUser();

    @Query("SELECT * FROM userdata where password")
    List<USER> getALLPassword();

    @Insert
    void insertUser(USER user);
}

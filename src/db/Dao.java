package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface Dao<T> {
    Connection conn = DatabaseConn.getConnection();

    T rowToObject(ResultSet res);
    T getById(int id);
    List <T> getTable();

    int insert(T t);
    int update(T t);
    void delete(T t);
}

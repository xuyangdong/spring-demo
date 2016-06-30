package dao;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xyd on 16/6/30.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int getMatchCount(String userName,String password){
        String sqlStr = "select count(*) from t_user where user_name = ? and password = ?";
        return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,password});
    }
    public User findByUserName(final String userName){
        String sqlStr = "select user_id,user_name,credits from t_user where user_name = ?";
        final  User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserid(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }
    public void updateLoginInfo(User user){
        String sqlStr = "update t_user set last_visit=?,credits=? where user_id=?";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastIp(),user.getCredits(),user.getUserid()});
    }
}

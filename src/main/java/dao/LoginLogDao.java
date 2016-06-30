package dao;

import domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by xyd on 16/6/30.
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sqlStr = "inert into t_login_log (user_id,ip,login_datetime) value(?,?,?)";
        jdbcTemplate.update(sqlStr,new Object[]{loginLog.getUserId(),loginLog.getLoginIp(),loginLog.getLoginDate()});
    }

}

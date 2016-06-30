package service;

import dao.LoginLogDao;
import dao.UserDao;
import domain.LoginLog;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by xyd on 16/6/30.
 */
@Service//将UserService标注为一个服务层的bean
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName,String password){
        int mathCount = userDao.getMatchCount(userName,password);
        return mathCount > 0;
    }

    public User findByUserName(String userName){
        return userDao.findByUserName(userName);
    }

    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserid());
        loginLog.setLoginIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}

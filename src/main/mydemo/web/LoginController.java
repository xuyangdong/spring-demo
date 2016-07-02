package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by xyd on 16/7/2.
 */
@Controller
@RequestMapping("/demo")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/index.html")
    public String loginPage(){
        return  "login";
    }

    @RequestMapping(value="/logincheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidatUser = userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if(isValidatUser){
            return new ModelAndView("login","error","用户名或密码错误");
        }else{
            User user = userService.findByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }
}

package com.zwj.Controller;

/**
 * Created by Administrator on 2016/1/7 0007.
 */
import com.zwj.Service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@Controller
public class HomeController {
    private Log log = LogFactory.getLog(getClass());
    @Autowired
    private PersonService aService;

    @Value("${kerberos.killapp.cmd}")   //注入值到变量中
    private String kerberos_killapp_cmd;

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String test(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Model model) throws IOException {
        aService.barA();
        String result = aService.getPersonByMybatis("abc");
        model.addAttribute("message", result);
        return "home";
    }

    @RequestMapping(value = {"/testMybatis"},method = RequestMethod.GET)
    public String testMybatis(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Model model) throws IOException {
        aService.barA();
        String result = aService.getPersonByMybatis("abc");
        model.addAttribute("message", result);
        return "home";
    }

    //  Spring REST webservice
    //  URI:/control/6
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)    //接收大于4的任意数
    public String test5(@PathVariable Integer id,Model model){
        model.addAttribute("message", "hello, world"+id);
        return "test/testREST";
    }

    //  Spring REST+AJAX
    //  URI：/control/check?userName=aaa&password=bbb
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String check(String userName, String password,HttpServletRequest request, HttpServletResponse responsel) {//
        System.out.println(userName+" "+password);
        return userName+" "+password;
    }
}

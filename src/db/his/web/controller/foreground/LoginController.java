package db.his.web.controller.foreground;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lwt on 2015/12/6.
 * 登录服务
 */
@Controller
@RequestMapping("/fore/login")
public class LoginController {

    @ResponseBody
    @RequestMapping
    public Map<String,Object> login(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("error","44");
        return map;
    }
}

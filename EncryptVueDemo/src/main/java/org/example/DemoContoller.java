package org.example;

import com.alibaba.fastjson2.JSONObject;
import org.example.utils.SecretUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderJim
 * @date 2023-04-25 00:24
 */
@RestController
@RequestMapping("/api/demo")
public class DemoContoller {

    @PostMapping("login")
    public Boolean login(@RequestBody(required = true) JSONObject json){

        String passward =  json.getString("passward");

        passward = SecretUtils.desEncrypt(passward);
        System.out.println("passward:"+passward);
        return true;
    }
}

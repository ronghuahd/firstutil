package org.practice.firstutil.templateutil;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ronghua
 * @Date: 2019/10/27
 */
public class HttpTest {

    @Autowired
    private RestTemplate restTemplate;

    public void doExcute(){
        String url="https://www.scominfo.net/SKKJ/appEquipment/appSelectEquipment";
        HttpHeaders headers=new HttpHeaders();
        headers.add("User-Agent","PostmanRuntime/7.16.3");
        Map<String,Object> body=new HashMap<>();
        body.put("substationId",313);
        HttpEntity<Map<String, Object>> mapHttpEntity = new HttpEntity<>(body, headers);


        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.POST, mapHttpEntity, JSONObject.class);
        JSONObject body1 = exchange.getBody();
        System.out.println(JSONObject.toJSONString(body));


    }


}

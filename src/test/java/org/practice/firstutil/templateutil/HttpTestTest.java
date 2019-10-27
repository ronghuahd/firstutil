package org.practice.firstutil.templateutil;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.practice.firstutil.FirstutilApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ronghua
 * @Date: 2019/10/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FirstutilApplication.class})
class HttpTestTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void doExcute(){
        String url="https://www.scominfo.net/SKKJ/appEquipment/appSelectEquipment";
        //如果是parm参数，就直接拼在连接后面？key=value&key2=value2
        HttpHeaders headers=new HttpHeaders();
        headers.add("User-Agent","PostmanRuntime/7.16.3");//请求头参数就这样加
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);//这里设置发送的格式，  json或者form -data等等

        MultiValueMap body = new LinkedMultiValueMap();//这个是放body参数
        body.add("substationId","313");
        HttpEntity<Map<String, Object>> mapHttpEntity = new HttpEntity<>(body, headers);

        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.POST, mapHttpEntity, JSONObject.class);

        System.out.println(JSONObject.toJSONString(exchange));


    }


}
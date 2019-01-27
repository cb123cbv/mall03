package com.jk;

import com.alibaba.fastjson.JSONObject;
import com.jk.utils.HttpUtil;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/26
 * @since 1.0.0
 */
public class HttpTest {

    @ResponseBody
    @RequestMapping(value="voice",produces="application/x-www-form-urlencoded; charset=utf-8")
    public String  voice(String engine_type,String aue,String audio){
        HashMap<String, String> params = new HashMap<>();
        params.put("engine_type",engine_type);
        params.put("aue",aue);
        String doPost1 = HttpUtil.doPost("http://api.xfyun.cn/v1/service/v1/iat ", params, audio);
        JSONObject parseObject= JSONObject.parseObject(doPost1);
        String data = parseObject.getString("data");
        System.out.println(data);
        return  data;
    }

}

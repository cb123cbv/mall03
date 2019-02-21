package com.jk.service;

import com.jk.bean.Mall_Sp;
import com.jk.bean.Users;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
@FeignClient("search")
public interface SearchClientService {
 @RequestMapping("getProduct")
 List<Mall_Sp> getSku(@RequestParam(value = "queryString")String queryString);
}

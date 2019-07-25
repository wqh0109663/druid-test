package top.show.druidtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-7-24 下午11:00
 */
@RestController
public class IndexController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/index")
    public String index(){
        String sql = "select  * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map.get("user_name"));
            return map.get("user_name").toString();
        }
        return "";
    }
}

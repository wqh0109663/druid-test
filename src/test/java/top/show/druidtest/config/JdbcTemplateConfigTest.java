package top.show.druidtest.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-7-24 下午8:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcTemplateConfigTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void jdbcTemplate() {
        String sql = "select  * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            assertNotNull(map.get("user_name"));
            System.out.println(map.get("user_name"));
        }


    }
}
/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.component.customer;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Peerapat A
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private CustomerService service;

    @Before
    public void createDB() {
        jdbc.execute("DROP TABLE IF EXISTS customers");
        jdbc.execute("CREATE TABLE customers(id INT, first_name VARCHAR(16), last_name VARCHAR(16))");

        val split = Stream
                .of("1 John Woo", "2 Jeff Dean", "3 Josh Bloch", "4 Josh Long")
                .map(name -> (Object[]) name.split(" "))
                .collect(Collectors.toUnmodifiableList());

        split.forEach(name -> log.info("Inserting customer record for {} {} {}", name[0], name[1], name[2]));

        jdbc.batchUpdate("INSERT INTO customers(id, first_name, last_name) VALUES (?, ?, ?)"
                , split);
    }

    @Test
    public void testFindById() {
        val o = service.find(1L);

        assert "John Woo".equals(o.get().name) : "Id 1 should be John Woo";
    }

    @Test
    public void testLikeByFirstname() {
        val l = service.likeByFirstname("John");

        assert "John Woo".equals(l.get(0).name) : "Should return John";
    }
}

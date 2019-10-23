/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.component.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Peerapat A
 */
@Component
public class CustomerService {

    private final JdbcTemplate jdbc;

    @Autowired
    CustomerService(final JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Optional<Customer> find(final Long id) {
        return jdbc.query(QUERY_BY_ID
                , (rs, i) -> new Customer(rs.getLong("id"), name(rs))
                , id)
                .stream()
                .findFirst();
    }

    public List<Customer> likeByFirstname(final String firstName) {
        return Collections.unmodifiableList(
                jdbc.query(LIKE_BY_NAME
                        , (rs, i) -> new Customer(rs.getLong("id"), name(rs))
                        , likeFirstName(firstName)));
    }

    private String likeFirstName(final String firstName) {
        return "%" + firstName + "%";
    }

    private String name(final ResultSet rs) throws SQLException {
        return rs.getString("first_name") + " " + rs.getString("last_name");
    }

    private static final String QUERY_BY_ID = "SELECT * FROM CUSTOMERS WHERE ID = ?";
    private static final String LIKE_BY_NAME = "SELECT * FROM CUSTOMERS WHERE FIRST_NAME LIKE ?";

}

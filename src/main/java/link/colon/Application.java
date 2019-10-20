/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Peerapat A on Aug 8, 2019
 */
@ServletComponentScan
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;

/**
 * @author Peerapat A
 */
public class JConverter {

    private static final ObjectMapper om = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());

    public static String toString(final Object o) throws JsonProcessingException {
        return om.writeValueAsString(o);
    }

    public static String toFormatString(final Object o) throws JsonProcessingException {
        return om.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

    public static <T> T toModel(final String o, final Class<T> T) throws IOException {
        return om.readValue(o, T);
    }

}

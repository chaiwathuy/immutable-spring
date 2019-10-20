/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Peerapat A
 */
@Service
public class InfoService {

    private final String version;
    private final String buildDate;

    @Autowired
    InfoService(@Value("${version}") final String version
            , @Value("${build.date}") final String buildDate) {
        this.version = version;
        this.buildDate = buildDate;
    }

    public Version version() {
        return new Version(version, buildDate);
    }

}

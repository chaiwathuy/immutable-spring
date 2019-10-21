/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/** @author Peerapat A */
@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties("build")
public class InfoService {

  private final String version;
  private final String date;

  public Version version() {
    return new Version(version, date);
  }
}

/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.controller;

import link.colon.component.InfoService;
import link.colon.component.Version;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Peerapat A */
@Slf4j
@RestController
@RequiredArgsConstructor
class RootController {

  private final InfoService info;

  @GetMapping("/version")
  public Version version() {
    return info.version();
  }
}

/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.controller;

import link.colon.component.InfoService;
import link.colon.component.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Peerapat A
 */
@Slf4j
@RestController
public class RootController {

    private final InfoService info;

    @Autowired
    public RootController(final InfoService info) {
        this.info = info;
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public Version health() {
        return info.version();
    }

}

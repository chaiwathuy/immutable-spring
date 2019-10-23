/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon.controller;

import link.colon.component.info.Version;
import link.colon.utility.JConverter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class VersionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getVersion() throws Exception {
        val builder = MockMvcRequestBuilders
                .get("/version");
        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        val v = JConverter.toModel(body, Version.class);

        assert v.equals(new Version("0", "today"));
    }

}
package org.ok.bella;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ApplicationTest {

    @Test
    public void shouldLoadContext() {
        log.info("Loading context");
    }
}
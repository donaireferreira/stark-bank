package br.com.starkbank.invoice.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class WebhookLogTest {

    @Test
    void testWebhookLog() {
        WebhookLog log = new WebhookLog();
        log.setId("111111");
        log.setType("paid");
        log.setBoleto(new WebhookBoleto());
        log.setCreated(new Date());

        assertNotNull(log.getCreated());
        assertEquals("111111", log.getId());
        assertNotNull(log.getBoleto());
        assertEquals("paid", log.getType());
    }
}

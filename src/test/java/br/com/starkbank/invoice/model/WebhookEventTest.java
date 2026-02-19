package br.com.starkbank.invoice.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WebhookEventTest {

    @Test
    void testWebhookEvent() {

        WebhookEvent event = new WebhookEvent();
        event.setId("12244");
        event.setCreated(new Date());
        event.setLog(new WebhookLog());
        event.setDelivered(true);
        event.setSubscription("ssss ssss");

        assertEquals("12244", event.getId());
        assertTrue(event.isDelivered());
        assertNotNull(event.getLog());
        assertNotNull(event.getCreated());
        assertEquals("ssss ssss", event.getSubscription());

    }
}

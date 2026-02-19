package br.com.starkbank.invoice.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class WebhookModelTest {

    @Test
    void testWebhookModel() {
        WebhookModel model = new WebhookModel();
        model.setEvent(new WebhookEvent());

        assertNotNull(model.getEvent());
    }
}

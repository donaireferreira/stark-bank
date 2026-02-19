package br.com.starkbank.invoice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WebhookEvent {
    private String id;
    private String subscription;
    private boolean isDelivered;
    private Date created;
    private WebhookLog log;
}

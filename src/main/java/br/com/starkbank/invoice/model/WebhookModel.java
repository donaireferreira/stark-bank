package br.com.starkbank.invoice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebhookModel {
    private WebhookEvent event;
}

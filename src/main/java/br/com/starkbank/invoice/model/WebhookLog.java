package br.com.starkbank.invoice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class WebhookLog {
     private String id;
     private Date created;
     private String type;
     private WebhookBoleto boleto;
}

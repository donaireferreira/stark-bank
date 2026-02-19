package br.com.starkbank.invoice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class WebhookBoleto {
    private String taxId;
    private long overdueLimit;
    private double fine;
    private String id;
    private String city;
    private long fee;
    private String streetLine2;
    private String district;
    private String streetLine1;
    private Date due;
    private String workspaceId;
    private double interest;
    private String status;
    private ArrayList<String> tags;
    private String zipCode;
    private String line;
    private String name;
    private Date created;
    private String barCode;
    private long amount;
    private String stateCode;

}
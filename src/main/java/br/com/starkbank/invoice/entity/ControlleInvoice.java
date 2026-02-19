package br.com.starkbank.invoice.entity;

import br.com.starkbank.invoice.enums.StatusInvoice;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_invoice_control")
@Getter
@Setter
public class ControlleInvoice {

    @Id
    private String taxId;

    private Date invoiceDate;

    private long amount;

    private String status;

    private String name;
}

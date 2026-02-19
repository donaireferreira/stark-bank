package br.com.starkbank.invoice.entity;

import br.com.starkbank.invoice.enums.StatusInvoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ControlleInvoiceTest {

    @Test
    void testControlleInvoice() {

        ControlleInvoice invoice = new ControlleInvoice();
        invoice.setInvoiceDate(new Date());
        invoice.setStatus(StatusInvoice.EMITIDA);
        invoice.setName("Stark Bank");
        invoice.setAmount(40000);
        invoice.setTaxId("22222222222");

        assertNotNull(invoice.getInvoiceDate());
        assertEquals(StatusInvoice.EMITIDA, invoice.getStatus());
        assertEquals("Stark Bank", invoice.getName());
        assertEquals(40000, invoice.getAmount());
        assertEquals("22222222222", invoice.getTaxId());

    }

}

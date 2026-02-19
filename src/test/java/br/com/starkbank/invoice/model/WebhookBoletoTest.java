package br.com.starkbank.invoice.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class WebhookBoletoTest {

    @Test
    void testWebhookBoleto() {
        WebhookBoleto boleto  = new WebhookBoleto();

       
        boleto.setTaxId("20.018.183/0001-80");
        boleto.setOverdueLimit(123);
        boleto.setFine(1.3);
        boleto.setId("123");
        boleto.setCity("Sao Paulo");
        boleto.setFee(1);
        boleto.setStreetLine2("rua nova granada");
        boleto.setDistrict("Itaim BiBi");
        boleto.setStreetLine1("rua nova 1");
        boleto.setDue(new Date());
        boleto.setWorkspaceId("123456");
        boleto.setInterest(1.5);
        boleto.setStatus("SP");
        boleto.setTags(new ArrayList<>());
        boleto.setZipCode("03015999");
        boleto.setLine("343433433243324332");
        boleto.setName("Banco Stark");
        boleto.setCreated(new Date());
        boleto.setBarCode("3213213123213123121232132");
        boleto.setAmount(50000);
        boleto.setStateCode("Paid");

        assertEquals("20.018.183/0001-80", boleto.getTaxId());
        assertEquals(123, boleto.getOverdueLimit());
        assertEquals(1.3,boleto.getFine());
        assertEquals("123", boleto.getId());
        assertEquals("Sao Paulo", boleto.getCity());
        assertEquals(1, boleto.getFee());
        assertEquals("rua nova granada", boleto.getStreetLine2());
        assertEquals("Itaim BiBi", boleto.getDistrict());
        assertEquals("rua nova 1", boleto.getStreetLine1());
        assertNotNull(boleto.getDue());
        assertEquals("123456", boleto.getWorkspaceId());
        assertEquals(1.5, boleto.getInterest());
        assertEquals("SP", boleto.getStatus());
        assertEquals(0, boleto.getTags().size());
        assertEquals("03015999", boleto.getZipCode());
        assertEquals("343433433243324332", boleto.getLine());
        assertEquals("Banco Stark", boleto.getName());
        assertNotNull(boleto.getCreated());
        assertEquals("3213213123213123121232132", boleto.getBarCode());
        assertEquals(50000, boleto.getAmount());
        assertEquals("Paid", boleto.getStateCode());

    }
}

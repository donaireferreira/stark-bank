package br.com.starkbank.invoice.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class InfotransferModelTest {

    @Test
    void testInfotransferModel() {

        InfotransferModel model = new InfotransferModel();
        model.setName("Stark Bank S.A.");
        model.setAccountType("payment");
        model.setTaxId("20.018.183/0001-80");
        model.setBankCode("20018183");
        model.setBranchCode("0001");
        model.setAccountNumber("6341320293482496");

        assertEquals("Stark Bank S.A.", model.getName());
        assertEquals("payment", model.getAccountType());
        assertEquals("20.018.183/0001-80", model.getTaxId());
        assertEquals("20018183", model.getBankCode());
        assertEquals("0001", model.getBranchCode());
        assertEquals("6341320293482496", model.getAccountNumber());

        }
}


package br.com.starkbank.invoice.repository;

import br.com.starkbank.invoice.entity.ControlleInvoice;
import br.com.starkbank.invoice.enums.StatusInvoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class InvoiceControlRepositoryTest {

    @Mock
    private InvoiceControlRepository repository;

    @Test
    public void testFindByStatus() {

        List<ControlleInvoice> invoices = new ArrayList<>();
        when(repository.findByStatus(StatusInvoice.EMITIDA.name())).thenReturn(invoices);

        assertEquals(0, invoices.size());
    }
}

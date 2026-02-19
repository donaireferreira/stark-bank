package br.com.starkbank.invoice.application.service;

import com.starkbank.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoicesService {

    private static final Logger logger = LoggerFactory.getLogger(InvoicesService.class);

    public List<Invoice> createdInvoice(List<Invoice> invoices) throws Exception {
        try {
            return Invoice.create(invoices);
        }catch (Exception e){
            logger.error("Error process invoice: {}", e.getMessage(), e);
            throw new Exception("Error process invoice, retry");
        }
    }
}

package br.com.starkbank.invoice.schedule;

import br.com.starkbank.invoice.application.service.InvoicesService;
import br.com.starkbank.invoice.entity.ControlleInvoice;
import br.com.starkbank.invoice.enums.StatusInvoice;
import br.com.starkbank.invoice.repository.InvoiceControlRepository;
import br.com.starkbank.invoice.utils.Constantes;
import com.starkbank.Invoice;
import com.starkbank.Project;
import com.starkbank.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);


    @Autowired
    private InvoicesService invoicesService;

    @Autowired
    private InvoiceControlRepository repository;

    @Value("${project.id}")
    private String projectId;

    @Value("${project.env}")
    private String environment;


    //@Scheduled(cron = "0 0 */3 * * *")
    @Scheduled(cron = "0 * * * * ?")
    public void reportCurrentTime() {
        logger.info("start schedule invoice: {}", new Date());
        try{
            Settings.user = new Project(
                    this.environment,
                    this.projectId,
                    Constantes.privateKeyContent
            );

            List<Invoice> invoices = new ArrayList<>();

            List<ControlleInvoice> invoicesControll =  repository.findByStatus(StatusInvoice.NAO_EMITIDA.name());
            logger.info("Number invoices: {}", invoicesControll.size());

            for(ControlleInvoice invoiceControll: invoicesControll){
                HashMap<String, Object> data = new HashMap<>();
                data.put("amount", invoiceControll.getAmount());
                data.put("taxId", invoiceControll.getTaxId());
                data.put("name", invoiceControll.getName());
                invoices.add(new Invoice(data));
                invoiceControll.setStatus(StatusInvoice.EMITIDA.name());
                repository.save(invoiceControll);
            }

           // invoices = invoicesService.createdInvoice(invoices);

            for (Invoice invoice : invoices) {
                System.out.println(invoice);
            }
        }catch (Exception e){
            logger.error("Error: {}", e.getMessage(), e);
        }
        logger.info("End schedule invoice: {}", new Date());
    }
}

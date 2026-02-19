package br.com.starkbank.invoice.controller;

import br.com.starkbank.invoice.entity.ControlleInvoice;
import br.com.starkbank.invoice.repository.InvoiceControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoiceControl")
public class InvoiceControlController {

    @Autowired
    private InvoiceControlRepository repository;

    @GetMapping()
    public ResponseEntity<List<ControlleInvoice>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{taxId}")
    public ResponseEntity<Optional<ControlleInvoice>> findById(@PathVariable String taxId){
        return ResponseEntity.ok(repository.findById(taxId));
    }

    @PostMapping()
    public ControlleInvoice createInvoiceControl(@RequestBody ControlleInvoice invoiceControll) {
      return repository.save(invoiceControll);
    }
}

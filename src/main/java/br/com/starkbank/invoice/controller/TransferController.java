package br.com.starkbank.invoice.controller;

import br.com.starkbank.invoice.application.service.TransferService;
import br.com.starkbank.invoice.model.InfotransferModel;
import br.com.starkbank.invoice.model.WebhookModel;
import com.starkbank.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/transfer")
public class TransferController {

    @Autowired
    private TransferService service;

    @Autowired
    private InfotransferModel infotransferModel;

    private static final Logger logger = LoggerFactory.getLogger(TransferController.class);

    @PostMapping()
    public ResponseEntity<String> callbackTransfer(@RequestBody WebhookModel webhookModel) {
        logger.info("Receive call back webhook");
        try{
            List<Transfer> transfers = new ArrayList<>();

            if(webhookModel != null &&
                    webhookModel.getEvent() != null &&
                    webhookModel.getEvent().getLog()!= null){

                if(webhookModel.getEvent().getLog().getType() != null && webhookModel.getEvent().getLog().getType().equals("paid")){
                    HashMap<String, Object> data = new HashMap<>();
                    data.put("amount", webhookModel.getEvent().getLog().getBoleto().getAmount());
                    data.put("bankCode", infotransferModel.getBankCode());
                    data.put("branchCode", infotransferModel.getBranchCode());
                    data.put("accountNumber", infotransferModel.getAccountNumber());
                    data.put("taxId", infotransferModel.getTaxId());
                    data.put("name", infotransferModel.getName());
                    data.put("accountType", infotransferModel.getAccountType());

                    transfers.add(new Transfer(data));
                    service.createdTransfer(transfers);

                    return new ResponseEntity<String>("Sucess", HttpStatus.CREATED);
                }
            }
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

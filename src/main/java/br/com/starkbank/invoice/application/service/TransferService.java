package br.com.starkbank.invoice.application.service;

import com.starkbank.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);
    public void createdTransfer(List<Transfer> transfers) throws Exception {
        try {
            Transfer.create(transfers);
        }catch (Exception e){
            logger.error("Error send transfer:{}", e.getMessage(), e);
            throw new Exception("Error to send transfers");
        }
    }
}

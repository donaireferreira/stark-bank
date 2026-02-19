package br.com.starkbank.invoice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Configuration
public class InfotransferModel {

    @Value("${infos.bankCode}")
    private String bankCode;
    @Value("${infos.branchCode}")
    private String branchCode;
    @Value("${infos.accountNumber}")
    private String accountNumber;
    @Value("${infos.taxId}")
    private String taxId;
    @Value("${infos.name}")
    private String name;
    @Value("${infos.accountType}")
    private String accountType;
}


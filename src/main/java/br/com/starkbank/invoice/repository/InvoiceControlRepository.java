package br.com.starkbank.invoice.repository;

import br.com.starkbank.invoice.entity.ControlleInvoice;
import br.com.starkbank.invoice.enums.StatusInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceControlRepository extends JpaRepository<ControlleInvoice, String> {

    @Query(value = "SELECT * FROM tb_invoice_control where status = :status LIMIT 10", nativeQuery = true)
    List<ControlleInvoice> findByStatus(@Param("status") String status);
}

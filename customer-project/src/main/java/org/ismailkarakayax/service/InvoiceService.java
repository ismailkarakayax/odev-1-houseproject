package org.ismailkarakayax.service;

import org.ismailkarakayax.entity.Invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
    private final List<Invoice> invoices = new ArrayList<>();

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> findAllInvoices() {
        return Collections.unmodifiableList(invoices);
    }

    public List<Invoice> findInvoicesWithTotalAmountGreaterThan(double amount) {
        return invoices.stream()
                .filter(invoice -> invoice.getTotalPrice() > amount)
                .toList();
    }

}

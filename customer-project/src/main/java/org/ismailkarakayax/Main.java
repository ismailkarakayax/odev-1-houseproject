package org.ismailkarakayax;

import org.ismailkarakayax.entity.Customer;
import org.ismailkarakayax.entity.Invoice;
import org.ismailkarakayax.entity.Order;
import org.ismailkarakayax.service.CustomerService;
import org.ismailkarakayax.service.InvoiceService;
import org.ismailkarakayax.util.MockData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        CustomerService customerService = new CustomerService();
        InvoiceService invoiceService = new InvoiceService();

        // Mock datayı yükle
        List<Customer> mockCustomers = MockData.getCustomerList();
        List<Invoice> mockInvoices = MockData.getInvoiceList();

        // Servislere mock datayı enjekte et
        mockCustomers.forEach(customerService::addCustomer);
        mockInvoices.forEach(invoiceService::addInvoice);

        // Tüm müşterileri listele
        System.out.println("Tüm Müşteriler:");
        customerService.findAllCustomers().forEach(System.out::println);

        // Yeni müşteri oluştur
        Scanner scanner = new Scanner(System.in);
        customerService.addCustomer(createNewCustomer(scanner));
        System.out.println("Yeni Kayıttan sonra Tüm Müşteriler:");
        customerService.findAllCustomers().forEach(System.out::println);

        // 'C' harfi içeren müşterileri listele
        System.out.println("\nİçerisinde 'C' Harfi Olan Müşteriler:");
        customerService.findCustomersWithNameContainingC().forEach(System.out::println);

        // Haziran ayında kayıt olan müşterileri listele
        List<Customer> juneCustomers = customerService.findAllCustomers().stream()
                .filter(customer -> customer.getCreatedAt().getMonthValue() == 6)
                .toList();
        System.out.println("\nHaziran Ayında Kayıt Olan Müşteriler:");
        juneCustomers.forEach(System.out::println);

        // Haziran ayında kayıt olan müşterilerin fatura toplam tutarını listeleyin
        double totalAmountForJuneCustomers = invoiceService.findAllInvoices().stream()
                .filter(invoice -> juneCustomers.contains(invoice.getOrder().getCustomer()))
                .mapToDouble(Invoice::getTotalPrice)
                .sum();
        System.out.println("\nHaziran Ayında Kayıt Olan Müşterilerin Toplam Fatura Tutarı: " + totalAmountForJuneCustomers);

        // Sistemdeki tüm faturaları listele
        System.out.println("\nTüm Faturalar:");
        invoiceService.findAllInvoices().forEach(System.out::println);

        // Sistemdeki 1500TL üstündeki faturaları listele
        System.out.println("\n1500 TL Üstündeki Faturalar:");
        invoiceService.findInvoicesWithTotalAmountGreaterThan(1500.0).forEach(System.out::println);

        // Sistemdeki 1500TL üstündeki faturaları ortalamasını hesapla
        double averageHighValueInvoice = invoiceService.findInvoicesWithTotalAmountGreaterThan(1500.0).stream()
                .mapToDouble(Invoice::getTotalPrice)
                .average()
                .orElse(0.0);
        System.out.println("\n1500 TL Üstündeki Faturaların Ortalaması: " + averageHighValueInvoice);



        // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimlerini listele
        List<Customer> customersWithLowValueInvoices = invoiceService.findAllInvoices().stream()
                .filter(invoice -> invoice.getTotalPrice() < 500.0)
                .map(invoice -> invoice.getOrder().getCustomer())
                .toList();
        System.out.println("\n500 TL Altındaki Faturalara Sahip Müşterilerin İsimleri:");
        customersWithLowValueInvoices.forEach(customer -> System.out.println(customer.getName()));




    }

    private static Customer createNewCustomer(Scanner scanner) {
        System.out.println("Yeni Müşteri Oluşturma");
        System.out.println("Ad: ");
        String name = scanner.next();
        System.out.println("Soyad: ");
        String surname = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Telefon Numarası: ");
        String phoneNumber = scanner.next();
        System.out.println("Sektör: ");
        String sector = scanner.next();


        return new Customer(name, surname, email, phoneNumber, sector, LocalDate.now());
    }
}
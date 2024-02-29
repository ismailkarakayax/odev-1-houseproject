package org.ismailkarakayax.util;

import org.ismailkarakayax.entity.Customer;
import org.ismailkarakayax.entity.Invoice;
import org.ismailkarakayax.entity.Order;
import org.ismailkarakayax.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class MockData {

    private static final List<Customer> CUSTOMER_LIST = new ArrayList<>();
    private static final List<Invoice> INVOICE_LIST = new ArrayList<>();

    static {
        mockData();
    }

    private MockData() {
    }
    public static List<Customer> getCustomerList() {
        return CUSTOMER_LIST;
    }
    public static List<Invoice> getInvoiceList() {
        return INVOICE_LIST;
    }
    private static void mockData() {




        // Create mock data for Customer
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer();
            customer.setName("CustomerName" + i);
            customer.setSurname("CustomerSurname" + i);
            customer.setEmail("customer" + i + "@example.com");
            customer.setPhoneNumber("123-456-789" + i);
            customer.setSector("Sector" + i);

            // Set creation date to June for some customers
            if (i % 2 == 0) {
                customer.setCreatedAt(LocalDate.of(2024, 6, i));
            } else {
                customer.setCreatedAt(LocalDate.now());
            }

            // Create mock data for Order
            List<Product> products = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                Product product = new Product();
                product.setProductName("Product" + j);
                product.setPrice(10.0 * j);
                products.add(product);
            }

            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);



            // Create mock data for Invoice
            Invoice invoice = new Invoice();
            invoice.setOrder(order);
            invoice.setTotalPrice(50.0 * i);

            // Add to lists
            CUSTOMER_LIST.add(customer);
            INVOICE_LIST.add(invoice);
        }

        // Additional mock data for invoices with specific amounts
        // Sistemdeki 1500TL üstündeki faturaları listeleyin
        Invoice highAmountInvoice1 = new Invoice(new Order(), 1600.0);
        INVOICE_LIST.add(highAmountInvoice1);

        Invoice highAmountInvoice2 = new Invoice(new Order(), 1700.0);
        INVOICE_LIST.add(highAmountInvoice2);

        // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin
        Customer lowAmountCustomer1 = new Customer("LowAmountCustomer1", "Surname1", "low1@example.com", "123", "Sector1", LocalDate.now());
        Order lowAmountOrder1 = new Order();
        lowAmountOrder1.setCustomer(lowAmountCustomer1);
        Invoice lowAmountInvoice1 = new Invoice(lowAmountOrder1, 400.0);
        CUSTOMER_LIST.add(lowAmountCustomer1);
        INVOICE_LIST.add(lowAmountInvoice1);

        Customer lowAmountCustomer2 = new Customer("LowAmountCustomer2", "Surname2", "low2@example.com", "456", "Sector2", LocalDate.now());
        Order lowAmountOrder2 = new Order();
        lowAmountOrder2.setCustomer(lowAmountCustomer2);
        Invoice lowAmountInvoice2 = new Invoice(lowAmountOrder2, 300.0);
        CUSTOMER_LIST.add(lowAmountCustomer2);
        INVOICE_LIST.add(lowAmountInvoice2);
    }
}

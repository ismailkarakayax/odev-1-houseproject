package org.ismailkarakayax.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity{
    Customer customer;
    private List<Product> products;


    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", products=" + products +
                "} " + super.toString();
    }
}

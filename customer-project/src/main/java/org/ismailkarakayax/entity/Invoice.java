package org.ismailkarakayax.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseEntity {
    private Order order;
    private double totalPrice;


    @Override
    public String toString() {
        return "Invoice{" +
                "order=" + order +
                ", totalPrice=" + totalPrice +
                "} " + super.toString();
    }
}
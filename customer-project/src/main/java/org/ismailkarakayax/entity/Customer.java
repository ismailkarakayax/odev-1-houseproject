package org.ismailkarakayax.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String sector;
    private LocalDate createdAt;



    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sector='" + sector + '\'' +
                ", createdAt=" + createdAt +
                "} " + super.toString();
    }
}
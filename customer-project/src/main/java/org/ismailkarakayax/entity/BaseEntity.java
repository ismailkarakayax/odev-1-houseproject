package org.ismailkarakayax.entity;

public abstract class BaseEntity {
    private static int counter = 1;

    final int id;

    BaseEntity() {
        this.id = counter++;
    }


}

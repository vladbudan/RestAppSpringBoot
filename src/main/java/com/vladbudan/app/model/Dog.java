package com.vladbudan.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "dog")
@DiscriminatorValue(value = "dog_type")
public class Dog extends Pet {

    private String color;
}

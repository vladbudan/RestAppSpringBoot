package com.vladbudan.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "cat")
@DiscriminatorValue(value = "cat_type")
public class Cat extends Pet{

    private String gender;

}
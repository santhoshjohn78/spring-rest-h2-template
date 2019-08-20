package com.ehss.springresth2template;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SampleEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String value;

    @Override
    public String toString() {
        return "SampleEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    public SampleEntity() {
        // This is stupid that JPA errors out without default constructor
    }

    public SampleEntity(String value) {
        this.value = value;
    }

    public SampleEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

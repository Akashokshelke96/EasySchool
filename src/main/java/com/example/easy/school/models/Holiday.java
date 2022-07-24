package com.example.easy.school.models;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Table(name="holidays")
public class Holiday extends BaseEntity {


    @Id
    private String day;

    private String reason;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        FESTIVAL, FEDERAL
    }
}

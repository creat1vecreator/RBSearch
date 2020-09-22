package com.dreamteam.rbsearch.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity(name = "bank_list_table") // name of data table
@AllArgsConstructor
@NoArgsConstructor
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private String app;

}
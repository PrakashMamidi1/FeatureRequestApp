package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Feature {

    /*
    Title: A short, descriptive name of the feature request.
Description: A long description of the feature request.
Client: A selection list of clients (use "Client A", "Client B", "Client C")
Client Priority: The feature's priority number according to the client (1...n). Client Priority numbers should not repeat for the given client, so if a priority is set on a new feature as "1", then all other feature requests for that client should be adjusted.
Target Date: The date that the client is hoping to have the feature.
Product Area: A selection list of product areas (use 'Policies', 'Billing', 'Claims', 'Reports')

     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private int priority;

    private LocalDate targetDate;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private String area;


    public Feature(String title, String description, String client, int priority, LocalDate targetDate, String area) {
        this.title = title;
        this.description = description;
        this.client = client;
        this.priority = priority;
        this.targetDate = targetDate;
        this.createDate = new Date();
        this.area = area;
    }

    public Feature() {

    }
}


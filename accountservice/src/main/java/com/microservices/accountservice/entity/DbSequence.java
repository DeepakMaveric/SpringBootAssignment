package com.microservices.accountservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.jmx.export.annotation.ManagedAttribute;

@Document(collection = "db_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequence {
    private String id;
    private int seq;
}

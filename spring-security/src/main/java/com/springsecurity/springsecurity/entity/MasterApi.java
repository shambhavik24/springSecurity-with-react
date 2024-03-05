package com.springsecurity.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="masterTables")
public class MasterApi {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long serialNumber;
    private String companyName;
    private double petrolRate;
    private double diselRate;
}

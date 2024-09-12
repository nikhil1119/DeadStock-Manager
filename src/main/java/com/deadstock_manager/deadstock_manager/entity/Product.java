package com.deadstock_manager.deadstock_manager.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean scrap;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date scrapOnDate;
    private String category;
    private String type;
    public String description;
    private String dsrNo;
    private int quantity;
    private int labDsrPageNo;
    private int labDsrSrNo;
    private int ddsrPageNo;
    private String ddsrSrNo;
    private String cdsrRegNo;
    private int cdsrPageNo;
    private int cdsrSrNo;
    private String centralDeadstockDescription;
    private String supplierName;
    private String PONo;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date PODate;
    private String invoiceNo;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date invoiceDate;
    private double amount;
    private String remarks;
    private String purchaseForLab;
    private String permanentlyTransferToLab;
    private String roomNo;
}

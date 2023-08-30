package com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "outlets")
public class Outlet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int outletId;
    private String name;
    private String contactPerson;
    private String mobile;
    private String address;
    private double salesPerMonth;
    private String outletKey;
    private String channelId;
    private boolean displayed = true; // default value is true
    private double paidAmount = 0; // default value is 0.0
    private String creditSalesId;
    private String businessType;

    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;
}

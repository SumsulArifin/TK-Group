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
@Table(name = "outlet_amendments")
public class OutletAmendment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String englishName;
    @Column(nullable = false)
    private String banglaName;
    private String englishAddress;
    private String banglaAddress;
    @Column(nullable = false)
    private String contactPerson;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false)
    private String businessType;
    private int salesPerMonth=0;
    private String outletKey;
    private String shopSign;
    private int creditSales=0;
    private String comments;
    private double shopSignAmount;
    private double latitude;
    private double longitude;
    private int channelId =0;
    private String salesGroup;
    private int marketSize =0;

    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;
    @ManyToOne
    @JoinColumn(name = "soId")
    private SalesOfficer salesOfficer;
}

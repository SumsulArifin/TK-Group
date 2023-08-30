package com.tkgroupbd.pusti.api.data.models.entity.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesOfficer;
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
@Table(name = "dailyOrdersSummary")
public class DailyOrdersSummary extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numberOfSkus;
    private String numberOfCategories;
    private double ccp;
    private double lpc;

    @ManyToOne
    @JoinColumn(name = "assignedSoId")
    private SalesOfficer salesOfficer;

}

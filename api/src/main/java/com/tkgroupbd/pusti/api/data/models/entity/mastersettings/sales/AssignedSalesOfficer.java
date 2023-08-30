package com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assigned_sales_officers")
public class AssignedSalesOfficer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int assignedId;
    private int soId;

    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;

}

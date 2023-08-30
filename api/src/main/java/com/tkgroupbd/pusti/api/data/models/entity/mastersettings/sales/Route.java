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
@Table(name = "Routes")
public class Route extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeId;
    private String name;
    private String assignedDistributorId;

    @ManyToOne
    @JoinColumn(name = "zoneId")
    private Zone zone;

}

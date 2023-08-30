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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "zones")
public class Zone extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int zoneId;
    private String zoneName;
    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;

}

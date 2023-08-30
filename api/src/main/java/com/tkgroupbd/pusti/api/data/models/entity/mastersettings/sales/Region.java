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
@Table(name = "Regions")
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int regionId;
    private String regionName;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division division;

}

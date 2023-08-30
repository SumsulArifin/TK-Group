package com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "sales_officer")
public class SalesOfficer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int assignedSoId;
    private String soName;

}

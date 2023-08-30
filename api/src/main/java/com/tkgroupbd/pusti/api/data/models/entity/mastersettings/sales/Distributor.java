package com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Table(name = "Distributors")
public class Distributor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int distributor_id;
    private int depot_id;
    private String name;
    private String erp_id;
    private String proprietor_name;
    private String proprietor_dob;
    private String mobile;
    private String address;
    private String has_pc;
    private String has_printer;
    private String has_live_app;
    private String has_direct_sale;
    private String opening_date;
    private String emergency_contact_name;
    private String emergency_contact_number;
    private String emergency_person_relation;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}

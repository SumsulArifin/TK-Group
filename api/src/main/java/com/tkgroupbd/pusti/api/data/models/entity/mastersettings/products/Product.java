package com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products;

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
@Table(name = "product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String name;
    private String bengaliName;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}

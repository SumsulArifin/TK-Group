package com.tkgroupbd.pusti.api.data.repositories.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

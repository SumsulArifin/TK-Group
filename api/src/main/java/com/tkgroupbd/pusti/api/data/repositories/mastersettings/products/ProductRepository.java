package com.tkgroupbd.pusti.api.data.repositories.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Product;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.ProductRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p,d,m,pr from Product p  , ProductItem d, ProductMeta m, ProductPrice pr Where p.productId=d.product.productId and   p.productId = m.product.productId   and d.sku = pr.sku and p.productId=?1")
    public List<Object> findAllInformations(int id);

    @Query(value = "select p,d,m,pr from Product p  , ProductItem d, ProductMeta m, ProductPrice pr Where p.productId=d.product.productId and   p.productId = m.product.productId   and d.sku = pr.sku")
    public List<Object[]> findAllProducts();


}

package com.momentum.momentum.persitence.repository;
import com.momentum.momentum.persitence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByCode(final String name);

    List<ProductEntity> findByCodeIn(final List<String> name);
}

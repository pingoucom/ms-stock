package br.imd.ufrn.webII.msstockLB.repository;

import br.imd.ufrn.webII.msstockLB.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

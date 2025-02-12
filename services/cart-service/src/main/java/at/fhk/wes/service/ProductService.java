package at.fhk.wes.service;

import at.fhk.wes.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@FeignClient("product-service")
public interface ProductService {
    @PutMapping("/products/block")
    void blockProducts(@RequestBody Set<Product> products);

    @PutMapping("/products/release")
    void releaseProducts(@RequestBody Set<Product> products);
}

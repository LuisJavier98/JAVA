package org.example.Service;

import org.example.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.Repository.ProductoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductoRepository productoRepository;

    public Product saveProduct(Product product) {
        return productoRepository.save(product);
    }

    public List<Product> getProducts() {
        return productoRepository.findAll();
    }

    public Optional<Product> getProduct(int id) {
        return productoRepository.findById(id);
    }

    public Optional<Product> getProductByName(String name) {
        return productoRepository.findByName(name);
    }

    public void deleteProduct(int id) {
        productoRepository.deleteById(id);
    }

    public Product actualizarProducto(Product product) {
        Product existe = productoRepository.findById(product.getIdproducto()).orElse(null);
        existe.setName(product.getName());
        existe.setQuantity(product.getQuantity());
        existe.setPrice(product.getPrice());
        productoRepository.save(existe);
        return existe;
    }
}

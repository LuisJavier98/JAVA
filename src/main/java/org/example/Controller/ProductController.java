package org.example.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Ingresa un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ingreso de producto exitoso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))
            }),
            @ApiResponse(responseCode = "400",description = "Objeto de producto invalido",content = @Content),
            @ApiResponse(responseCode = "404",description = "Producto no encontrado",content = @Content)
    })
    @PostMapping("/agregarProducto")
    public Product agregarProducto(@RequestBody Product product) {
        if (product.getName().equals("") || product.getPrice() == 0 || product.getQuantity() == 0) {
            System.out.println(product.getPrice());
            throw new RuntimeException("Campos incompletos");
        }
        return productService.saveProduct(product);
    }

    ;

    @GetMapping("/")
    public List<Product> obtenerProductos() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> obtenerProducto(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/buscarpornombre/{name}")
    public Optional<Product> obtenerPorductoByNombre(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PatchMapping("/modificarProducto")
    public Product modificarProducto(@RequestBody Product product) {
        return productService.actualizarProducto(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String eliminarProducto(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Eliminado correctamente";
    }

};

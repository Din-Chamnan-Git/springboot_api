package com.learn.pro1.service.impl;

import com.learn.pro1.dto.request.ProductRequestDTO;
import com.learn.pro1.dto.response.ProductResponseDTO;
import com.learn.pro1.entity.Brand;
import com.learn.pro1.entity.Category;
import com.learn.pro1.entity.Product;
import com.learn.pro1.entity.Supplier;
import com.learn.pro1.mapper.ProductMapper;
import com.learn.pro1.repository.BrandRepository;
import com.learn.pro1.repository.CategoryRepository;
import com.learn.pro1.repository.ProductRepository;
import com.learn.pro1.repository.SupplierRepository;
import com.learn.pro1.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final BrandRepository brandRepository;
    private final ProductMapper ProductMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository, BrandRepository brandRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
        this.brandRepository = brandRepository;
        ProductMapper = productMapper;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {


        Product product = ProductMapper.toEntity(productRequestDTO); // convert dto to entity for save

        Category category = categoryRepository.findById(productRequestDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        product.setCategory(category);


        Brand brand = brandRepository.findById(productRequestDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand Not Found"));

        product.setBrand(brand);

//        if(productRequestDTO.getSupplierIds() != null  && !productRequestDTO.getSupplierIds().isEmpty()){
//            List<Supplier> suppliers = supplierRepository.findAllById(productRequestDTO.getSupplierIds());
//            product.setSuppliers(suppliers);
//        }

//        //brand query
//        Brand b = brandRepository.findById(productRequestDTO.getBrandId())
//                .orElseThrow( () -> new RuntimeException("Brand Not Found"));
//
//        product.setBrand(b);

        productRepository.save(product);

        return ProductMapper.toDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductMapper.toDTO(products);
    }

//    @Override
//    public List<ProductResponseDTO> getAllProducts() {
//
//        List<ProductResponseDTO> p ;
//
//        p = productRepository.findAll().stream()
//                .map(ProductMapper::toDTO)
//                .toList();
//        return p;
//    }

//    //get product by id
//    public Optional<Product> getProductById(Long id){
//        return productRepository.findById(id);
//    }
//
//    //get all products
//    public List<Product> getAllProducts(){
//        return productRepository.findAll();
//    }
//
//    // update product by id
//    public Optional<Product> updateProduct(Long id ,  Product product){
//        return productRepository.findById(id)
//                .map(pro -> {
//                    pro.setName(product.getName());
//                    pro.setDescription(product.getDescription());
//                    pro.setPrice(product.getPrice());
//                    return productRepository.save(pro);
//                });
//    }
//
//
//    // delete product by id
//    public boolean deleteProductById(Long id){
//        boolean found = productRepository.existsById(id);
//
//        if(found){
//            productRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
}

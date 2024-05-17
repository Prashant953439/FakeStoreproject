package dev.prashant.productservicemorning.services;

import dev.prashant.productservicemorning.models.Category;
import dev.prashant.productservicemorning.models.Product;
import dev.prashant.productservicemorning.repositories.CategoryRepository;
import dev.prashant.productservicemorning.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        return productRepository.findByIdIs(productId)  ;
    }

    @Override
    public List<Product> getProduct(String category) {

        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
       Product product = new Product();
       product.setTitle(title);
       product.setDescription(description);
       product.setPrice(price);
       product.setImageUrl(image);
        Category categoryFromDatabase = categoryRepository.findByTitle(category);

        if(categoryFromDatabase == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);
  //          categoryFromDatabase = categoryRepository.save(newCategory);
            categoryFromDatabase = newCategory;

        }
        product.setCategory(categoryFromDatabase);

        Product savedProduct = productRepository.save(product);
        return  savedProduct;  

    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return null;
    }

    @Override
    public List<Category> getCategory() {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}

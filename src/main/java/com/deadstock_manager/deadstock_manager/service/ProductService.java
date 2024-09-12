package com.deadstock_manager.deadstock_manager.service;

import com.deadstock_manager.deadstock_manager.entity.Product;
import com.deadstock_manager.deadstock_manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> searchProductByDsrNo(String dsrNo) {
        return productRepository.findByDsrNoContainingIgnoreCase(dsrNo);
    }

    // Search by type
    public List<Product> searchProductByType(String type) {
        return productRepository.findByTypeContainingIgnoreCase(type);
    }

    // Search by roomNo
    public List<Product> searchProductByRoomNo(String roomNo) {
        return productRepository.findByRoomNoContainingIgnoreCase(roomNo);
    }

    // Search by category
    public List<Product> searchProductByCategory(String category) {
        return productRepository.findByCategoryContainingIgnoreCase(category);
    }

    public boolean deleteProduct(List<Product> products) {
        if(!products.isEmpty()){
            for(Product it : products){
                List<Product> product = searchProductByDsrNo(it.getDsrNo());
                productRepository.deleteById(product.getFirst().getId());
            }
            return true;
        }
        return false;
    }

    public Product updateProduct(Product updatedProduct) {

        Product product=productRepository.findById(updatedProduct.getId()).orElse(null);

        if(product!=null)
        {

            product.setScrap(updatedProduct.isScrap());
            product.setScrapOnDate(updatedProduct.getScrapOnDate());
            product.setCategory(updatedProduct.getCategory());
            product.setType(updatedProduct.getType());
            product.setDescription(updatedProduct.getDescription());
            product.setDsrNo(updatedProduct.getDsrNo());
            product.setQuantity(updatedProduct.getQuantity());
            product.setLabDsrPageNo(updatedProduct.getLabDsrPageNo());
            product.setLabDsrSrNo(updatedProduct.getLabDsrSrNo());
            product.setDdsrPageNo(updatedProduct.getDdsrPageNo());
            product.setDdsrSrNo(updatedProduct.getDdsrSrNo());
            product.setCdsrRegNo(updatedProduct.getCdsrRegNo());
            product.setCdsrPageNo(updatedProduct.getCdsrPageNo());
            product.setCdsrSrNo(updatedProduct.getCdsrSrNo());
            product.setCentralDeadstockDescription(updatedProduct.getCentralDeadstockDescription());
            product.setSupplierName(updatedProduct.getSupplierName());
            product.setPONo(updatedProduct.getPONo());
            product.setPODate(updatedProduct.getPODate());
            product.setInvoiceNo(updatedProduct.getInvoiceNo());
            product.setInvoiceDate(updatedProduct.getInvoiceDate());
            product.setAmount(updatedProduct.getAmount());
            product.setRemarks(updatedProduct.getRemarks());
            product.setPurchaseForLab(updatedProduct.getPurchaseForLab());
            product.setPermanentlyTransferToLab(updatedProduct.getPermanentlyTransferToLab());
            product.setRoomNo(updatedProduct.getRoomNo());
            return productRepository.save(product);
        }
        return null;
    }

}

package logic;

import java.util.List;

import dao.ProductDAO;
import lombok.extern.slf4j.Slf4j;
import vo.Product;

@Slf4j
public class ProductLogic {
    
    ProductDAO productDAO;
    
    public List<Product> selectProduct() {
        
        productDAO = new ProductDAO();
        
        List<Product> productList = productDAO.selectProduct();
        
        return productList;
        
    }
    
    public String jsonProduct() {
        
        productDAO = new ProductDAO();
        
        String jsonProduct = productDAO.jsonProduct();
        
        return jsonProduct;
    }
    
    public String selectProductWithID( Product product ) {
        
        productDAO = new ProductDAO();
        
        String jsonProduct = productDAO.selectProductWithID( product );
        
        return jsonProduct;
    }
    
    public int insertProduct( Product product ) {
        productDAO = new ProductDAO();
        
        log.info( product.toString() );
        int result = productDAO.insertProduct( product );
        
        return result;
    }
    
    public int updateProduct( Product product ) {
        productDAO = new ProductDAO();
        
        log.info( product.toString() );
        int result = productDAO.updateProduct( product );
        
        return result;
    }
    
    public int deleteProduct( Product product ) {
        productDAO = new ProductDAO();
        
        log.info( product.toString() );
        int result = productDAO.deleteProduct( product );
        
        return result;
    }
    
}

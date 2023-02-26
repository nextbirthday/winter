package productbbs.logic;

import java.math.BigDecimal;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import productbbs.dto.Product;

@Log4j2
public class ProductLogic {
    
    ProductDAO dao = new ProductDAO();
    
    public int insertProduct( Product product ) {
        
        int result = dao.insertProduct( product );
        
        return result;
    }
    
    public List<Product> selectProduct() {
        
        return dao.selectProduct();
    }
    
    public String jsonProduct() {
        return dao.jsonProductList();
    }
    
    public int updateProduct( Product product ) {
        
        int result = dao.updateProduct( product );
        
        return result;
    }
    
    public int deleteProduct( Product product ) {
        
        int result = dao.deleteProduct( product );
        
        return result;
        
    }
    
    public static void main( String[] args ) {
        log.info( BigDecimal.ZERO );
    }
}

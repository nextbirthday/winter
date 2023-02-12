package productbbs.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import lombok.extern.log4j.Log4j2;
import productbbs.dto.Product;
import productbbs.util.MyBatisSessionFactory;

@Log4j2( topic = "product" )
public class ProductDAO {
   
    SqlSessionFactory sqlSessionFactory;
    SqlSession        sqlSession;
    
    public int insertProduct( Product product ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.insert( "insertProduct", product );
        if ( result > 0 )
            sqlSession.commit();
        return result;
    }
    
    public List<Product> selectProduct() {
        
        List<Product> productList = new ArrayList<>();
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        productList = sqlSession.selectList( "selectProductList" );
        productList.forEach( e -> log.info( e ) );
        
        return productList;
    }
    
    public Product selectOne( Product productcode ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        Product product = sqlSession.selectOne( "selectProduct", productcode );
        
        log.info( product );
        return product;
    }
    
    public int updateProduct( Product product ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.update( "updateProduct", product );
        
        log.info( result );
        return result;
    }
    
    public static void main( String[] args ) {
        ProductDAO dao = new ProductDAO();
        Product product = new Product( 100, "a", "b", 199, 2999 );
        int     result  = dao.insertProduct( product );
    }
}

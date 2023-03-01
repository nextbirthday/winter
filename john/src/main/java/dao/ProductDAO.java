package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;

import common.MyBatisSessionFactory;
import lombok.extern.slf4j.Slf4j;
import vo.Product;

@Slf4j
public class ProductDAO {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Product> selectProduct() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Product> productList = sqlSession.selectList( "product.selectProduct" );
        
        productList.forEach( e -> log.info( e.toString() ) );
        
        return productList;
    }
    
    public String jsonProduct() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Product> productList = sqlSession.selectList( "product.selectProduct" );
        
        Gson   gson        = new Gson();
        String jsonProduct = gson.toJson( productList );
        
        log.info( jsonProduct );
        
        return jsonProduct;
    }
    
    public String selectProductWithID( Product product ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Product> productList = sqlSession.selectList( "product.selectProductWithID", product );
        Gson          gson        = new Gson();
        String        jsonProduct = gson.toJson( productList );
        
        return jsonProduct;
    }
    
    public int insertProduct( Product product ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        log.info( product.toString() );
        
        int result = sqlSession.insert( "product.insertProduct", product );
        
        log.info( String.valueOf( result ) );
        
        if ( result > 0 )
            sqlSession.commit();
        
        return result;
    }
    
    public int updateProduct( Product product ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.update( "updateProduct", product );
        
        log.info( String.valueOf( result ) );
        
        return result;
    }
    
    public int deleteProduct( Product product ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.delete( "deleteProduct", product );
        return result;
    }
    
}

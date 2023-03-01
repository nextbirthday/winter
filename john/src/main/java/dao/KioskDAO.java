package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.MyBatisSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;
import vo.Customer;

@Slf4j
public class KioskDAO {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Customer> getCustomerPaymentList( Customer customer ) {
        
        String resource = "kiosk-config.xml";
        sqlSessionFactory = MyBatisSqlSessionFactory.getInstance( resource );
        sqlSession = sqlSessionFactory.openSession();
        
        try {
            List<Customer> list = sqlSession.selectList( "getCustomerPaymentList", customer );
            sqlSession.close();
            return list;
        }
        catch ( Exception e ) {
            log.error( "{}", e );
            return null;
        }
    }
}

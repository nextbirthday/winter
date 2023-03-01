package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBatisSessionFactory {
    
    private static SqlSessionFactory sqlSessionFactory;
    
    private MyBatisSessionFactory() {}
    
    public static synchronized SqlSessionFactory getInstance() {
        
        if ( sqlSessionFactory == null ) {
            
            try {
                final String resource    = "mybatis-config.xml";
                InputStream  inputStream = Resources.getResourceAsStream( resource );
                sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
            }
            catch ( IOException e ) {
                log.error( "데이터베이스 연결 실패 : ", e );
            }
        }
        return sqlSessionFactory;
    }
    
}

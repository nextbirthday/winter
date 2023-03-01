package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;

import common.MyBatisSessionFactory;
import vo.Emp;

public class EmpDAO {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Emp> getEmpList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Emp> empList = sqlSession.selectList( "emp.getEmpList" );
        
        return empList;
        
    }
    
    public String jsonEmpList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Emp> empList = sqlSession.selectList( "emp.getEmpList" );
        
        Gson   gson        = new Gson();
        String jsonEmpList = gson.toJson( empList );
        
        return jsonEmpList;
    }
}

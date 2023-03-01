package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;

import common.MyBatisSessionFactory;
import vo.Dept;

public class DeptDAO {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Dept> getDeptList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Dept> getDeptList = sqlSession.selectList( "dept.getDeptList" );
        
        return getDeptList;
    }
    
    public String jsonDeptList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Dept> getDeptList = sqlSession.selectList( "dept.getDeptList" );
        
        Gson gson = new Gson();
        
        String jsonDeptList = gson.toJson( getDeptList );
        
        return jsonDeptList;
    }
    
}

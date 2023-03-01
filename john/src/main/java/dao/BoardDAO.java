package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;

import common.MyBatisSessionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardDAO {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Map<String, Object>> getBoardList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Map<String, Object>> boardList = sqlSession.selectList( "board.getBoardList", null );
        
        return boardList;
    }
    
    public String jsonBoardList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Map<String, Object>> boardList = sqlSession.selectList( "board.getBoardList", null );
        
        Gson   gson          = new Gson();
        String jsonBoardList = gson.toJson( boardList );
        
        return jsonBoardList;
    }
    
    public int boardInsert() {
        int result = -1;
        
        return result;
    }
    
}

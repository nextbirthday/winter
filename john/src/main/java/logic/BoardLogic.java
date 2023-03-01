package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.BoardDAO;

public class BoardLogic {
    
    BoardDAO boardDAO = null;
    
    public List<Map<String, Object>> getBoardList() {
        
        boardDAO = new BoardDAO();
        
        List<Map<String, Object>> boardList = new ArrayList<>();
        
        return boardList = boardDAO.getBoardList();
        
    }
    
    public String jsonBoardList() {
        
        boardDAO = new BoardDAO();
        
        String jsonBoardList = null;
        
        return jsonBoardList = boardDAO.jsonBoardList();
    }
    
}

package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import logic.BoardLogic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardController implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        ActionForward actionForward = new ActionForward();
        BoardLogic    boardLogic    = null;
        
        String[] task = ( String[] ) req.getAttribute( "task" );
        String   path = null;
        boolean  send = true; // true이면 sendRedirect false이면 forward
        
        if ( "getBoardList".equals( task[1] ) ) {
            boardLogic = new BoardLogic();
            List<Map<String, Object>> boardList = boardLogic.getBoardList();
            req.setAttribute( "boardList", boardList );
            
            path = "getBoardList.jsp";
            send = false;
        }
        else if ( "jsonBoardList".equals( task[1] ) ) {
            
            boardLogic = new BoardLogic();
            String jsonBoardList = boardLogic.jsonBoardList();
            
            req.setAttribute( "jsonBoardList", jsonBoardList );
            path = "jsonBoardList.jsp";
            send = false;
        }
        else if ( "boardInsert".equals( task[1] ) ) {
            boardLogic = new BoardLogic();
        }
        else if ( "boardUpdate".equals( task[1] ) ) {
            boardLogic = new BoardLogic();
        }
        else if ( "boardDelete".equals( task[1] ) ) {
            boardLogic = new BoardLogic();
        }
        
        actionForward.setPath( path );
        actionForward.setSend( send );
        
        log.info( "path = " + path + ", send = " + send );
        return actionForward;
    }
    
}

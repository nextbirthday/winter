package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import logic.DeptLogic;
import lombok.extern.slf4j.Slf4j;
import vo.Dept;

@Slf4j
public class DeptController implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        ActionForward actionForward = new ActionForward();
        DeptLogic     deptLogic     = null;
        
        String[] task = ( String[] ) req.getAttribute( "task" );
        String   path = null;
        boolean  send = true; // true이면 sendRedirect false이면 forward
        
        if ( "getDeptList".equals( task[1] ) ) {
            deptLogic = new DeptLogic();
            List<Dept> deptList = deptLogic.getDeptList();
            req.setAttribute( "deptList", deptList );
            
            path = "getDeptList.jsp";
            send = false;
        }
        else if ( "jsonDeptList".equals( task[1] ) ) {
            
            deptLogic = new DeptLogic();
            String jsonDeptList = deptLogic.jsonDeptList();
            
            req.setAttribute( "jsonDeptList", jsonDeptList );
            path = "jsonDeptList.jsp";
            send = false;
        }
        else if ( "boardInsert".equals( task[1] ) ) {
            deptLogic = new DeptLogic();
        }
        else if ( "boardUpdate".equals( task[1] ) ) {
            deptLogic = new DeptLogic();
        }
        else if ( "boardDelete".equals( task[1] ) ) {
            deptLogic = new DeptLogic();
        }
        
        actionForward.setPath( path );
        actionForward.setSend( send );
        
        log.info( "path = " + path + ", send = " + send );
        return actionForward;
    }
    
}

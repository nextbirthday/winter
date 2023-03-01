package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import logic.EmpLogic;
import lombok.extern.slf4j.Slf4j;
import vo.Emp;

@Slf4j
public class EmpController implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        ActionForward actionForward = new ActionForward();
        EmpLogic      empLogic      = null;
        
        String[] task = ( String[] ) req.getAttribute( "task" );
        String   path = null;
        boolean  send = true; // true이면 sendRedirect false이면 forward
        
        if ( "getEmpList".equals( task[1] ) ) {
            empLogic = new EmpLogic();
            List<Emp> empList = empLogic.getEmpList();
            req.setAttribute( "empList", empList );
            path = "getEmpList.jsp";
            send = false;
        }
        else if ( "jsonEmpList".equals( task[1] ) ) {
            empLogic = new EmpLogic();
            String jsonEmpList = empLogic.jsonEmpList();
            req.setAttribute( "jsonEmpList", jsonEmpList );
            path = "jsonEmpList.jsp";
            send = false;
        }
        else if ( "empInsert".equals( task[1] ) ) {
            
        }
        else if ( "empUpdate".equals( task[1] ) ) {
            
        }
        else if ( "empDelete".equals( task[1] ) ) {
            
        }
        
        actionForward.setPath( path );
        actionForward.setSend( send );
        
        log.info( "path = " + path + ", send = " + send );
        return actionForward;
    }
    
}

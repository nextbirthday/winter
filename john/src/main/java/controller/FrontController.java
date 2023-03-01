package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import lombok.extern.slf4j.Slf4j;

@Slf4j( topic = "servlet" )
@WebServlet( "*.do" )
public class FrontController extends HttpServlet {
    
    private void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doService" );
        String uri     = req.getRequestURI();
        String context = req.getContextPath();
        String command = uri.substring( context.length() + 1 );
        
        int end = command.lastIndexOf( "." );
        command = command.substring( 0, end );
        
        String[] task = command.split( "/" );
        
        for ( String index : task ) {
            log.info( index );
        }
        
        req.setAttribute( "task", task );
        
        ActionForward actionForward = null;
        
        if ( "board".equals( task[0] ) ) {
            BoardController boardController = new BoardController();
            actionForward = boardController.execute( req, res );
        }
        else if ( "emp".equals( task[0] ) ) {
            EmpController empController = new EmpController();
            actionForward = empController.execute( req, res );
        }
        else if ( "dept".equals( task[0] ) ) {
            DeptController deptController = new DeptController();
            actionForward = deptController.execute( req, res );
        }
        else if ( "kiosk".equals( task[0] ) ) {
            KioskController kioskController = new KioskController();
            actionForward = kioskController.execute( req, res );
        }
        else if ( "product".equals( task[0] ) ) {
            ProductController productController = new ProductController();
            actionForward = productController.execute( req, res );
        }
        
        if ( actionForward != null ) {
            
            if ( actionForward.isSend() ) {
                res.sendRedirect( actionForward.getPath() );
            }
            else {
                RequestDispatcher view = req.getRequestDispatcher( actionForward.getPath() );
                view.forward( req, res );
            }
            
        }
        
    }
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        doService( req, res );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        doService( req, res );
    }
}

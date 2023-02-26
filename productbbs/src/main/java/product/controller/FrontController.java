package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;
import productbbs.util.ActionForward;

@WebServlet( "*.kh" )
@SuppressWarnings( "serial" )
@Log4j2
public class FrontController extends HttpServlet {
    
    protected void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doService 호출" );
        
        String uri = req.getRequestURI();
        log.info( uri );
        
        String context = req.getContextPath();
        log.info( context );
        
        String command = uri.substring( context.length() + 1 );
        log.info( command );
        
        int end = command.lastIndexOf( "." );
        log.info( end );
        
        command = command.substring( 0, end );
        log.info( command );
        
        String[] task = command.split( "/" );
        
        ActionForward     actionForward     = null;
        ProductController productController = null;
        
        req.setAttribute( "task", task );
        
        for ( String index : task ) {
            log.info( index );
        }
        
        if ( "product".equals( task[0] ) ) {
            productController = new ProductController();
            
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

package product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;
import productbbs.dto.Product;
import productbbs.logic.ProductLogic;
import productbbs.util.Action;
import productbbs.util.ActionForward;

@Log4j2
public class ProductController implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        
        ActionForward actionForward = new ActionForward();
        ProductLogic  productLogic  = new ProductLogic();
        Product       product       = null;
        
        String  path = null;
        boolean send = true; // false는 forward true면 sendRedirect
        
        String[] task = ( String[] ) req.getAttribute( "task" );
        
        if ( "selectProduct".equals( task[1] ) ) {
            log.info( "task[1] = selectProduct" );
            List<Product> productList = productLogic.selectProduct();
            
            req.setAttribute( "productList", productList );
            log.info( productList );
            
            // PrintWriter writer = res.getWriter();
            // writer.print( productList );
            path = "selectProduct.jsp";
            send = false;
        }
        else if ( "jsonSelect".equals( task[1] ) ) {
            String jsonList = productLogic.jsonProduct();
            req.setAttribute( "jsonList", jsonList );
            path = "jsonProduct.jsp";
            send = false;
        }
        else if ( "insertProduct".equals( task[1] ) ) {
            product = new Product();
            product.setId( Integer.parseInt( req.getParameter( "id" ) ) );
            product.setCategory( req.getParameter( "category" ) );
            product.setName( req.getParameter( "name" ) );
            product.setPrice( Integer.parseInt( req.getParameter( "price" ) ) );
            product.setStock( Integer.parseInt( req.getParameter( "stock" ) ) );
            
            log.info( product );
            
            int result = productLogic.insertProduct( product );
        }
        else if ( "updateProduct".equals( task[1] ) ) {
            product = new Product();
            product.setId( Integer.parseInt( req.getParameter( "id" ) ) );
            product.setCategory( req.getParameter( "category" ) );
            product.setName( req.getParameter( "name" ) );
            product.setPrice( Integer.parseInt( req.getParameter( "price" ) ) );
            product.setStock( Integer.parseInt( req.getParameter( "stock" ) ) );
            
            log.info( product );
            
            int result = productLogic.updateProduct( product );
        }
        
        actionForward.setPath( path );
        actionForward.setSend( send );
        
        return actionForward;
    }
    
}

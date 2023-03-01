package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import logic.ProductLogic;
import lombok.extern.slf4j.Slf4j;
import vo.Product;

@Slf4j
public class ProductController implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        ActionForward actionForward = new ActionForward();
        ProductLogic  productLogic  = null;
        Product       product       = null;
        
        String[] task = ( String[] ) req.getAttribute( "task" );
        String   path = null;
        boolean  send = true; // true이면 sendRedirect false이면 forward
        
        if ( "selectProduct".equals( task[1] ) ) {
            productLogic = new ProductLogic();
            List<Product> productList = productLogic.selectProduct();
            req.setAttribute( "productList", productList );
            path = "selectProduct.jsp";
            send = false;
        }
        else if ( "jsonProduct".equals( task[1] ) ) {
            productLogic = new ProductLogic();
            String jsonProduct = productLogic.jsonProduct();
            req.setAttribute( "jsonProduct", jsonProduct );
            path = "jsonProduct.jsp";
            send = false;
        }
        else if ( "selectProductWithID".equals( task[1] ) ) {
            productLogic = new ProductLogic();
            product = new Product();
            product.setId( Integer.parseInt( req.getParameter( "id" ) ) );
            
            String jsonProduct = productLogic.selectProductWithID( product );
            
            req.setAttribute( "jsonProduct", jsonProduct );
            path = "jsonProduct.jsp";
            send = false;
        }
        else if ( "insertProduct".equals( task[1] ) ) {
            productLogic = new ProductLogic();
            
            product = new Product();
            product.setId( Integer.parseInt( req.getParameter( "id" ) ) );
            product.setCategory( req.getParameter( "category" ) );
            product.setName( req.getParameter( "name" ) );
            product.setPrice( Integer.parseInt( req.getParameter( "price" ) ) );
            product.setStock( Integer.parseInt( req.getParameter( "stock" ) ) );
            
            log.info( product.toString() );
            
            int result = productLogic.insertProduct( product );
            
            log.info( String.valueOf( result ) );
            
            path = "productView.jsp";
        }
        else if ( "updateProduct".equals( task[1] ) ) {
            productLogic = new ProductLogic();
            
            product = new Product();
            product.setId( Integer.parseInt( req.getParameter( "id" ) ) );
            product.setCategory( req.getParameter( "category" ) );
            product.setName( req.getParameter( "name" ) );
            product.setPrice( Integer.parseInt( req.getParameter( "price" ) ) );
            product.setStock( Integer.parseInt( req.getParameter( "stock" ) ) );
            
            log.info( product.toString() );
            
            int result = productLogic.updateProduct( product );
        }
        else if ( "deleteProduct".equals( task[1] ) ) {
            productLogic = new ProductLogic();
        }
        
        actionForward.setPath( path );
        actionForward.setSend( send );
        
        log.info( "path = " + path + ", send = " + send );
        return actionForward;
    }
    
}

package productbbs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;
import productbbs.dto.Product;
import productbbs.logic.ProductDAO;

@SuppressWarnings( "serial" )
@WebServlet( "/insertProcuct" )
@Log4j2
public class InsertProduct extends HttpServlet {
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        ProductDAO dao     = new ProductDAO();
        Product    product = new Product();
        product.setId( Integer.parseInt( req.getParameter( "id" ) ) );
        product.setCategory( req.getParameter( "category" ) );
        product.setName( req.getParameter( "name" ) );
        product.setPrice( Integer.parseInt( req.getParameter( "price" ) ) );
        product.setStock( Integer.parseInt( req.getParameter( "stock" ) ) );
        log.info( product );
        
        dao.insertProduct( product );
    }
}

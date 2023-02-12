package productbbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;
import productbbs.dto.Product;
import productbbs.logic.ProductDAO;

@SuppressWarnings( "serial" )
@WebServlet( "/products" )
@Log4j2
public class ProductController extends HttpServlet {
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setCharacterEncoding( "UTF-8" );
        ProductDAO    dao      = new ProductDAO();
        List<Product> tempList = dao.selectProduct();
        PrintWriter   writer   = resp.getWriter();
        writer.print( toJson( tempList ) );
    }
    
    public String toJson( List<Product> list ) {
        Gson   gson   = new Gson();
        String result = gson.toJson( list );
        log.info( result );
        return result;
    }
}

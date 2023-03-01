package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import logic.KioskLogic;
import lombok.extern.slf4j.Slf4j;
import vo.Customer;

@Slf4j
public class KioskController extends HttpServlet implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        ActionForward actionForward = new ActionForward();
        KioskLogic    kioskLogic    = null;
        
        String[] task = ( String[] ) req.getAttribute( "task" );
        String   path = null;
        boolean  send = true; // true이면 sendRedirect false이면 forward
        
        if ( "getCustomerPaymentList".equals( task[1] ) ) {
            kioskLogic = new KioskLogic();
            
            Customer customer = new Customer();
            customer.setCustomer_id( Integer.parseInt( req.getParameter( "customer_id" ) ) );
            
            String customerList = kioskLogic.getCustomerPaymentList( customer );
            req.setAttribute( "customerList", customerList );
            path = "jsonCustomerList.jsp";
            send = false;
        }
        
        actionForward.setPath( path );
        actionForward.setSend( send );
        
        log.info( "path = " + path + ", send = " + send );
        return actionForward;
    }
    
}

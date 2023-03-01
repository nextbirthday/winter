package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dao.KioskDAO;
import lombok.extern.slf4j.Slf4j;
import vo.Customer;
import vo.Payment;

@Slf4j
public class KioskLogic {
    
    KioskDAO kioskDAO;
    
    public String getCustomerPaymentList( Customer customer ) {
        kioskDAO = new KioskDAO();
        
        List<Customer> list = kioskDAO.getCustomerPaymentList( customer );
        
        log.info( list.toString() );
        
        String customerList = toJson( list );
        return customerList;
    }
    
    private String toJson( List<Customer> list ) {
        
        List<Map<String, Object>> tempList = new ArrayList<>();
        Map<String, Object>       tempMap;
        Gson                      gson     = new Gson();
        
        for ( Customer customer : list ) {
            
            for ( Payment payment : customer.getPayments() ) {
                tempMap = new HashMap<>();
                tempMap.put( "customer_id", customer.getCustomer_id() );
                tempMap.put( "store_id", customer.getStore_id() );
                tempMap.put( "first_name", customer.getFirst_name() );
                tempMap.put( "last_name", customer.getLast_name() );
                tempMap.put( "email", customer.getEmail() );
                tempMap.put( "address_id", customer.getAddress_id() );
                tempMap.put( "active", customer.getActive() );
                tempMap.put( "create_date", customer.getCreate_date() );
                tempMap.put( "payment_id", payment.getPayment_id() );
                tempMap.put( "staff_id", payment.getStaff_id() );
                tempMap.put( "rental_id", payment.getRental_id() );
                tempMap.put( "amount", payment.getAmount() );
                tempMap.put( "payment_date", payment.getPayment_date() );
                tempMap.put( "last_update", payment.getLast_update() );
                tempList.add( tempMap );
            }
        }
        
        return gson.toJson( tempList );
    }
}

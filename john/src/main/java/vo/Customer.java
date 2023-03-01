package vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
    private int           customer_id;
    private int           store_id;
    private String        first_name;
    private String        last_name;
    private String        email;
    private int           address_id;
    private int           active;
    private String        create_date;
    private String        last_update;
    private Payment       payment;
    private List<Payment> payments;
}

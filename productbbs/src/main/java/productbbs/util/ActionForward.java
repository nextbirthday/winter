package productbbs.util;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
public class ActionForward {
   
    private String  path;
    private boolean send;
    
}

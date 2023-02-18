package productbbs.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentTime {
    
    public static void main( String[] args ) {
        
        // SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSSX" );
        // Calendar now = Calendar.getInstance();
        //
        // Date now2 = Calendar.getInstance().getTime();
        //
        // System.out.println( "now = " + now + "\n" );
        // System.out.println( "now2 = " + now2 + "\n" );
        // System.out.println( format.format( now.getTime() ).toString() );
        
        SimpleDateFormat format2 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSSX" );
        System.out.println( "format2 = " + format2 );
        
        Calendar now = Calendar.getInstance();
        System.out.println( "format2 = " + format2.format( now.getTime() ).toString() );
               
    }
}

package vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Emp {
    
    private int    empno;
    private String ename;
    private String job;
    private int    mgr;
    private Date   hiredate;
    private int    salary;
    private int    comm;
    private int    deptno;
}

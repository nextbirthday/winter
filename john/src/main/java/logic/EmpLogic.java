package logic;

import java.util.List;

import dao.EmpDAO;
import vo.Emp;

public class EmpLogic {
    
    EmpDAO empDAO;
    
    public List<Emp> getEmpList() {
        
        empDAO = new EmpDAO();
        
        List<Emp> empList = empDAO.getEmpList();
        
        return empList;
    }
    
    public String jsonEmpList() {
        
        empDAO = new EmpDAO();
        String jsonEmpList = empDAO.jsonEmpList();
        
        return jsonEmpList;
    }
}

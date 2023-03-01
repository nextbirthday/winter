package logic;

import java.util.ArrayList;
import java.util.List;

import dao.DeptDAO;
import vo.Dept;

public class DeptLogic {
    
    DeptDAO deptDAO;
    
    public List<Dept> getDeptList() {
        
        deptDAO = new DeptDAO();
        
        List<Dept> deptList = new ArrayList<>();
        
        deptList = deptDAO.getDeptList();
        
        return deptList;
    }
    
    public String jsonDeptList() {
        
        deptDAO = new DeptDAO();
        
        String jsonDeptList = deptDAO.jsonDeptList();
        
        return jsonDeptList;
    }
}

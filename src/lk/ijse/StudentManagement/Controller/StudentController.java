/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import java.io.IOException;
import java.util.List;
import lk.ijse.StudentManagement.Bussines.StudentBO;
import lk.ijse.StudentManagement.DTO.StudentDTO;

/**
 *
 * @author Sachinda Nipun
 */
public class StudentController {
    
    private StudentBO studentBO;

    public StudentController() {
        this.studentBO = new StudentBO();
    }
    
    public boolean saveStudent(StudentDTO studentDTO) throws Exception{
        System.out.println(studentDTO.getAddress());
        return studentBO.saveStudent(studentDTO);
    }
    
    public  List<StudentDTO> getAllStudents() throws IOException{
        return studentBO.getAllStudent();
    }
    
     public  StudentDTO searchStudent(String Sid) throws IOException{
        return studentBO.searchStudent(Sid);
    }
    
    public boolean deletrStudent(String Sid) throws IOException{
        return studentBO.deletrStudent(Sid);
        
    }
}

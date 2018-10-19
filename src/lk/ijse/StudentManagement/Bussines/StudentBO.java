/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Bussines;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.StudentManagement.DAO.StudentDAO;
import lk.ijse.StudentManagement.DTO.StudentDTO;

/**
 *
 * @author Sachinda Nipun
 */
public class StudentBO {
    
    private final StudentDAO studentDAO;

    public StudentBO() {
        this.studentDAO = new StudentDAO();
    }
    
    public boolean saveStudent(StudentDTO studentDTO) throws Exception{
        System.out.println(studentDTO.getAddress());
            return studentDAO.writeFile(studentDTO);
       
    }
    
    public List<StudentDTO> getAllStudent() throws IOException{
        System.out.println(studentDAO.getAllStudent());
        return studentDAO.getAllStudent();
    }
    
    public  StudentDTO searchStudent(String Sid) throws IOException{
        return studentDAO.searchStudent(Sid);
    }
    
    public boolean deletrStudent(String Sid) throws IOException{
        return studentDAO.deleteStudent(Sid);
        
    }
}

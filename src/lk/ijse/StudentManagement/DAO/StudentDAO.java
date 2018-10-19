/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.DAO;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lk.ijse.StudentManagement.DTO.StudentDTO;

/**
 *
 * @author Sachinda Nipun
 */
public class StudentDAO {
    
    private static final File file = new File("F:/StudentManagement/registration");
    
    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    public boolean writeFile(StudentDTO studentDTO) throws Exception {
        
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
        }
        //rwLock.writeLock().lock();
        String data = "";
        data += studentDTO.getStudentID() + " ";
        data += studentDTO.getStudentNAme() + " ";
        data += studentDTO.getAddress() + " ";
        data += studentDTO.getBirtday() + " ";
        data += studentDTO.getContact() + " ";
        data += studentDTO.getCourse();
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            return true;
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
         //   rwLock.writeLock().unlock();
        }
    
    }

   public static List<StudentDTO> getAllStudent() throws FileNotFoundException, IOException  {
        BufferedReader reader = null;
        List<StudentDTO> studentDTOs = new ArrayList<>();
        try {
            
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setStudentID(data[0]);
                studentDTO.setStudentNAme(data[1]);
                studentDTO.setAddress(data[2]);
                studentDTO.setBirtday(data[3]);
                studentDTO.setContact(data[4]);
                studentDTO.setCourse(data[5]);

                studentDTOs.add(studentDTO);
                System.out.println(studentDTO);
            }
            return studentDTOs;
        } finally {
            if (reader != null) {
                reader.close();
            }
           
        }
    }
   
   

    public static boolean deleteStudent(String sid) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            List<String> fileData = new ArrayList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (!data[0].equals(sid)) {
                    fileData.add(line);
                }
            }

            FileWriter fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);
            for (String lineData : fileData) {
                writer.write(lineData);
                writer.newLine();
            }
            return isStudentAvailable(sid);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
           
        }
    }

    
    

    public static StudentDTO searchStudent(String sid) throws FileNotFoundException, IOException {
        BufferedReader reader = null;
        StudentDTO studentDTO = null;
        try {

            
            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data[0].equals(sid)) {
                studentDTO = new StudentDTO();
                studentDTO.setStudentID(data[0]);
                studentDTO.setStudentNAme(data[1]);
                studentDTO.setAddress(data[2]);
                studentDTO.setBirtday(data[3]);
                studentDTO.setContact(data[4]);
                studentDTO.setCourse(data[5]);

                }
            }
            return studentDTO;
        } finally {
            if (reader != null) {
                reader.close();
            }
            
        }
    }

    

    private static boolean isStudentAvailable(String cid) throws IOException, FileNotFoundException{
       StudentDTO studentDTO = searchStudent(cid);
        return studentDTO == null;
    }


  
}

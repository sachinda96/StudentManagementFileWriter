/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.DTO;

/**
 *
 * @author Sachinda Nipun
 */
public class StudentDTO {
    
    private String StudentID;
    private String StudentNAme;
    private String address;
    private String birtday;
    private String contact;
    private String course;

    public StudentDTO() {
    }

    public StudentDTO(String StudentID, String StudentNAme, String address, String birtday, String contact, String course) {
        this.StudentID = StudentID;
        this.StudentNAme = StudentNAme;
        this.address = address;
        this.birtday = birtday;
        this.contact = contact;
        this.course = course;
    }

    /**
     * @return the StudentID
     */
    public String getStudentID() {
        return StudentID;
    }

    /**
     * @param StudentID the StudentID to set
     */
    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    /**
     * @return the StudentNAme
     */
    public String getStudentNAme() {
        return StudentNAme;
    }

    /**
     * @param StudentNAme the StudentNAme to set
     */
    public void setStudentNAme(String StudentNAme) {
        this.StudentNAme = StudentNAme;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the birtday
     */
    public String getBirtday() {
        return birtday;
    }

    /**
     * @param birtday the birtday to set
     */
    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }
    
    
            
    
    
}

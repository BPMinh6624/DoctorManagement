/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doctormanagement.DataAccess;

import com.mycompany.doctormanagement.Common.Library;
import com.mycompany.doctormanagement.Model.Doctor;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public class DoctorDAO {
    private static DoctorDAO instance = null;
    Library l;
    ArrayList<Doctor> list;

    public DoctorDAO() {
        l = new Library();

        list = new ArrayList<>();
    }

    public static DoctorDAO Instance() {
        if (instance == null) {
            synchronized (DoctorDAO.class) {
                if (instance == null) {
                    instance = new DoctorDAO();
                }
            }
        }
        return instance;
    }
     public void addDoctor(ArrayList<Doctor> dl) {
        System.out.println("---------------------------- Add Doctor ----------------------------");        
        String code = l.inputString("Enter code: ");

        if (!checkCodeExist(dl, code)) {
            System.err.println("Code exist!");
            code = l.inputString("Enter code again: ");
        }

        String name = l.inputString("Enter name: ");
        String specialization = l.inputString("Enter specialization: ");
        int availability = l.getIntNoLimit("Enter availability");

        if (!checkDuplicate(dl, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        dl.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful!");
        }
    
        public boolean checkCodeExist(ArrayList<Doctor> dl, String code) {
        for (Doctor doctor : dl) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }
          public boolean checkDuplicate(ArrayList<Doctor> dl, String name, String specialization, int availability) {
        for (Doctor doctor : dl) {
            if (name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }
          public void updateDoctor(ArrayList<Doctor> dl) {
        System.out.println("---------------------------- Update Doctor ----------------------------");
        if (dl.isEmpty()) {
            System.err.println("There are no doctor in the list!!!");
            return;
        }
        String code = l.inputString("Enter code: ");
        if (!checkCodeExist(dl, code)) {
            System.err.println("Cannot found doctor");
            code = l.inputString("Enter code again: ");
        }
        String codeUpdate = l.inputString("Enter update code: ");
        Doctor doctor = getDoctorByCode(dl, code);
        String name = l.inputString("Enter update name: ");
        String specialization = l.inputString("Enter update specialization: ");
        int availability = l.getIntNoLimit("Enter availability: ");
        
        if (checkDuplicate(dl, name, specialization, availability)) {
            System.err.println("Duplicate doctor information");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful!");
    }

    public void deleteDoctor(ArrayList<Doctor> dl) {
        System.out.println("---------------------------- Delete Doctor ----------------------------");
        if (dl.isEmpty()) {
            System.err.println("There is no doctor in the list");
            return;
        }
        String code = l.inputString("Enter code: ");
        //check code exist or not
        if (checkCodeExist(dl, code)) {
            System.err.println("Not found doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(dl, code);
        if (doctor == null) {
            System.err.println("Cannot found doctor");
            return;
        } else {
            dl.remove(doctor);
        }
        System.err.println("Delete successful!");
    }

    public void searchDoctor(ArrayList<Doctor> dl) {
        System.out.println("---------------------------- Search Doctor ----------------------------");
        if (dl.isEmpty()) {
            System.err.println("There is no doctor in the list");
            return;
        }
        String searchString = l.inputString("Enter text: ");
        ArrayList<Doctor> listFoundByString = getListDoctorByString(dl, searchString);
        if (listFoundByString.isEmpty()) {
            System.err.println("Cann't found any result!!!");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByString) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    public Doctor getDoctorByCode(ArrayList<Doctor> dl, String code) {
        for (Doctor doctor : dl) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> getListDoctorByString(ArrayList<Doctor> dl, String searchString) {
        ArrayList<Doctor> list = new ArrayList<>();
        for (Doctor doctor : dl) {
            if (doctor.getCode().contains(searchString) || doctor.getName().contains(searchString) || doctor.getSpecialization().contains(searchString)) {
                list.add(doctor);
            }
        }
        return list;
    }
}

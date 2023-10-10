/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doctormanagement.Controller;

import com.mycompany.doctormanagement.Model.Doctor;
import com.mycompany.doctormanagement.Repository.DoctorRepository;
import com.mycompany.doctormanagement.View.Menu;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public class DoctorManagement extends Menu <String> {
    static String[] mc = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
    ArrayList<Doctor> dl;
    DoctorRepository program;

    public DoctorManagement() {
        super("\nDoctor Management", mc);
        dl = new ArrayList<>();
        program = new DoctorRepository();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                program.addDoctor(dl);
                break;
            case 2:
                program.updateDoctor(dl);
                break;
            case 3:
                program.deleteDoctor(dl);
                break;
            case 4:
                program.searchDoctor(dl);
                break;
            case 5:
                System.exit(0);
        }
    }
}

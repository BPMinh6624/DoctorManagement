/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doctormanagement.Repository;

import com.mycompany.doctormanagement.Model.Doctor;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public interface IDoctorRepository {
    void addDoctor(ArrayList<Doctor> dl);

    void updateDoctor(ArrayList<Doctor> dl);

    void deleteDoctor(ArrayList<Doctor> dl);

    void searchDoctor(ArrayList<Doctor> dl);
}

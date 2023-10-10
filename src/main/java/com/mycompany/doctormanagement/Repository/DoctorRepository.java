/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doctormanagement.Repository;

import com.mycompany.doctormanagement.DataAccess.DoctorDAO;
import com.mycompany.doctormanagement.Model.Doctor;
import java.util.ArrayList;

/**
 *
 * @author tuanh
 */
public class DoctorRepository implements IDoctorRepository{
    @Override
    public void addDoctor(ArrayList<Doctor> dl) {
        DoctorDAO.Instance().addDoctor(dl);
    }

    @Override
    public void updateDoctor(ArrayList<Doctor> dl) {
        DoctorDAO.Instance().updateDoctor(dl);
    }

    @Override
    public void deleteDoctor(ArrayList<Doctor> dl) {
        DoctorDAO.Instance().deleteDoctor(dl);
    }

    @Override
    public void searchDoctor(ArrayList<Doctor> dl) {
        DoctorDAO.Instance().searchDoctor(dl);
    }
}
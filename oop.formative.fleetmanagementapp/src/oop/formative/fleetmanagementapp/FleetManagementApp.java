/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.formative.fleetmanagementapp;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import oop.fa1.vehicle.Vehicle;

/**
 *
 * @author Wandi Mtshali
 */
public class FleetManagementApp {

    public static void main(String[] args) {

        String[] vehicleData = {
            "AB 45 CD GP#120000#12.5#50",
            "EF 98 GH GP#85000#14.2#40",
            "IJ 32 KL GP#150000#10.8#30",
            "MN 67 OP GP#200000#9.5#25",
            "QR 21 ST GP#95000#13.0#60",
            "UV 89 WX GP#50000#15.3#70",
            "YZ 10 AB GP#180000#11.7#35",
            "CD 55 EF GP#75000#14.5#45",
            "GH 77 IJ GP#110000#12.0#55",
            "KL 33 MN GP#95000#13.8#20",
            "OP 44 QR GP#175000#10.0#40",
            "ST 66 UV GP#135000#12.2#50"
        };
        ArrayList<Vehicle> vehicles = new ArrayList<>(vehicleData.length);

        for (int i = 0; i < vehicleData.length; i++) {
            String[] tokens = vehicleData[i].split("#");
            String licensePlate = tokens[0];
            int kilometers = Integer.parseInt(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);
            int fuelLevel = Integer.parseInt(tokens[3]);

            vehicles.add(new Vehicle(licensePlate, kilometers, consumption, fuelLevel));

        }
        Vehicle vehicle = new Vehicle("KW 78 PW GP", 12500, 16.8, 14);
        String messageOutPut = addVehicle(vehicles, vehicle);
        if (messageOutPut.trim().equalsIgnoreCase("Added successfully")) {

            String output = "Vehicle with license number " + vehicle.getLicensePlate() + "  was added successfully to the fleet";
            JOptionPane.showMessageDialog(null, output, "ADDEING A NEW VEHICLE", JOptionPane.PLAIN_MESSAGE);
        }
        String toRemove = JOptionPane.showInputDialog(null, "Enter the vehicle license number to remove from the fleet", "LICENSE NUMBER", JOptionPane.QUESTION_MESSAGE);

        boolean testRemoved = removeVehicle(vehicles, toRemove);

        if (testRemoved = true) {

            JOptionPane.showMessageDialog(null, "Vehicle removed successully", "REMOVE VEHICLE", JOptionPane.INFORMATION_MESSAGE);
        }else{
           JOptionPane.showMessageDialog(null, "Vehocle not part of fleet as was not removed", "ADDING A NEW VEHICLE", JOptionPane.WARNING_MESSAGE);
        }

        Vehicle v = getMostDrivenVehicle(vehicles);
        String toDisplay = "vehicle with most kilometers\n" +"License number :"+v.getLicensePlate()+"\nKilometers: "+v.getKilometers();
   
        JOptionPane.showMessageDialog(null,toDisplay);
    }

    public static String addVehicle(ArrayList<Vehicle> vehicles, Vehicle vehicle) {

        boolean found = false;
        String message = "";
        for (int i = 0; i < vehicles.size(); i++) {

            if (vehicles.get(i) == vehicle) {
                found = true;

                break;
            }
        }
        if (found = false) {
            vehicles.add(vehicle);
            message = " Added successfully ";
        } else {
            message = "not added";
        }

        return message;
    }

    public static boolean removeVehicle(ArrayList<Vehicle> vehicles, String toRemove) {

        boolean message = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getLicensePlate().equalsIgnoreCase(toRemove)) {
                vehicles.remove(i);
                message = true;
            } else {

                message = false;
            }

        }

        return message;
    }

    public static Vehicle getMostDrivenVehicle(ArrayList<Vehicle> vehicles) {

        int highest = 0,index =0;

        for (int i = 0; i < 10; i++) {
           
            if (vehicles.get(i).getKilometers() > highest) {

                highest = vehicles.get(i).getKilometers();
                index = i;
            }
        }

        return vehicles.get(index);

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lifo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Wandi Mtshali
 */
public class LIFO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*Stack<String> stack = new Stack<>();
        stack.push("Send email");
        stack.push("write report");
        stack.push("Attend meetings");
        stack.push("Review code");
        stack.push("update project plan");

        System.out.println("current stack of tasks: " + stack);

        String task1 = stack.pop();
        System.out.println("completed :" + task1);
        String task2 = stack.pop();
        System.out.println("Completed :" + task2);

        System.out.println("task :" + stack);

        stack.push("Fix bugs");
        stack.push("prepare presentation");

        System.out.println("final stack " + stack);*/
        Map<String, Double> map = new HashMap<>();

        map.put("Naledi", 85.5);
        map.put("Thabo", 72.0);
        map.put("Aisha", 91.5);
        map.put("Lerato", 68.5);
        map.put("Miguel", 79.0);

        System.out.println(" All students: " + map);

        double highest = 0;
        String student = "";
        double value = 0;

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();

            double val = entry.getValue();

            value = val;
            if (value > highest) {

                highest = value;
                student = key;

            }

        }
        System.out.println("key :" + student + " with value of :" + highest);

        map.remove("Lerato");
        System.out.println("map: "+map);

    }

}

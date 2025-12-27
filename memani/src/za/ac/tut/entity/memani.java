
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class memani {

    public static void main(String[] args) {

        /*
        List<Integer> list = new ArrayList<>();
        if (list.isEmpty()) {
            System.out.println(" The list is empty.");
            
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            
            
            
           // list.forEach(System.out::println);
           int removeElement = list.remove(2);
            for (Integer integer : list) {
                
                
                System.out.println("::"+integer);
            }
            list.add(2,3);
            list.forEach(System.out::println);
            
            list.set(2,5);
            list.forEach(System.out::println);
            
        }
        
        
        
        
        
        
        Stack<Integer> stack = new Stack();
        
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        
        stack.forEach(System.out::println);
        System.out.println("Size "+stack.size());
        System.out.println("last one in "+stack.peek());
        int removed = stack.pop();
        System.out.println("was removed "+removed );
        stack.forEach(System.out::println);
        stack.push(6);
        stack.push(7);
        stack.forEach(System.out::println);
        int number = stack.search(7);
        
        if (number!=-1) {
            System.out.println(" found "+number);
            
            
        }
        int first = stack.firstElement();
        System.out.println("first element "+ first);
        
        int last = stack.lastElement();
        System.out.println("last element "+last);
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        
        queue.forEach(System.out::println);
        int first = queue.element();
        System.out.println("first element "+first);
        System.out.println(" size "+queue.size());
        queue.offer(6);
        queue.forEach(System.out::println);
        System.out.println("fist  "+queue.peek());
        int removed = queue.remove();
        System.out.println("removed "+ removed);
        if (queue.contains(0)) {
          
        }
        
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        
        
        set.forEach(System.out::println);
        System.out.println("size "+ set.size());
        System.out.println(" duplicate "+set.add(2));
        
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(5);
        
        System.out.println(" set list :"+set);
        set.forEach(System.out::println); 
        
        
         
        Map<Integer, String> map = new HashMap<>();
        
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        
        
        System.out.println(" list"+map);
        System.out.println(" size "+map.size());
        
        for (Map.Entry data  :map.entrySet()) {
            
            System.out.println(" key "+data.getKey()+ " value "+data.getValue());
        }
        
        
        map.remove(2);
        System.out.println("List "+map);
        
         */
        String message = "i love going out;like yesteday.";
        int whiteSpace = 0;
        int commas = 0;

        String newWords = "";
        int fullStops = 0;

        int words = 0;

        System.out.println(" byt size " + message.getBytes());
        for (int i = 0; i < message.length(); i++) {

            char charAtPoint = message.charAt(i);

            if (Character.isWhitespace(charAtPoint)) {
                whiteSpace++;
            }
            if (charAtPoint == ';') {
                commas++;
            }
            if (charAtPoint == '.') {
                fullStops++;
            }
            if (Character.isAlphabetic(charAtPoint)) {
                newWords += charAtPoint;
            } else if (!Character.isAlphabetic(charAtPoint)) {
                newWords += " ";
            }

            if (Character.isWhitespace(charAtPoint)) {

            }

            String[] wordCount = message.split(" ");

        }
        int index = 0;
        String[] wordCount = message.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String string : wordCount) {
            if (map.containsKey(string)) {
                index = map.get(wordCount);
                index++;
                map.put(string, index);
            } else {

                map.put(string, 1);
            }

        }

        int wordNumber = 1 + wordCount.length;
        System.out.println(" whiteSpace :" + whiteSpace);
        System.out.println("commas : " + commas);
        System.out.println("fullstops : " + fullStops);
        System.out.println("new sentence :" + newWords);
        System.out.println("number of words :" + wordNumber);
        System.out.println(" " + wordCount[0]);

        System.out.println("same word found :" + map);

    }

}

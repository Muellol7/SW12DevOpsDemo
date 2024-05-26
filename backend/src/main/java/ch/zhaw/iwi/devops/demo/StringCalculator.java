package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add (String numbers) {
        
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);
        }
        
        String[] numberArray = numbers.split(delimiter);
        int sum = 0;
                          
        List<Integer> negativeNumbers = new ArrayList<>();
        
        for (String number : numberArray) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negativeNumbers.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }
        
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

        return sum;    
    }
    
}

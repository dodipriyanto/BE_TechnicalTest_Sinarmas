package RoyalRumble;

import java.util.ArrayList;
import java.util.List;

public class RoyalRumble {
    public List<String> getSortedList(List<String> names) {

        //decimal list as a result
        List<String> decimalResult = getDecimalResult(names);

        //sort list
        List<String> sortedDecimalResult = sortArray(decimalResult);

        //convert list to roman
        List<String> romanResult = getRomanResult(sortedDecimalResult);

        return romanResult;
    }

    static List<String> getDecimalResult(List<String> names) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < names.size(); i++) {
            String name = (names.get(i) + " ").split(" ")[0];
            String roman = names.get(i).substring(names.get(i).lastIndexOf(" ") + 1);
            int decimal = romanToDecimal(roman);
            result.add(name + " " + decimal);
        }
        return result;
    }

    static List<String> getRomanResult(List<String> sortedDecimalResult) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < sortedDecimalResult.size(); i++) {
            String name = (sortedDecimalResult.get(i) + " ").split(" ")[0];
            String decimal = sortedDecimalResult.get(i).substring(sortedDecimalResult.get(i).lastIndexOf(" ") + 1);
            String roman = decimalToRoman(Integer.parseInt(decimal));

            result.add(name + " " + roman);
        }
        return result;
    }


    static int value(char r) {

        switch (r) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    static int romanToDecimal(String str) {

        // Initialize result
        int res = 0;

        // Traverse given input
        for (int i = 0; i < str.length(); i++) {

            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {

                // Getting value of symbol s[i+1]
                int s2 = value(str.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {

                    // Value of current symbol
                    // is >= the next symbol
                    res = res + s1;
                } else {

                    // Value of current symbol
                    // is < the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }
        return res;
    }

    static String decimalToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();
    }


    public static List<String> sortArray(List<String> arr) {

        int N = arr.size();
        int E = N - 1;
        String temp;
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int a = 0; a < E; a++) {
                if (Integer.parseInt(arr.get(a).substring(arr.get(a).indexOf(" ") + 1)) >
                        Integer.parseInt(arr.get(a + 1).substring(arr.get(a + 1).indexOf(" ") + 1))) {

                    temp = arr.get(a);
                    arr.set(a, arr.get(a + 1));
                    arr.set(a + 1, temp);

                    flag = true;
                }
            }
            E--;
        }
        return arr;
    }


}

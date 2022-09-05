// You need to find the Kth character in the resultant string.
// The equation is: An = An-1 + "0" + flip(rotate(An-1))
// Here you needs to perform two operations:
// 1. rotate() => in this operation you need to rotate the given string.
// For example: if the string is "001" then the rotated string is "100".
//  2. flip() => in this operation you need to flip every character of the string i.e 0 to 1 ans vice versa. 
// For example: If the given string is "001" then the flipped string is "110".
// According to the given equation and above operations A0 = "", A1 = "0", A2 = "001",  A4 = "0010011"...  and so on.
// Input: 4
// 1
// 2
// 3
// 10
// Output:
// 0
// 1
// 1
// 0

// Or Another question could be
// Given a binary string, that is it contains only 0s and 1s. We need to make 
// this string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped. 
// Input : str = “001”
// Output : 1
// Input : str = “0001010111”
// Output : 2

import java.util.*;

class KthCharacter {
    public static char flip(char ch) {
        return (ch == '0') ? '1' : '0';
    }

    public static int getFlipWithStartingCharcter(String str, char expected) {
        int flipCount = 0;

        for (int i = 0; i < str.length(); i++) {
            
            if (str.charAt(i) != expected)
                flipCount++;
            expected = flip(expected);
        }
        return flipCount;
    }

    public static int minFlipToMakeStringAlternate(String str) {
        return Math.min(getFlipWithStartingCharcter(str, '0'), 
        getFlipWithStartingCharcter(str, '1'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            System.out.println(minFlipToMakeStringAlternate(str));
        }
        sc.close();
    }
}
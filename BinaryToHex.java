/**
*This code was written by me for a school project a while ago
*that class is now over, since its just sitting on my hard drive now, I will be releasing it as open source.
*Hopefully it can help some people learning to program
*Usage is simple, it will ask you for some bytes of binary code,
*Enter them as such: "0101 0101 0101 0101 0101" Up to 32 4 bit segments,
*And they will be converted to the decimal number system and displayed.
*/


package binarytohex;

import java.util.Scanner;

/**
 *
 * @author William Fletcher
 */
public class BinaryToHex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Enter up to 16 8-bit semgments, with a space every 4 bits: ");
        Scanner s = new Scanner(System.in);
        int[] binArray = new int[32];
        String hexout = "";
        //int counter = 0;
        String input = s.nextLine();
        int numbytes = (input.length() + 1) / 5;
        int f = 0;
        int l = 4;
        for (int i = 0; i < numbytes; i++) {
            binArray[i] = Integer.parseInt(input.substring(f, l));
            l += 5;
            f += 5;
        }
        int count2 = 0;
        for (int i = 0; i < numbytes; i++) {
            hexout += BinToHex(binArray[i]);
            count2++;
            if (count2 >= 2) {
                hexout += " ";
                count2 = 0;
            }
        }
        //convert the 8-bit bytes into decimal, then convert to Char and display
        char[] asciirep = new char[numbytes / 2];
        int count5 = 0;
        int temp = 0;
        for (int i = 0; i < numbytes; i++) {
            temp = BinToDec(binArray[i]) + BinToDec(binArray[i + 1]);
            if ( temp < 26) {
                asciirep[count5] = (char) (temp + 65);
            }
            else if(temp >= 26 && temp < 52)
                asciirep[count5] = (char) (temp -26 + 97);

            else
                asciirep[count5] = '.';
            i++;
            count5++;
        }
        String charout = String.valueOf(asciirep);
        
        System.out.println("The Binary String converted to Hexadecimal is: ");
        System.out.println(hexout);
        System.out.println("This data converted to ASCII is: ");
        System.out.println(charout);
    }

    public static String BinToHex(int x) {
        int[] hex = new int[1000];
        int i = 1;
        int j = 0;
        int rem;
        int dec = 0;
        int bin = x;
        String out = "";
        while (bin > 0) {
            rem = bin % 2;
            dec = dec + rem * i;
            i = i * 2;
            bin = bin / 10;
        }
        i = 0;
        while (dec != 0) {
            hex[i] = dec % 16;
            dec = dec / 16;
            i++;
        }
        //System.out.print("HexaDecimal value: ");
        for (j = i - 1; j >= 0; j--) {
            if (hex[j] > 9) {
                //System.out.print((char) (hex[j] + 55) + "\n");
                out += (char) (hex[j] + 55);
            } else {
                // System.out.print(hex[j] + "\n");
                out += (hex[j]);
            }
        }
        return out;
    }

    public static int BinToDec(int y) {
        int i = 1;
        int j = 0;
        int rem;
        int dec = 0;
        int bin = y;
        while (bin > 0) {
            rem = bin % 2;
            dec = dec + rem * i;
            i = i * 2;
            bin = bin / 10;
        }
        return dec;
    }

}

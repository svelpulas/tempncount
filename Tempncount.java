/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempncount;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author sande
 */
public class Tempncount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintWriter createFile = new PrintWriter("temperature.txt");
        createFile.println("82.5\n30\n92\n78\n32\n98.8");
        createFile.close();
        Scanner scan = new Scanner(System.in);
        FileWriter fw = new FileWriter("celsius.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        System.out.println("Enter file name");
        String filename = scan.nextLine();
        System.out.println("Enter starting number");
        int start = scan.nextInt();
        int end1 = start + 4;
        while(start <= 100){
            if (start == end1){
                pw.println(start + " ");
                System.out.println(start + " ");
                end1 += 5;
                start++;
            } else {
                pw.printf(start + " ");
                System.out.printf(start + " ");
                start++;
            }
        }
        pw.printf("\n");
        System.out.printf("\n");
        File f = new File(filename);
        Scanner infile = new Scanner(f);
        while (infile.hasNextLine()){
            double fartemp = Double.parseDouble(infile.nextLine());
            double temp = fartemp - 32;
            double celtemp = (double) temp * 5/9;
            if (celtemp > 0){
                System.out.printf("%.2f\n", celtemp);
                pw.printf("%.2f\n", celtemp);
            } else {
                continue;
            }
        }
        pw.close(); 
        infile.close();
    }
    
}

package com.example.jeux;

import java.io.*;

public class LireEcrire {
    public static String Lire(int i) throws IOException {
        FileReader fr=new FileReader("target\\classes\\com\\example\\jeux\\Record.txt");
        BufferedReader br=new BufferedReader(fr);
        for(int j=0;j<i-1;j++){
            br.readLine();
        }
        String ch=br.readLine();
        fr.close();
        br.close();
        return ch;
    }
    public static void Ecrire(String a,int b) throws IOException {
        FileReader fr=new FileReader("target\\classes\\com\\example\\jeux\\Record.txt");
        BufferedReader br=new BufferedReader(fr);
        String a1=br.readLine();
        String a2=br.readLine();
        String a3=br.readLine();
        fr.close();
        br.close();
        PrintWriter pw=new PrintWriter("target\\classes\\com\\example\\jeux\\Record.txt");
        if(b==1){
            pw.println(a);pw.println(a2);pw.println(a3);
        }
        else{
            if(b==2){
                pw.println(a1);pw.println(a);pw.println(a3);
            }
            else{
                pw.println(a1);pw.println(a2);pw.println(a);
            }
        }
        pw.close();
    }

}

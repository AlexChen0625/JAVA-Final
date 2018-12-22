package java2017;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadMapFile {  
    //�x�s�a�� 
    static int[][] map1;  
    static int[][] map2;  
    static int[][] map3;  
    //�����m
    static int playerX;
    static int playerY;
    //Ū�a��  
    static void readfile(String path){  
        try{  
            //��J
            FileInputStream fis = new FileInputStream(path);  
            DataInputStream dis = new DataInputStream(fis);  
            //Ū�a��
            int i = dis.readInt(); 
            System.out.printf("i=%d",i);
           
            int j = dis.readInt();   
            System.out.printf("j=%d",j);
            map1 = new int[i][j];  
            map2 = new int[i][j];  
            map3 = new int[i][j];  
            for(int ii=0;ii<i;ii++){  
                for(int jj=0;jj<j;jj++){  
                    map1[ii][jj] = dis.readInt();  
                    map2[ii][jj] = dis.readInt();  
                    map3[ii][jj] = dis.readInt();  
                }  
            }  
            
            playerX = dis.readInt();
            playerY = dis.readInt();
            dis.close();  
            fis.close();  
        }catch(Exception e){  
            e.printStackTrace();  
        } 
    }
}
package src.question1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Question1 {
    
    public static void main(String [ ] args )throws Exception{
        
        FileInputStream fis = new FileInputStream("boy.txt");
        DataInputStream dis = new DataInputStream(fis);
        
        String str = dis.readUTF();
        int nob = Integer.parseInt(str);
        
        boys[] arrb=new boys[nob];
        for(int i=0;i<nob;i++){
            arrb[i]=new boys();            
        }
        for(int i=0;i<nob;i++)
        {
            str = dis.readUTF();
            arrb[i].name=str;
            str = dis.readUTF();
            arrb[i].attr=Integer.parseInt(str);
            str = dis.readUTF();
            arrb[i].intell=Integer.parseInt(str);
            str = dis.readUTF();
            arrb[i].budget=Integer.parseInt(str); 
            str = dis.readUTF();
            arrb[i].status=Integer.parseInt(str);
                        
        }
        
        FileInputStream fisg = new FileInputStream("girls.txt");
        DataInputStream disg = new DataInputStream(fisg);
        
        String strg = disg.readUTF();
        int nog = Integer.parseInt(strg);
        
        girls[] arrg=new girls[nog];
        for(int i=0;i<nog;i++){
            arrg[i]=new girls();            
        }
        for(int i=0;i<nog;i++)
        {
            strg = disg.readUTF();
            arrg[i].name=strg;
            strg = disg.readUTF();
            arrg[i].attr=Integer.parseInt(strg);
            strg = disg.readUTF();
            arrg[i].maint=Integer.parseInt(strg);
            strg = disg.readUTF();
            arrg[i].intell=Integer.parseInt(strg);
            strg = disg.readUTF();
            arrg[i].status=Integer.parseInt(strg);
                        
        }
         
       FileOutputStream cfos = new FileOutputStream("couple.txt");
       DataOutputStream cdos = new DataOutputStream(cfos);
        for(int a=0;a<nog;a++){
            
            for(int b=0;b<nob;b++){
                
                if(arrg[a].attr >= arrb[b].attr && arrb[b].budget >= arrg[a].maint && arrb[b].status==0){
                    
                    System.out.print("Couple is :"+arrb[b].name );
                    System.out.print(" and "+arrg[a].name );
                    System.out.print("\n" );
                    arrb[b].status=1;
                    arrg[a].status=1;
                    //cdos.writeUTF(arrb[b].name);
                   // cdos.writeUTF(arrg[a].name);
                    break;                    
                }
                
            }
            
        }   
        
    }    
}

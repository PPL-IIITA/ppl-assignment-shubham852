package question_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Question_4 {

    public static void main(String[] args) throws Exception{
       
        FileInputStream fisc = new FileInputStream("couple.txt");
        DataInputStream disc = new DataInputStream(fisc);
        
        String strc = disc.readUTF();
        int noc = Integer.parseInt(strc);
        
        couple[] arrc=new couple[noc];
        for(int i=0;i<noc;i++){
            arrc[i]=new couple();   
        }
        for(int i=0;i<noc;i++)
        {
            strc = disc.readUTF();
            arrc[i].bname=strc;
            strc = disc.readUTF();
            arrc[i].gname=strc;
            strc = disc.readUTF();
            arrc[i].budget=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].main=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].btype=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].gtype=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].bint=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].gint=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].batr=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].gatr=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].tcost=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].tval=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].bhap=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].ghap=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].com=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].thap=Integer.parseInt(strc);
            strc = disc.readUTF();
            arrc[i].gcount=Integer.parseInt(strc);
        }
        
        for(int i=0;i<noc-1;i++){
            for(int j=0;j<noc-1;j++){
                if(arrc[j].thap < arrc[j+1].thap){
                    couple temp2;
                    temp2=arrc[j+1];
                    arrc[j+1]=arrc[j];
                    arrc[j]=temp2;   
                }
            }
        }
        
        //HERE WE HAVE TO PICK K LEAST HAPPY COUPLE THEREFORE AS WE ARE NOT ALLOWED TO SCAN WE ARE TAKING K=3
        //TAKING K=3
        
        int k=3;
        
        FileInputStream fis = new FileInputStream("boys.txt");
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
            str = dis.readUTF();
            arrb[i].type=Integer.parseInt(str);
                        
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
            strg = disg.readUTF();
            arrg[i].type=Integer.parseInt(strg);                        
        }
        
        couple[] arrnc=new couple[noc];
        for(int i=0;i<k;i++){
            arrnc[i]=new couple();   
        }
        for(int i=0;i<k;i++){
            arrnc[i]=arrc[noc-k+i];
            int j=0;
            while(j<nob){
                if(arrnc[i].bname==arrb[j].name){
                    arrb[j].status=0;
                    break;
                }
                else
                    j++;
            }
            int l=0;
            while(l<nog){
                if(arrnc[i].gname==arrg[l].name){
                    arrg[l].status=0;
                    break;
                }
                else
                    l++;
            }
            
        }
        
        for(int i=0;i<k;i++){
            for(int j=0;j<nob;j++){
                if(arrnc[i].gatr >= arrb[j].attr && arrnc[i].main <= arrb[j].budget && arrb[j].status==0 && arrb[j].name!=arrnc[i].bname){
                    
                    arrc[noc-k+i].bname=arrb[j].name;
                    arrc[noc-k+i].gname=arrnc[i].gname;
                    arrc[noc-k+i].budget=arrb[j].budget;
                    arrc[noc-k+i].main=arrnc[i].main;
                    arrc[noc-k+i].btype=arrb[j].type;
                    arrc[noc-k+i].gtype=arrnc[i].gtype;
                    arrc[noc-k+i].bint=arrb[j].intell;
                    arrc[noc-k+i].gint=arrnc[i].gint;
                    arrc[noc-k+i].batr=arrb[j].attr;
                    arrc[noc-k+i].gatr=arrnc[i].gatr;
                    arrb[j].status=1;
                    
                }
            }
        }
        System.out.print("New couple formed are:\n");
        for(int i=0;i<noc;i++){
            System.out.print(arrc[i].bname+" and "+arrc[i].gname+".");
            System.out.print("\n");
        }
        
    }
   
}

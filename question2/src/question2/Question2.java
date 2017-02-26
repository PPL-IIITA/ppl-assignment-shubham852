/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.question2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Question2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)throws Exception{
        
        FileInputStream fis = new FileInputStream("gift.txt");
        DataInputStream dis = new DataInputStream(fis);
        
        String str = dis.readUTF();
        int nog = Integer.parseInt(str);
        
        gift[] arr=new gift[nog];
        for(int i=0;i<nog;i++){
            arr[i]=new gift();            
        }
        for(int i=0;i<nog;i++)
        {
            str = dis.readUTF();
            arr[i].type=Integer.parseInt(str);
            str = dis.readUTF();
            arr[i].price=Integer.parseInt(str);
            str = dis.readUTF();
            arr[i].value=Integer.parseInt(str);
            str = dis.readUTF();
            arr[i].luxuryrating=Integer.parseInt(str); 
            str = dis.readUTF();
            arr[i].diff=Integer.parseInt(str);
            str = dis.readUTF();
            arr[i].utival=Integer.parseInt(str);
            str = dis.readUTF();
            arr[i].uticla=Integer.parseInt(str);
                        
        } 
        
        for(int i=0;i<nog-1;i++){
            
            for(int j=0;j<nog-1;j++){
                
                if(arr[j].price > arr[j+1].price){
                    
                    gift temp;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    
                }
                
            }
            
        }
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
        }
        int a,b,c;
        for(int i=0;i<noc;i++){
            
            c=Math.abs(arrc[i].bint-arrc[i].gint);
            c=c+Math.abs(arrc[i].batr-arrc[i].gatr);
            c=c+Math.abs(arrc[i].budget-arrc[i].main);
            
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of k");
        int k=sc.nextInt();
        
        for(int i=0;i<nog-1;i++){
            
            for(int j=0;j<nog-1;j++){
                
                if(arrc[j].com < arrc[j+1].com){
                    
                    couple temp;
                    temp=arrc[j+1];
                    arrc[j+1]=arrc[j];
                    arrc[j]=temp;
                    
                }
                
            }
            
        }
        
        FileOutputStream cfos = new FileOutputStream("couplecompatibility.txt");
        DataOutputStream cdos = new DataOutputStream(cfos);
        
        for(int i=0;i<k;i++){
            
            System.out.print("Compatible couple is :"+arrc[i].bname );
            System.out.print(" and "+arrc[i].gname );
            System.out.print("\n" );
            cdos.writeUTF(arrc[i].bname);
            cdos.writeUTF(arrc[i].gname);
            
        }
        
    }
    for(int i=0;i<noc;i++){
    
        if(arrc[i].btype==0){
            
            int m,v;
            v=0;
            m=arrc[i].main;
            while(m > 0){
                
                if(m-arr[v]>=0){
                    
                    m=m-arr[v].price;
                    
                }
                else{
                    
                    break;
                    
                }
                v++;
            }
            if( (arrc[i].budget - arrc[i].main + m - arr[v].value )>=0){
                
                arrc[i].bhap=arrc[i].budget - arrc[i].main + m - arr[v].value;
                
            }
            if(arrc[i].gtype==0){
                arrc[i].ghap=java.lang.Math.log(arrc[i].budget-arrc[i].bhap-arrc[i].main)+2*arr[v].value;                
            }
            else if(arrc[i].gtype==1){
                arrc[i].ghap= arrc[i].budget-arrc[i].main+m; 
            }
            else{
                arrc[i].ghap= java.lang.Math.exp(arrc[i].budget-arrc[i].bhap-arrc[i].main) 
            }
            arrc[i].thap=arrc[i]bhap+arrc[i]ghap;
        }
        if(arrc[i].btype==1){
            
            int m,v;
            v=0;
            m=arrc[i].budget;
            while(m > 0){
                
                if(m-arr[v]>=0){
                    
                    m=m-arr[v].price;
                    
                }
                else{
                    
                    break;
                    
                }
                v++;
            }
            if( (arrc[i].budget - arrc[i].main + m - arr[v].value )>=0){
                
                arrc[i].bhap=arrc[i].budget - arrc[i].main + m - arr[v].value;
                
            }
            if(arrc[i].gtype==0){
                arrc[i].ghap=java.lang.Math.log(arrc[i].budget-m-arrc[i].main)+2*arr[v].value;                
            }
            else if(arrc[i].gtype==1){
                arrc[i].ghap= arrc[i].budget-arrc[i].main+m; 
            }
            else{
                arrc[i].ghap= java.lang.Math.exp(arrc[i].budget-arrc[i].bhap-arrc[i].main) 
            }
            arrc[i].thap=2*arrc[i]ghap;
        }
        if(arrc[i].btype==1){
            
            int m,v;
            v=0;
            m=arrc[i].budget;
            while(m > 0){
                
                if(m-arr[v]>=0){
                    
                    m=m-arr[v].price;
                    
                }
                else{
                    
                    break;
                    
                }
                v++;
            }
            if( (arrc[i].budget - arrc[i].main + m - arr[v].value )>=0){
                
                arrc[i].bhap=arrc[i].budget - arrc[i].main + m - arr[v].value;
                
            }
            arrc[i].bhap=arrc[i].gint;
            if(arrc[i].gtype==0){
                arrc[i].ghap=java.lang.Math.log(arrc[i].budget-m-arrc[i].main)+2*arr[v].value;                
            }
            else if(arrc[i].gtype==1){
                arrc[i].ghap= arrc[i].budget-arrc[i].main+m; 
            }
            else{
                arrc[i].ghap= java.lang.Math.exp(arrc[i].budget-arrc[i].bhap-arrc[i].main) 
            }
            arrc[i].thap=arrc[i].bhap+arrc[i]ghap;
        }
    
    }
    for(int i=0;i<nog-1;i++){
            
        for(int j=0;j<nog-1;j++){
                
            if(arrc[j].com < arrc[j+1].com){
                    
                couple temp;
                temp=arrc[j+1];
                arrc[j+1]=arrc[j];
                arrc[j]=temp;
                    
            }
                
        }
            
    }
        
        FileOutputStream cfosg = new FileOutputStream("happycouple.txt");
        DataOutputStream cdosg = new DataOutputStream(cfosg);
        
        for(int i=0;i<k;i++){
            
            System.out.print("happy couple is :"+arrc[i].bname );
            System.out.print(" and "+arrc[i].gname );
            System.out.print("\n" );
            cdosg.writeUTF(arrc[i].bname);
            cdosg.writeUTF(arrc[i].gname);
            
        }
    
}

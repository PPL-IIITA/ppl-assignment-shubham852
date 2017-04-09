/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Shubham
 */
public class Question_5 {

    public static void main(String[] args) throws Exception{
        
        FileInputStream fis = new FileInputStream("gift.txt");
        DataInputStream dis = new DataInputStream(fis);
        
        String str = dis.readUTF();
        int nog = Integer.parseInt(str);
        gift[] arr=new gift[nog];
        for(int i=0;i<nog;i++){
            arr[i]=new gift();            
        }
        for(int i=0;i<nog;i++){
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
                if(arr[j].value > arr[j+1].value){
                    gift temp;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;   
                }
            }
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
        FileInputStream fisb = new FileInputStream("boy.txt");
        DataInputStream disb = new DataInputStream(fisb);
        
        String strb = disb.readUTF();
        int nob = Integer.parseInt(strb);
        boy[] arrb=new boy[nob];
        for(int i=0;i<nob;i++){
            arrb[i]=new boy();            
        }
        for(int i=0;i<nob;i++){    
            
            strb = disb.readUTF();
            arrb[i].name=strb;
            strb = disb.readUTF();
            arrb[i].attr=Integer.parseInt(strb);
            strb = disb.readUTF();
            arrb[i].intell=Integer.parseInt(strb);
            strb = disb.readUTF();
            arrb[i].budget=Integer.parseInt(strb); 
            strb = disb.readUTF();
            arrb[i].status=Integer.parseInt(strb);            
            strb = disb.readUTF();
            arrb[i].type=Integer.parseInt(strb);
 
        }
        
        FileInputStream fisg = new FileInputStream("girl.txt");
        DataInputStream disg = new DataInputStream(fisg);
        
        String strg = disg.readUTF();
        int nogirl = Integer.parseInt(strg);
        girl[] arrg=new girl[nogirl];
        for(int i=0;i<nogirl;i++){
            arrg[i]=new girl();            
        }
        for(int i=0;i<nogirl;i++){    
            
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
        
        for(int i=0;i<nogirl-1;i++){
            for(int j=0;j<nogirl-1;j++){
                if(arrg[j].attr < arrg[j+1].attr){
                    girl temp;
                    temp=arrg[j+1];
                    arrg[j+1]=arrg[j];
                    arrg[j]=temp;   
                }
            }
        }
        
        couple[] arrc=new couple[50];
        for(int i=0;i<50;i++){
            arrc[i]=new couple();   
        }
       
        int flag=0;
        int count=0;
        while(true)
        {         
            if(flag==0){ 
                for(int i=0;i<nogirl;i++){                           
                    for(int j=0;j<nob;j++){                   
                        if(arrg[i].attr >= arrb[j].attr && arrb[j].budget >= arrg[i].maint && arrb[j].status==0 && arrg[i].status==0){                        
                        arrc[count].bname=arrb[j].name;
                        arrc[count].gname=arrg[i].name;
                        arrc[count].budget=arrb[j].budget;
                        arrc[count].main=arrg[i].maint;
                        arrc[count].btype=arrb[j].type;
                        arrc[count].gtype=arrg[i].type;
                        arrc[count].bint=arrb[j].intell;
                        arrc[count].gint=arrg[i].intell;
                        arrc[count].batr=arrb[j].attr;
                        arrc[count].gatr=arrg[i].attr;
                        arrc[count].bhap=0;
                        arrc[count].ghap=0;
                        arrc[count].com=0;
                        arrc[count].thap=0;
                        arrc[count].gcount=0;  
                        
                        arrb[j].status=1;
                        arrg[i].status=1;
                        
                        count++;
                        flag=1;
                        break;
                        } 
                        if(flag==1)
                            break;
                    }
                                    
                }
                if(flag==0)
                      break;
            }
            else{
                
                for(int i=0;i<nob;i++){                           
                    for(int j=0;j<nogirl;j++){                   
                        if(arrg[j].attr >= arrb[i].attr && arrb[i].budget >= arrg[j].maint && arrb[i].status==0 && arrg[j].status==0){                        
                        arrc[count].bname=arrb[i].name;
                        arrc[count].gname=arrg[j].name;
                        arrc[count].budget=arrb[i].budget;
                        arrc[count].main=arrg[j].maint;
                        arrc[count].btype=arrb[i].type;
                        arrc[count].gtype=arrg[j].type;
                        arrc[count].bint=arrb[i].intell;
                        arrc[count].gint=arrg[j].intell;
                        arrc[count].batr=arrb[i].attr;
                        arrc[count].gatr=arrg[j].attr;
                        arrc[count].bhap=0;
                        arrc[count].ghap=0;
                        arrc[count].com=0;
                        arrc[count].thap=0;
                        arrc[count].gcount=0;  
                        
                        arrb[i].status=1;
                        arrg[j].status=1;
                        
                        count++;
                        flag=0;
                        break;
                        } 
                        if(flag==0)
                            break;
                    }
                                    
                }
                if(flag==1)
                      break;
            }
            
        }
        int noc=count;
        int v=0;
        couple temp1;
        int v1,value,v3,lux,uti;
        for(int i=0;i<noc;i++){
            v1=0;
            lux=0;
            uti=0;
            switch (arrc[i].btype) {
                case 1:
                    value=0;
                    while(true){
                        if(arr[v].price<(arrc[i].main-value)){
                            if(arr[v].type==2){
                                lux=lux+arr[v].value;
                            }
                            if(arr[v].type==3){
                                uti=uti+arr[v].value;
                            }
                            value=value+arr[v].price;
                            v++;
                            v1++;
                        }
                        else
                            break;
                    }
                    if(arr[v].price<=(arrc[i].budget-value)){
                        if(arr[v].type==2){
                            lux=lux+arr[v].value;
                        }
                        if(arr[v].type==3){
                            uti=uti+arr[v].value;
                        }
                        v1++;
                        value=value+arr[v].price;
                        v++;
                    }
                    arrc[i].bhap=arrc[i].main-value;
                    arrc[i].gcount=v1;
                    switch(arrc[i].gtype){
                        
                        case 1:
                            arrc[i].ghap=(int) Math.log10(value-arrc[i].main+(2*lux));
                            arrc[i].thap=arrc[i].ghap+arrc[i].bhap;
                            break;
                        case 2:
                            arrc[i].ghap=value-arrc[i].main+lux+uti;
                            arrc[i].thap=arrc[i].ghap+arrc[i].bhap;
                            break;
                        case 3:
                            arrc[i].ghap=(int) Math.pow(2.73,(value-arrc[i].main));
                            arrc[i].thap=arrc[i].ghap+arrc[i].bhap;
                            break;
                        default:
                               break;
                               
                    }
                    break;
                case 2:
                    value=0;
                    while(true){
                        if(arr[v].price<(arrc[i].main-value)){
                            if(arr[v].type==2){
                                lux=lux+arr[v].value;
                            }
                            if(arr[v].type==3){
                                uti=uti+arr[v].value;
                            }
                            value=value+arr[v].price;
                            v++;
                            v1++;
                        }
                        else
                            break;
                    }
                    if(arr[v].price<=(arrc[i].budget-value)){
                        if(arr[v].type==2){
                            lux=lux+arr[v].value;
                        }
                        if(arr[v].type==3){
                            uti=uti+arr[v].value;
                        }
                        v1++;
                        value=value+arr[v].price;
                        v++;
                    }
                    arrc[i].gcount=v1;
                    switch(arrc[i].gtype){
                        
                        case 1:
                            arrc[i].ghap=(int) Math.log10(value-arrc[i].main+(2*lux));
                            arrc[i].thap=2*arrc[i].ghap;
                            break;
                        case 2:
                            arrc[i].ghap=value-arrc[i].main+lux+uti;
                            arrc[i].thap=2*arrc[i].ghap;
                            break;
                        case 3:
                            arrc[i].ghap=(int) Math.pow(2.73,(value-arrc[i].main));
                            arrc[i].thap=2*arrc[i].ghap;
                            break;
                        default:
                               break;
                    }
                    break;
                case 3:
                    value=0;
                    while(true){
                        if(arr[v].price<(arrc[i].main-value)){
                            if(arr[v].type==2){
                                lux=lux+arr[v].value;
                            }
                            if(arr[v].type==3){
                                uti=uti+arr[v].value;
                            }
                            value=value+arr[v].price;
                            v++;
                            v1++;
                        }
                        else
                            break;
                    }
                    if(arr[v].price<=(arrc[i].budget-value)){
                        if(arr[v].type==2){
                            lux=lux+arr[v].value;
                        }
                        if(arr[v].type==3){
                            uti=uti+arr[v].value;
                        }
                        v1++;
                        value=value+arr[v].price;
                        v++;
                    }
                    int variable;
                    variable=v;
                    while(variable<noc){
                        if(arr[variable].type==2)
                            break;
                        variable++;
                    }
                    if(variable<noc){
                        gift temp3;
                        temp3=arr[variable];
                        arr[variable]=arr[v];
                        arr[v]=temp3;
                        if(arr[v].price<=(arrc[i].budget-value)){
                            lux=lux+arr[v].value;
                            v1++;
                            value=value+arr[v].price;
                            v++;
                        }
                    }
                    
                    arrc[i].bhap=arrc[i].gint;
                    arrc[i].gcount=v1;
                    switch(arrc[i].gtype){
                        
                        case 1:
                            arrc[i].ghap=(int) Math.log10(value-arrc[i].main+(2*lux));
                            arrc[i].thap=arrc[i].ghap+arrc[i].bhap;
                            break;
                        case 2:
                            arrc[i].ghap=value-arrc[i].main+lux+uti;
                            arrc[i].thap=arrc[i].ghap+arrc[i].bhap;
                            break;
                        case 3:
                            arrc[i].ghap=(int) Math.pow(2.73,(value-arrc[i].main));
                            arrc[i].thap=arrc[i].ghap+arrc[i].bhap;
                            break;
                        default:
                               break;
                               
                    }
                    break;
                default:
                    break;
            }
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
        for(int i=0;i<noc;i++){
            System.out.print(i+1+": Happiest couple is :"+arrc[i].bname );
            System.out.print(" and "+arrc[i].gname );
            System.out.print("\n");
            
        }
    }
}

package question_10;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Question_10 {

    public static void main(String[] args) throws Exception{
        
        //TAKING k=5            
        FileInputStream fis = new FileInputStream("gift.txt");
        DataInputStream dis = new DataInputStream(fis);        
        String str = dis.readUTF();
        int nogift = Integer.parseInt(str);
        gift[] arr=new gift[nogift];
        for(int i=0;i<nogift;i++){
            arr[i]=new gift();            
        }
        for(int i=0;i<nogift;i++){
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
        for(int i=0;i<nogift-1;i++){
            for(int j=0;j<nogift-1;j++){
                if(arr[j].value > arr[j+1].value){
                    gift temp;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;   
                }
            }
        }
        for(int i=0;i<(nogift/2);i++){
            
            gift temp;
            temp=arr[2*i+1];
            arr[2*i+1]=arr[nogift-i-1];
            arr[nogift-i-1]=temp;
        }
        
        FileInputStream fisb = new FileInputStream("boy.txt");
        DataInputStream disb = new DataInputStream(fisb);        
        String strb = disb.readUTF();
        int nob = Integer.parseInt(strb);
        boys[] arrb=new boys[nob];
        for(int i=0;i<nob;i++){
            arrb[i]=new boys();            
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
        for(int i=0;i<nob-1;i++){
            for(int j=0;j<nob-1;j++){
                if(arrb[j].budget < arrb[j+1].budget){
                    boys temp1;
                    temp1=arrb[j+1];
                    arrb[j+1]=arrb[j];
                    arrb[j]=temp1;   
                }
            }
        }
        for(int i=0;i<(nob/2);i++){
            
            boys temp1;
            temp1=arrb[2*i+1];
            arrb[2*i+1]=arrb[nob-i-1];
            arrb[nob-i-1]=temp1;
            
        }
        
        FileInputStream fisg = new FileInputStream("girl.txt");
        DataInputStream disg = new DataInputStream(fisg);        
        String strg = disg.readUTF();
        int nog = Integer.parseInt(strg);
        girls[] arrg=new girls[nog];
        for(int i=0;i<nog;i++){
            arrg[i]=new girls();            
        }
        for(int i=0;i<nog;i++){    
            
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
        for(int i=0;i<nog-1;i++){
            for(int j=0;j<nog-1;j++){
                if(arrg[j].maint > arrg[j+1].maint){
                    girls temp;
                    temp=arrg[j+1];
                    arrg[j+1]=arrg[j];
                    arrg[j]=temp;   
                }
            }
        }
        for(int i=0;i<(nog/2);i++){
            
            girls temp;
            temp=arrg[2*i+1];
            arrg[2*i+1]=arrg[nog-i-1];
            arrg[nog-i-1]=temp;
        }
        int k=5;
        int count=0;
        couple[] arrc=new couple[k];
        for(int i=0;i<k;i++){
            arrc[i]=new couple();   
        }
        for(int a=0;a<k;a++){            
            for(int b=0;b<k;b++){                
                if(arrg[a].attr >= arrb[b].attr && arrb[b].budget >= arrg[a].maint && arrb[b].status==0 && arrg[a].status==0){
                    
                    arrc[count].bname=arrb[b].name;
                        arrc[count].gname=arrg[a].name;
                        arrc[count].budget=arrb[b].budget;
                        arrc[count].main=arrg[a].maint;
                        arrc[count].btype=1;
                        arrc[count].gtype=1;
                        arrc[count].bint=arrb[b].intell;
                        arrc[count].gint=arrg[a].intell;
                        arrc[count].batr=arrb[b].attr;
                        arrc[count].gatr=arrg[a].attr;
                        arrc[count].bhap=0;
                        arrc[count].ghap=0;
                        arrc[count].com=0;
                        arrc[count].thap=0;
                        arrc[count].gcount=0;
                        arrb[b].status=1;
                        arrg[a].status=1;
                        count++;
                    
                }                
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

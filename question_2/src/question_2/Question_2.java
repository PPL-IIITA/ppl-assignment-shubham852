package question_2;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Question_2 {

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
                            arrc[i].arrg[v1]=arr[v];
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
                        arrc[i].arrg[v1]=arr[v];
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
                            arrc[i].arrg[v1]=arr[v];
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
                        arrc[i].arrg[v1]=arr[v];
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
                            arrc[i].arrg[v1]=arr[v];
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
                        arrc[i].arrg[v1]=arr[v];
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
        
        for(int i=0;i<noc-1;i++){
            for(int j=0;j<noc-1;j++){
                if(arrc[j].com < arrc[j+1].com){
                    couple temp2;
                    temp2=arrc[j+1];
                    arrc[j+1]=arrc[j];
                    arrc[j]=temp2;   
                }
            }
        }
        for(int i=0;i<noc;i++){
            System.out.print(i+1+": Compatible couple is :"+arrc[i].bname );
            System.out.print(" and "+arrc[i].gname );
            System.out.print("\n");
            
        }
        
    }
    
}

package question_6;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Question_6 {

    public static void main(String[] args) throws Exception{
        
        //TAKING T=5 i.e 5 DAYS IN A MONTH
       int t=5;
        
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
        for(int i=0;i<nogift-1;i++){
            for(int j=0;j<nogift-1;j++){
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
                if(arrg[j].attr < arrg[j+1].attr){
                    girls temp;
                    temp=arrg[j+1];
                    arrg[j+1]=arrg[j];
                    arrg[j]=temp;   
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
        
        for(int j=1;j<=t;j++){
            
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
            
            //now we will remove couples with happiness less than t
            //first we sort then in dec. orderr of happiness;
            
            for(int i=0;i<noc-1;i++){
                for(int k=0;k<noc-1;k++){
                    if(arrc[k].thap < arrc[k+1].thap){
                        couple temp2;
                        temp2=arrc[k+1];
                        arrc[k+1]=arrc[k];
                        arrc[k]=temp2;   
                    }
                }
            }
            int k=0;
            for(int i=0;i<noc;i++){
                if(arrc[i].thap<t){
                    k=noc-i;
                    break;
                }                                   
            }
            noc=noc-k;
            if(k==0)
                continue;
            
            couple[] arrnc=new couple[noc];
            for(int i=0;i<k;i++){
                arrnc[i]=new couple();   
            }
            for(int i=0;i<k;i++){
                arrnc[i]=arrc[noc-k+i];
                int m=0;
                while(m<nob){
                    if(arrnc[i].bname==arrb[m].name){
                        arrb[m].status=0;
                        break;
                    }
                    else
                        m++;
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
            int o=0;
            for(int i=0;i<k;i++){
                for(int l=0;l<nob;l++){
                    if(arrnc[i].gatr >= arrb[l].attr && arrnc[i].main <= arrb[l].budget && arrb[l].status==0 && arrb[l].name!=arrnc[i].bname){
                    
                        arrc[noc+o].bname=arrb[l].name;
                        arrc[noc+o].gname=arrnc[i].gname;
                        arrc[noc+o].budget=arrb[l].budget;
                        arrc[noc+o].main=arrnc[i].main;
                        arrc[noc+o].btype=arrb[l].type;
                        arrc[noc+o].gtype=arrnc[i].gtype;
                        arrc[noc+o].bint=arrb[l].intell;
                        arrc[noc+o].gint=arrnc[i].gint;
                        arrc[noc+o].batr=arrb[l].attr;
                        arrc[noc+o].gatr=arrnc[i].gatr;
                        arrb[l].status=1;
                        noc++;
                    }
                }
            }
            for(int a=0;a<nog;a++){            
                for(int b=0;b<nob;b++){                
                    if(arrg[a].attr >= arrb[b].attr && arrb[b].budget >= arrg[a].maint && arrb[b].status==0 &&arrg[a].status==0){                   
                        arrc[noc].bname=arrb[b].name;
                        arrc[noc].gname=arrnc[a].gname;
                        arrc[noc].budget=arrb[b].budget;
                        arrc[noc].main=arrnc[a].main;
                        arrc[noc].btype=arrb[b].type;
                        arrc[noc].gtype=arrnc[a].gtype;
                        arrc[noc].bint=arrb[b].intell;
                        arrc[noc].gint=arrnc[a].gint;
                        arrc[noc].batr=arrb[b].attr;
                        arrc[noc].gatr=arrnc[a].gatr;
                        arrb[b].status=1;
                        arrg[a].status=1;
                        noc++;                                           
                    }                
                }            
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
        System.out.print("couples in order of happiness are. \n");
        for(int i=0;i<noc;i++){
            System.out.print(i+1+": Happiest couple is :"+arrc[i].bname );
            System.out.print(" and "+arrc[i].gname );
            System.out.print("\n");
            
        }
        
    }
    
}

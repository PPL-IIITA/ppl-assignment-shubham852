package question_7;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Question_7 {

    public static void main(String[] args) throws Exception{
       
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
            arrb[i].number=Integer.parseInt(strb);
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
        
        //HERE WE CHOOSE ONE OF THE 3 CASES i.e ARRAY,BINARY SEARCH,HASH;
        //TYPE 1 IS FOR ARRAY
        //TYPE 2 IS FOR BINARY SEARCCH
        //TYPE 3 IS FOR HASHING
        int t=1;
        girls[] arrg=new girls[nob];
        for(int i=0;i<nob;i++){
            arrg[i]=new girls();            
        }
        int countf;
        switch(t){
            
            case 1:
                int count=0;
                for(int i=0;i<nob;i++){                    
                    for(int j=0;j<noc;j++){
                        if(arrb[i].name == null ? arrc[j].bname == null : arrb[i].name.equals(arrc[j].bname)){
                            arrg[count].number=i;
                            arrg[count].name=arrc[j].gname;
                            arrg[count].type=arrc[j].gtype;
                            arrg[count].status=1;
                            arrg[count].maint=arrc[j].main;
                            arrg[count].intell=arrc[j].gint;
                            arrg[count].attr=arrc[j].gatr;
                            System.out.print(arrg[count].name+" is the girlfriend of "+arrb[i].name+". \n");
                            count++;
                        }
                    }                    
                }                
                countf=count;
                break;
            case 2:
                int count1=0;
                for(int i=0;i<nob;i++){                    
                    for(int j=0;j<noc;j++){
                        if(arrb[i].name == null ? arrc[j].bname == null : arrb[i].name.equals(arrc[j].bname)){
                            arrg[count1].number=i;
                            arrg[count1].name=arrc[j].gname;
                            arrg[count1].type=arrc[j].gtype;
                            arrg[count1].status=1;
                            arrg[count1].maint=arrc[j].main;
                            arrg[count1].intell=arrc[j].gint;
                            arrg[count1].attr=arrc[j].gatr;
                            System.out.print(arrg[count1].name+" is the girlfriend of "+arrb[i].name+". \n");
                            count1++;
                        }
                    }                    
                }
                countf=count1;
                for(int i=0;i<count1-1;i++){
                    for(int j=0;j<count1-1;j++){
                        if( arrc[j].main > arrc[j+1].main ){                            
                            girls temp;
                            temp=arrg[j];
                            arrg[j]=arrg[j+1];
                            arrg[j+1]=temp;                            
                        }
                    }
                }
                break;
            case 3:
                int count3=0;
                for(int i=0;i<nob;i++){                    
                    for(int j=0;j<noc;j++){
                        if(arrb[i].name == null ? arrc[j].bname == null : arrb[i].name.equals(arrc[j].bname)){
                            arrg[count3].number=i;
                            arrg[count3].name=arrc[j].gname;
                            arrg[count3].type=arrc[j].gtype;
                            arrg[count3].status=1;
                            arrg[count3].maint=arrc[j].main;
                            arrg[count3].intell=arrc[j].gint;
                            arrg[count3].attr=arrc[j].gatr;
                            System.out.print(arrg[count3].name+" is the girlfriend of "+arrb[i].name+". \n");
                            count3++;
                        }
                    }                    
                }
                countf=count3;
                for(int i=0;i<nob-1;i++){
                    for(int j=0;j<nob-1;j++){
                        if( arrg[j].number > arrg[j+1].number ){                            
                            girls temp;
                            temp=arrg[j];
                            arrg[j]=arrg[j+1];
                            arrg[j+1]=temp;                            
                        }
                    }
                }
                break;
            default:
                int count4=0;
                for(int i=0;i<nob;i++){                    
                    for(int j=0;j<noc;j++){
                        if(arrb[i].name == null ? arrc[j].bname == null : arrb[i].name.equals(arrc[j].bname)){
                            arrg[count4].number=i;
                            arrg[count4].name=arrc[j].gname;
                            arrg[count4].type=arrc[j].gtype;
                            arrg[count4].status=1;
                            arrg[count4].maint=arrc[j].main;
                            arrg[count4].intell=arrc[j].gint;
                            arrg[count4].attr=arrc[j].gatr;
                            System.out.print(arrg[count4].name+" is the girlfriend of "+arrb[i].name+". \n");
                            count4++;
                        }
                    }                    
                }                
                countf=count4;
                break;
        }
        
    }
    
}

import java.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class IibSibEncapOverloadedConstructors{

  int a=15;
  
  int b=20;
  static int c=10;
  static int d=13;
  static int e;
  private int f =70;
  char[] g= new char[100];
  
  public int getF(){
    return f; 
  }
  
  
   public void setF(int z){
    this.f = z;
  }
  
  static{
    e=55;
  }
  
  {
    
    System.out.println(a);
    System.out.println(b);
    
  }
  IibSibEncapOverloadedConstructors(){
    
  }
  IibSibEncapOverloadedConstructors(int x,int y){
    this.a=x;
    this.b=y;
    
  } 
  
  IibSibEncapOverloadedConstructors(String h){
    int j=h.length();
    System.out.println(h.length());
    for(int i=0;i<j;i++){
     g[i]=h.charAt(i);
    }
    printcharg(g);
  }
  
  void printcharg(char[] k){
    for(int l=0;l<k.length;l++){
    if(k[l] != '\u0000'){
      System.out.println(k[l]);
     }
    }
    //using foreach over charArray
    for(char m:k){
      if(m != '\u0000'){
      System.out.println(m);
     }
    }
    //using Iterator over Char array...sadly takes the whole string as value present in one array position
    List<char[]> chlist= Arrays.asList(k);
    Iterator<char[]> charItr=chlist.iterator();
    System.out.println("fromItr");
    while(charItr.hasNext()){
      System.out.println(charItr.next());
      
    } 
  }
  public static void main(String[] args) {
  System.out.println(e);
  new IibSibEncapOverloadedConstructors();
  System.out.println(IibSibEncapOverloadedConstructors.c);
  System.out.println(IibSibEncapOverloadedConstructors.d);
  
  IibSibEncapOverloadedConstructors cn=new IibSibEncapOverloadedConstructors(27,53);
  System.out.println(cn.a);
  System.out.println(cn.b);
  System.out.println(cn instanceof IibSibEncapOverloadedConstructors);
  System.out.println(cn.getF());
  cn.setF(90);
  System.out.println(cn.getF());
  IibSibEncapOverloadedConstructors cns=new IibSibEncapOverloadedConstructors("Test");
  System.out.println(cns.g);
  }
}

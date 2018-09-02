import java.util.ArrayList;
import java.util.List;


public class ColList {
  int i;
  
   public void arrayList(){
    ArrayList<Integer> al = new ArrayList<Integer>();
    System.out.println(al.isEmpty());
    for(i=0;i<8;i++){
      al.add(i,i+11);
    }
   System.out.println(al.size()); 
   System.out.println(al);
   al.add(5,24);
   System.out.println(al);
   System.out.println(al.contains(24));
   Object o = al.clone();
   System.out.println(o);
   System.out.println(al.equals(o));
   al.ensureCapacity(5);
   System.out.println(al);
   System.out.println(al.get(5));
   System.out.println(al.getClass());
   System.out.println(al.hashCode());
   System.out.println(al.indexOf(24));
   System.out.println(al.iterator().next());
   System.out.println(al.lastIndexOf(24));
   al.remove(7);
   al.set(6,37);
   System.out.println(al.subList(1,8));
   List<Integer> l=al.subList(1,8);
   String ia= o.toString();
   System.out.println(al.toArray());
   System.out.println(ia);
   al.set(7,null);
   System.out.println(al);
   al.trimToSize();
   System.out.println(al); 
   //al.forEach();
  }
  
  class linkedList{
    
  }
  
  class vector{
    
  }
  
  class queue{
    
  }
  public static void main(String[] args) {
  ColList cl= new ColList(); 
  cl.arrayList();
  }

}

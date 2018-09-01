import java.util.ArrayList;
import java.util.List;


public class Alist {

  public static void main(String[] args) {
  List<Integer> al1=new ArrayList<Integer>();
  al1.add(15);
  al1.add(1,45);
  al1.add(25);
  //al1.add(2,30.50);
  System.out.println(al1);
  List<Object> al2=new ArrayList<Object>();
  al2.add(35);
  al2.add(25.15);
  al2.add(25);
  al2.add("string");
   System.out.println(al2);
  //al1.removeAll(al2);
   System.out.print(al1);{}
- [ ]    al2.retainAll(al1);
    System.out.print(al2);
  }

}

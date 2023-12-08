import java.util.*;
import java.util.regex.*;

class Pair {
    String l, r;
    Pair(String l, String r) {
        this.l = l;
        this.r = r;
    }
}

public class Day8 {
    public static long gcd(long a, long b) {
        if(b == 0L) return a;
        return gcd(b, a%b);
    }
    public static long lcm(long a, long b) {
        return (a*b)/(gcd(a, b));
        
    }
    public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);
  String moves = sc.nextLine();
  
  
  Pattern p = Pattern.compile("(\\w{3}) = \\((\\w{3}), (\\w{3})\\)");
  Map<String, Pair> mp = new HashMap<>();
  
  
  while(sc.hasNext()) {
      String ln = sc.nextLine();
      Matcher m = p.matcher(ln);
      m.find();
     String a = m.group(1);
     String b = m.group(2);
     String c = m.group(3);
     
     mp.put(a, new Pair(b, c));
     
     

     
     
  }
  
  List<String> curr = new ArrayList<>();
 
  
  for(String str : mp.keySet()) {
      if(str.endsWith("A")) {
          curr.add(str);
      }
  }
  
  List<Integer> steps = new ArrayList<>();
  
  int cs = 0;
  
  int i = 0;
  
       for(int zz = 0; zz < curr.size(); zz++) {
  cs = 0;
 i = 0;
 
 String cr = curr.get(zz);
 
 while(!cr.endsWith("Z")) {
           cs++;
      char step = moves.charAt(i);
      if(step=='L') cr = mp.get(cr).l;
      else cr = mp.get(cr).r;
      i = (i + 1)%moves.length();
 }
 
 steps.add(cs);
 
 
 
    
   
 
      
 

  }
  
  
  long ans = steps.get(0);
  
  for(int ii = 1; ii < steps.size(); ii++) {
      ans = lcm(ans, steps.get(ii));
  }
  
  System.out.println(ans);
  
  
  
  
  
  
 
    }
}



import java.util.*;
class Hand {
    int bid;
    String cards;
    Hand(String c, int b) {
        this.bid = b;
        this.cards = c;
    }
}



public class Day7 {
    
    public static boolean p1(String s) {
        char st = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != st) return false;
        }
        return true;
    }
    
    public static boolean p2(String s) {
        Map<Character, Integer> fq = new HashMap<>();
        for(int i = 0;i  < s.length(); i++) {
            fq.put(s.charAt(i), fq.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(fq.size() != 2) return false;
        Collection<Integer> vals = fq.values();
        for(Integer val: vals) {
            if(val != 1 && val != 4) return false;
        }
        return true;
    } 
    
        public static boolean p3(String s) {
        Map<Character, Integer> fq = new HashMap<>();
        for(int i = 0;i  < s.length(); i++) {
            fq.put(s.charAt(i), fq.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(fq.size() != 2) return false;
        Collection<Integer> vals = fq.values();
        for(Integer val: vals) {
            if(val != 2 && val != 3) return false;
        }
        return true;
    } 
    
    
          public static boolean p4(String s) {
        Map<Character, Integer> fq = new HashMap<>();
        for(int i = 0;i  < s.length(); i++) {
            fq.put(s.charAt(i), fq.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(fq.size() != 3) return false;
        Collection<Integer> vals = fq.values();
        for(Integer val: vals) {
            if(val != 1 && val != 3) return false;
        }
        return true;
    } 
    
             public static boolean p5(String s) {
        Map<Character, Integer> fq = new HashMap<>();
        for(int i = 0;i  < s.length(); i++) {
            fq.put(s.charAt(i), fq.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(fq.size() != 3) return false;
        Collection<Integer> vals = fq.values();
        for(Integer val: vals) {
            if(val != 1 && val != 2) return false;
        }
        return true;
    } 
    
     
             public static boolean p6(String s) {
        Map<Character, Integer> fq = new HashMap<>();
        for(int i = 0;i  < s.length(); i++) {
            fq.put(s.charAt(i), fq.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(fq.size() != 4) return false;
        Collection<Integer> vals = fq.values();
        for(Integer val: vals) {
            if(val != 1 && val != 2) return false;
        }
        return true;
    } 
    
       
             public static boolean p7(String s) {
        Map<Character, Integer> fq = new HashMap<>();
        for(int i = 0;i  < s.length(); i++) {
            fq.put(s.charAt(i), fq.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(fq.size() != 5) return false;
       
        return true;
    } 
    
    
    public static int strcmp(String a, String b) {
        List<Character> ordr = List.of('J','2','3','4','5','6','7','8','9','T','Q','K','A');
        
        for(int i = 0; i < a.length(); i++) {
            int cmp = Integer.compare(ordr.indexOf(a.charAt(i)), ordr.indexOf(b.charAt(i)));
            if(cmp != 0) return -cmp;
        }
        return 0;
    }
    
    
    public static String getBestCards(String crds) {
        
       
        
        Map<Character, Integer> fq = new HashMap<>();
        
        for(int i = 0; i < crds.length(); i++) {
            char curr = crds.charAt(i);
            if(curr != 'J') {
                 fq.put(curr, fq.getOrDefault(curr, 0) + 1);
            }
        }
        
        List<Integer> tmp = new ArrayList<>(fq.values());
        if(tmp.isEmpty()) return "AAAAA";
        int mx_fq = Collections.max(tmp);
        
         List<Character> ordr = new ArrayList<>(List.of('J','2','3','4','5','6','7','8','9','T','Q','K','A'));
        Collections.reverse(ordr);
        
        for(char x : ordr) {
            if(x == 'J') continue;
            if(fq.getOrDefault(x,0) == mx_fq) {
                return crds.replace("J", Character.toString(x));
            }
        }
        
        return "AAAAA";
        
        
        
    }
    
    public static int getP(Hand h) {
        if(p1(getBestCards(h.cards))) return 1;
          if(p2(getBestCards(h.cards))) return 2;
            if(p3(getBestCards(h.cards))) return 3;
              if(p4(getBestCards(h.cards))) return 4;
                if(p5(getBestCards(h.cards))) return 5;
                  if(p6(getBestCards(h.cards))) return 6;
                    if(p7(getBestCards(h.cards))) return 7;
                   
      
        return 8;
    }
    
    
    
    
    public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    List<Hand> hands = new ArrayList<>();
    
    Comparator<Hand> cmph = (Hand a, Hand b) -> {
        int pa = getP(a), pb = getP(b);
        int cmp = Integer.compare(pa, pb);
        if(cmp != 0) return cmp;
        return strcmp(a.cards, b.cards);
        
    };
    
    while(sc.hasNext()) {
        String ln = sc.nextLine();
        StringTokenizer st = new StringTokenizer(ln);
        hands.add(new Hand(st.nextToken(), Integer.parseInt(st.nextToken())));
    }
    
    Collections.sort(hands, cmph);
    
    long ans = 0;
    
    for(int i = 0; i < hands.size(); i++) {
   //     System.out.printf("%s, %d%n",hands.get(i).cards, hands.get(i).bid);
        ans += (hands.size() - i)*((long)hands.get(i).bid);
    }
    
    System.out.println(ans);
    
    
    
    


    }
}

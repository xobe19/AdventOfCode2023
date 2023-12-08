    public class Day6 {
    
    public static long calc_dist(long holding_time, long total_time) {
        return (total_time - holding_time)*holding_time;
    }
    
    public static void main(String args[]) {
 
    
    long time = 48876981L;
    long dist = 255128811171623L;
    
    
    
    long ans = 0;
    
    long st = 0, en = time;
    
    while(st <= en) {
        long mid = st + (en - st)/2;
        
        long lft = mid - 1;
        long rgt = mid + 1;
        
        lft = lft < 0 ? 0 : lft;
        rgt = rgt > time ? time : rgt;
        
        long dm = calc_dist(mid, time);
        long dl = calc_dist(lft, time);
        long dr = calc_dist(rgt, time);
        
        if(dl <= dm && dm <= dr) {
            
        }
        else {
            
        }
        
        
        
    }
    
    
    
    
    
    for(int i = 0; i < time.length; i++) {
        int race_time = time[i];
        int dist_to_beat = dist[i];
        
        
        long ways_to_win = 0;
        
        for(int holding_time = 0; holding_time <= race_time; holding_time++) {
            long dist_trav = (race_time - holding_time) * (holding_time);
            if(dist_trav > dist_to_beat) {
                ways_to_win++;
            }
        }
        ans *= ways_to_win;
    }
    
    System.out.println(ans);
    
    
    }
}

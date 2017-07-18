/**
 * Created by chien on 5/11/2017.
 */
import java.util.*;
public class JessAndCookiesHackerrank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();
        Queue queue = new PriorityQueue();
        for(int i = 0; i<N;i++){
            queue.add(scanner.nextInt());
        }
        boolean stop = false;
        int count = 0;
        if((int)queue.peek()>K){
            System.out.println(count);
            stop = true;
        }
        while(stop == false){
            if(queue.size()!=0){
                count++;
                int min1 = (int) queue.poll();
                if(queue.size()!=0){
                    int min2 = (int) queue.poll();
                    int min = min1 + min2*2;
                    queue.add(min);
                    if((int)queue.peek()>K){
                        stop = true;
                        System.out.println(count);
                    }
                }
                else{
                    stop = true;
                    System.out.println(-1);
                }

            }
            else{
                stop = true;
                System.out.println(-1);
            }
        }
    }
}

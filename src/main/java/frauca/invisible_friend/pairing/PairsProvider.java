package frauca.invisible_friend.pairing;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class PairsProvider {

    public List<Pair> makePairs(List<Friend> friends){
       if(friends == null || friends.isEmpty()){
           return Collections.emptyList();
       }
       val receivers = new LinkedList<>(friends);
       Collections.shuffle(receivers);
       val givers = moveOneToTheRight(receivers);
       return makePairs(receivers ,givers);
    }

    private List<Pair> makePairs(Queue<Friend> givers,Queue<Friend> receivers){
        val pairs = new ArrayList<Pair>();
        while (!givers.isEmpty()){
            val giver= givers.poll();
            val receiver = receivers.poll();
            pairs.add(new Pair(giver, receiver));
        }
        return pairs;
    }

    private Queue<Friend> moveOneToTheRight(Queue<Friend> givers){
        val first = givers.peek();
        val receivers = new LinkedList<>(givers);
        receivers.poll();
        receivers.add(first);
        return receivers;
    }
}

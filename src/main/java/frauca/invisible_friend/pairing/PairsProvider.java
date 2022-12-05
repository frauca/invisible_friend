package frauca.invisible_friend.pairing;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

@Slf4j
public class PairsProvider {

    public List<Pair> makePairs(List<Friend> friends){
       if(friends == null || friends.isEmpty()){
           return Collections.emptyList();
       }
       val shufled = new ArrayList<>(friends);
       Collections.shuffle(shufled);
       return makePairs(new LinkedList(shufled),new LinkedList<>(friends));
    }

    private List<Pair> makePairs(Queue<Friend> givers,Queue<Friend> receivers){
        val pairs = new ArrayList<Pair>();
        while (randomPairingPossible(givers, receivers)){
            val pair = nextPair(givers,receivers);
            pairs.add(pair);
        }
        pairs.addAll(last3Pairs(givers,receivers));
        return pairs;
    }

    private Pair nextPair(Queue<Friend> givers,Queue<Friend> receivers){
        val giver = givers.poll();
        val receiver = receivers.poll();
        if(giver.equals(receiver)){
            val nextGiver = givers.poll();
            givers.add(giver);
            return new Pair(nextGiver,receiver);
        }
        return new Pair(giver,receiver);
    }
    private List<Pair> last3Pairs(Queue<Friend> givers,Queue<Friend> receivers){
        val repeatedFirst = givers.stream()
                .sorted((a,b)->{
                    if(receivers.contains(a) && !receivers.contains(b)){
                        return -1;
                    } else if(!receivers.contains(a) && receivers.contains(b)){
                        return 1;
                    }
                    return 0;
                })
                .toList();
        val orderedGivers = new LinkedList<>(repeatedFirst);
        log.trace("Last 3 givers {} receivers {}\n The sorted list is {}",givers, receivers,orderedGivers);
        return IntStream.range(0,orderedGivers.size())
                .mapToObj(ignore->nextPair(orderedGivers,receivers))
                .toList();
    }

    private boolean randomPairingPossible(Queue<Friend> givers,Queue<Friend> receivers){
        return givers.stream()
                .filter(friend->receivers.contains(friend))
                .count() > givers.size() - 1;
    }
}

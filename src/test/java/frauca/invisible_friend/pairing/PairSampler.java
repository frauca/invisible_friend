package frauca.invisible_friend.pairing;

import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class PairSampler {

    public Pair sample(){
        val giver = FriendSampler.friends().get(0);
        val receiver = FriendSampler.friends().get(1);
        return new Pair(giver, receiver);
    }
}

package frauca.invisible_friend.pairing;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@UtilityClass
public class FriendSampler {
    List<Friend> friends = sampleFriends(15);

    public List<Friend> friends(){
        return friends;
    }

    public Friend friend(){
        return selectRandomFriendFrom(friends);
    }

    List<Friend> sampleFriends(int numberOfFriends){
        return IntStream.range(0,numberOfFriends)
                .mapToObj(i->new Friend("Friend"+i,"friend%s@mail.com".formatted(i)))
                .toList();
    }

    private Friend selectRandomFriendFrom(List<Friend> friends){
        return friends.get(new Random().nextInt(friends.size()));
    }
}
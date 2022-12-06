package frauca.invisible_friend.pairing;

import lombok.val;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PairsProviderTest {

    private static final int SAVETY_RANDOM_REPETITIONS=5000;
    PairsProvider provider = new PairsProvider();

    @Test
    void nullOrEmpty(){
        assertThat(provider.makePairs(null)).isEmpty();
        assertThat(provider.makePairs(Collections.emptyList())).isEmpty();
        val oneFriend = List.of(FriendSampler.friend());
        assertThat(provider.makePairs(oneFriend)) .isEmpty();
    }

    @RepeatedTest(SAVETY_RANDOM_REPETITIONS)
    void makePairs(){
        val friends = FriendSampler.friends();

        val pairs = provider.makePairs(friends);

        val allNames = friends.stream().map(Friend::name).toList();

        assertThat(pairs).map(pair->pair.giver().name()).containsExactlyInAnyOrderElementsOf(allNames);
        assertThat(pairs).map(pair->pair.receiver().name()).containsExactlyInAnyOrderElementsOf(allNames);
        assertThat(pairs).filteredOn(pair->pair.giver().equals(pair.receiver())).isEmpty();
    }

}
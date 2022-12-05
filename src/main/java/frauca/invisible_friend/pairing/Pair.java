package frauca.invisible_friend.pairing;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record Pair(@NonNull Friend giver, @NonNull Friend receiver) {
}

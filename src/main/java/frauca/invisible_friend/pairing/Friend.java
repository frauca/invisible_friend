package frauca.invisible_friend.pairing;

import java.util.Comparator;

public record Friend(String name, String mail) {
    @Override
    public boolean equals(Object o) {
        if(o instanceof Friend other){
            return name.equals(other.name);
        }
        return false;
    }
}

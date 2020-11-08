package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> members= new ArrayList<>();//

    public SocialNetwork() {
        this.members = members;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "members=" + members +
                '}';
    }

    public void addMember(String name) {
        Member memb = new Member(name);
        members.add(memb);
    }

    public void connect(String name, String otherName) {

            findByName(name).connectMember(findByName(otherName));

        }


    private Member findByName(String name) {
        for (Member mem : members) {
            if (mem.getName() == name) {
                return mem;
            }
        }
        return null;  //ha nem találja
    }

}

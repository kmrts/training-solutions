package references.socialnetwork;

import java.util.List;

public class SocialNetwork {
    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public void addMember(String name) {
        Member memb = new Member(name);
        members.add(memb);
    }

    public void connect(String name, String otherName) {

//        Member mem1 = new Member("noname");
//        Member mem2 = new Member("noname");
//        boolean isMember1 = false;
//        boolean isMember2 = false;
//        for (Member mem : members) {
//            if (mem.getName() == name) {
//                isMember1 = true;
//                mem1 = mem;
//            }
//            if (mem.getName() == otherName) {
//                isMember2 = true;
//                mem2 = mem;
//            }
//        }
//        if (isMember1 && isMember2) {
//            //getConba benn vane-
//            for (Member mem : mem1.getConnections()) {
//
//            }
//        mem1.connectMember(mem2);
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

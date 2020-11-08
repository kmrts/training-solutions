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
            //leh.ne ell, van-e már conn.-va

            findByName(name).connectMember(findByName(otherName));

    }
    public List<String> bidirectionalConnections(){
        List<String> bidiConns= new ArrayList<>();
        for (Member mem1: members){
            for (Member mem2: mem1.getConnections() ){
                if(mem2.getConnections().contains(mem1)){
                    bidiConns.add(mem1.getName() +" - "+ mem2.getName());
                }
            }
        }
        return bidiConns;
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

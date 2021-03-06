package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> connections= new ArrayList<>();//

    public Member(String name) {
        this.name = name;

    }
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", connections=" + connectedNames()+ //
                '}';
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }
    public void connectMember(Member member){
        connections.add(member);
    }
    public List<String> connectedNames(){
        List<String> connNam= new ArrayList<>();
        for (Member mem: connections){
            connNam.add(mem.getName());
        }
        return connNam;
    }

}

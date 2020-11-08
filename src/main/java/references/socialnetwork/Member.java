package references.socialnetwork;

import week02.project1.MeetingRoom;

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
                ", connections=" + connections +
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

}

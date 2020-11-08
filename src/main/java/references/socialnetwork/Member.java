package references.socialnetwork;

import week02.project1.MeetingRoom;

import java.util.List;

public class Member {
    private String name;
    private List<Member> connections;

    public Member(String name) {
        this.name = name;

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

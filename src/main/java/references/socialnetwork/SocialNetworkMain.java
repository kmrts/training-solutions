package references.socialnetwork;

public class SocialNetworkMain {
    public static void main(String[] args) {

        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.addMember("Joe");
        socialNetwork.addMember("John");
        socialNetwork.addMember("Jane");
        socialNetwork.addMember("Richard");

        System.out.println(socialNetwork);
//        SocialNetwork{members=[Member{name='Joe', connections=[]},
//        Member{name='John', connections=[]},
//        Member{name='Jane', connections=[]},
//        Member{name='Richard', connections=[]}]}

        socialNetwork.connect("Joe", "John");
        socialNetwork.connect("John", "Joe");

        System.out.println(socialNetwork);
//        SocialNetwork{members=[Member{name='Joe', connections=[John]},
//        Member{name='John', connections=[Joe]},
//        Member{name='Jane', connections=[]},
//        Member{name='Richard', connections=[]}]}

        System.out.println(socialNetwork.bidirectionalConnections());


    }
}

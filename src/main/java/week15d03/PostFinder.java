package week15d03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {
    /*
    Adott az alábbi osztály:
java
public class Post {
    private String title;
    private LocalDate publishedAt;
    private String content;
    private String owner;
}
Implementáljunk a PostFinder osztályban egy public List<Post> findPostsFor(String user) metódust az alábbi módon:
- Csak olyan Post-ot adjunk vissza, amelynek az owner-e megegyezik a megadott user-rel
- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
- A content és a title nem lehet üres
Tároljunk egy List<Post> objektumot a PostFinder osztályban, melyet konstruktor paraméterként kap meg és ezt használjuk!
     */
    private List<Post> posts = new ArrayList<>();

    public PostFinder(List<Post> foundPosts) {
        this.posts = foundPosts;
    }

    public List<Post> getFoundPosts() {
        return new ArrayList<>(posts);
    }

    public List<Post> findPostsFor(String user) {
        List<Post> foundedPosts = new ArrayList<>();

        for (Post p : posts) {
            if (p.getOwner().equals(user) && p.getPublishedAt().isBefore(LocalDate.now())
//                    && !p.getContent().isEmpty() && !p.getTitle().isEmpty()) {
                    && !isNullOrEmpty(p.getContent()) && !isNullOrEmpty(p.getTitle())) {

                foundedPosts.add(p);
            }
        }
        return foundedPosts;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}

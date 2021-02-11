package week15d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week11d01.PairFinder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    List<Post> samplePosts;
    PostFinder pf;

    @BeforeEach
    void init(){
        samplePosts= Arrays.asList(
                new Post("Miről", LocalDate.parse("2020-12-20"), "Itt a szöveg", "Joe J"),
                new Post("Erről", LocalDate.parse("2020-12-23"), "Szöveg erről", "Katja K"),
                new Post("Arról", LocalDate.parse("2021-03-20"), "Rege arról", "Joe J"),
                new Post("Emerről", LocalDate.parse("2021-01-20"), "", "Joe J") );

        pf= new PostFinder(samplePosts);
    }

    @Test
    void testGetFoundPosts() {

//        PostFinder pf= new PostFinder(samplePosts);
        assertEquals("Szöveg erről", pf.getFoundPosts().get(1).getContent() );

    }

    @Test
    void testFindPostsFor() {

//        PostFinder pf= new PostFinder(samplePosts);
        List<Post> testList= pf.findPostsFor("Joe J");

        assertEquals(1, testList.size());
        assertEquals(LocalDate.of(2020, 12,20), testList.get(0).getPublishedAt());

    }
}
package interfacedefaultmethods.print;

public interface Printable {
    //A feladat során egy nyomtatót és különböző nyomtatható anyagokat (újság, mesekönyv) kell implementálni.
    // A nyomtató képes színesben nyomtatni. Az újság csak fekete-fehér lehet, míg a mesekönyv színes
    // (különböző oldalak lehetnek különböző színűek). A nyomtató nyomtatáskor a színeket vezérlőkarakterekkel jelzi.
    //
    //Írj egy Printable interfészt a getLength(), getPage(), és getColor() metódusokkal.
    // A getColor() metódus default implementációja, hogy mindig feketét ad vissza,
    // ami az interfészben egy konstans #000000 érték.
    //
    //A Printable interfészt implementálja a NewsPaper és StoryBook osztály is.


//    int length;
//    private int page;
    String BLACK= "#000000";  //


    int getLength();
    String getPage(int page);
    default String getColor(int page){
        return BLACK;
    }

}

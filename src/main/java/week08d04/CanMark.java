package week08d04;

public interface CanMark {
    //egy `CanMark` interfészt egy `int giveMark()` metódussal! Ez azt jelenti, hogy valaki
    //tud osztályzatot adni. Ennek legyen két implementációja, egy `GoodMood`
    //osztály, mely mindig `5` értéket ad vissza, és egy `BadMood` osztály, mely mindig `3` értéket ad vissza!
    //Azaz jó hangulatban valaki mindig ötöst ad, rossz hangulatban hármast.

    int giveMark();

}

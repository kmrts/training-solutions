package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
    /*
    Írj egy PhotoCollection osztályt, mely a fotók egy listáját tartalmazza!
Fotókat lehet hozzáadni névvel, ekkor még nem kapnak csillagot. Az addPhoto() metódus legyen varargs-os!
Írj egy starPhoto() metódust, mely kikeresi a megfelelő nevű fotót, és beállítja rajta a paraméterként átadott minősítést!
Ha nem talál a megadott névvel fotót, PhotoNotFoundException kivételt dob.
Ez egy saját kivétel, terjessze ki a RuntimeException osztályt!
Írj egy numberOfStars() metódust, mely visszaadja, hogy a képeken összesen mennyi csillag van!
Ha nincs minősítése, akkor 0 csillag. Ha a minősítése Quality.ONE_STAR, akkor egy csillaggal kell számolni.
Ha a minősítése Quality.TWO_STAR, akkor két csillaggal kell számolni.
Tartsd be az elnevezési konvenciókat! A megoldásban csak foreach-eket használj!
     */
    private List<Photo> photos= new ArrayList<>();

    public List<Photo> getPhotos() {
//        return photos;
        return new ArrayList<>(photos);
    }

    public void addPhoto(String... names){
        for(String name: names){
            this.photos.add(new Photo(name));
        }
    }
    public void starPhoto(String name, Quality quality){
        for(Photo photo: photos){
            if(photo.getName().equals(name)){  // not ==
                photo.setQuality(quality);
                return;
            }

        }
        throw new IllegalArgumentException("No found");
    }
    public int numberOfStars(){
        int sum= 0;
        for(Photo photo: photos){
            if(photo.getQuality()== Quality.ONE_STAR){
                sum++;
            }
            if(photo.getQuality()== Quality.TWO_STAR){
                sum += 2;
            }
        }
        return sum;
    }

}

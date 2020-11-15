package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    List<Pet> petList= new ArrayList<>();

//    public Vet(List<Pet> petList) {
//        this.petList = petList;
//    }

    public List<Pet> getPetList() {
        return petList;
    }
    //    public void add(Pet newPet){
//        boolean petExists= false;
//        for(Pet item: petList){
//            if(areEquals(item, newPet)){
//                System.out.println("már létezik az adatbázisban");
//                petExists= true;
//                break;
//            }
//        }
//        if (!petExists){
//            petList.add(newPet);
//        }

    public void add(Pet pet) {
        for (Pet pet1 : petList) {
            if (areEquals(pet1, pet)) {
                return;
            }
        }
        petList.add(pet);
    }

    public boolean areEquals(Pet p1, Pet p2){
        return p1.getRegNumber().equals(p2.getRegNumber());
    }
}

package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {
    /*
    Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név,
    valamint skillek (hogy mihez ért az illető). A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.
Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.
A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).

A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.
     */
    private String name;
    private List<Skill> skills= new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public int findSkillLevelByName(String skillName){
        int result= 0;
        for(Skill skill: skills){
            if(skill.getName()== skillName){
                result= skill.getLevel();
                break;
            }
        }
        return result;
    }
    public void addSkills(List<String> skills){

    }
}


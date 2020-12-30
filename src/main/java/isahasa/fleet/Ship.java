package isahasa.fleet;

public interface Ship {
    //A flottában vegyesen vannak teherszállító hajók (cargo ship), személyszállító hajók (liner)
    // és kompok (ferry boat).
    // A kompok személyeket és terhet is szállíthatnak.
    // Ha a flotta behajóz, akkor folyamatosan töltik fel a hajókat, mindaddig, amíg meg nem telnek, el nem fogy az utas,
    // vagy teher.
    //
    //Hozz létre egy Ship interfészt, mely a hajót jelöli (marker interfész, metódus nélkül),
    // egy CanCarryGoods és CanCarryPassengers interfészt, mely azt jelöli,
    // hogy egy hajó tud-e személyeket, vagy terhet szállítani.
    // A CanCarryGoods interfészben hozz létre egy int loadCargo(int cargoWeight) és int getCargoWeight() metódust.
    // A CanCarryPassengers interfészben egy int loadPassenger(int passengers) és egy int getPassengers() metódust.

        }

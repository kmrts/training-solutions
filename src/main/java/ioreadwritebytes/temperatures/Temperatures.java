package ioreadwritebytes.temperatures;

public class Temperatures {
    /*
    Az előző 365 nap hőmérsékleti adatait fájlban tároljuk. A Temperatures osztály attribútumában ezek találhatók egy byte[]-ben.
    Az osztály konstruktorban kapja meg a hőmérsékleti adatokat.
    A getYearAverage() metódusa a teljes év átlaghőmérsékletét adja vissza,
    a getMonthAverage() az utolsó 30 napét.
    Készíts egy TemperatureReader osztályt, mely egyetlen readTemperatures() metódusa bináris fájlból
    beolvassa az eltárolt hőmérsékleteket, és egy Temperatures példánnyal tér vissza!
    Ugyanennek mintájára készíts egy TemperaturesWriter osztályt, amelynek a writeTemperatures() metódusa
    a paraméterként kapott Temperatures példányból bináris fájlba írja a hőmérsékleti adatokat!

    + uml ábra
     */
    private byte[] data;  //= new byte[365]

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage(){
        double sum= 0;
        int count= 0;
        for(byte b: data){
            sum+= b;
            count++;
        }
        return sum/ count;
    }

    public double getMonthAverage(){
        if(data.length< 30){
            throw new IllegalStateException("less than 30");
        }
        int index= data.length- 30;
        double sum= 0;
        for(int i= 0; i< 30; i++){
            sum+= data[index+i];
        }
        return sum/ 30;
    }

}

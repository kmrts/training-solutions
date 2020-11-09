package enumtype.unit;

public class UnitConverterMain {

    public static void main(String[] args) {

        UnitConverter uc= new UnitConverter();

        System.out.println(uc.round4(uc.convert(100, LengthUnit.METER, LengthUnit.INCH)));

        System.out.println(uc.convert(32, LengthUnit.FOOT, LengthUnit.YARD));
        System.out.println(uc.round4(uc.convert(32, LengthUnit.FOOT, LengthUnit.YARD)));

        System.out.println(uc.siUnits());
    }
}

package enumtype.unit;

public enum LengthUnit {
    MILLIMETER(true, 1),
    CENTIMETER(true, 10),
    METER(true, 1000),
    YARD(false, 914.4),
    FOOT(false, 304.8),
    INCH(false, 25.4);

    private final boolean siOrNot;
    private final double toMm;

    LengthUnit(boolean siOrNot, double toMm) {
        this.siOrNot = siOrNot;
        this.toMm = toMm;
    }

    public boolean isSiOrNot() {
        return siOrNot;
    }

    public double getToMm() {
        return toMm;
    }
}

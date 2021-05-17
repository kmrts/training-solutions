package week06d05.senior;

public enum BottleType {
    GLASS_BOTTLE(1000), PET_BOTTLE(750);

    private final int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}

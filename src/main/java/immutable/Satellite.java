package immutable;

public class Satellite {

    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if(isEmpty(registerIdent)){
            throw new IllegalArgumentException("Register ident must not be empty!");
        } //else
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    @Override
    public String toString() {
//        return registerIdent+ ": CelestialCoordinates: x="+ getDestinationCoordinates().getX()+ ", y="
//                +getDestinationCoordinates().getY()+ ", z="+ getDestinationCoordinates().getZ();
                  //ASD567: CelestialCoordinates: x=14, y=25, z=47
        return String.format("%s: CelestialCoordinates: x=%d, y=%d, z=%d", registerIdent, getDestinationCoordinates().getX(),
                getDestinationCoordinates().getY(), getDestinationCoordinates().getZ());
    }

    public void modifyDestination(CelestialCoordinates diff){
        CelestialCoordinates newCoord= new CelestialCoordinates(destinationCoordinates.getX()+diff.getX(),
                destinationCoordinates.getY()+diff.getY(),
        destinationCoordinates.getZ()+diff.getZ() );
        destinationCoordinates= newCoord;
    }
    private boolean isEmpty(String str){
        if(str.equals("")){
            return true;
        }else{
            return false;
        }
    }
}

package enumabstract;

public enum OrderState implements Deletable{

    NEW{
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    CONFIRMED{
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    PREPARED{
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    ONBOARD{
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    DELIVERED{
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    RETURNED{
        @Override
        public boolean canDelete() {
            return false;
        }
    },
    DELETED{
        @Override
        public boolean canDelete() {
            return false;
        }
    };

//    @Override                         //ezzel is műk.
//    public boolean canDelete() {
//        boolean deletable= false;
//        switch (this){
//            case NEW, CONFIRMED, PREPARED:
//                deletable= true;
//                break;
//            case ONBOARD, DELIVERED, RETURNED, DELETED:
//                deletable= false;
//                break;
//        }
//        return deletable;
//    }
}

package statemachine.typewriter;

public enum TypeWriterState {
    //van egy régi hagyományos írógép, aminek a CAPS LOCK-ja elromlott és minden sor végén vált automatikusan.
    // Ha kisbetűs sort írtak vele, akkor nagybetűre vált, ha nagybetűs sort írtak, akkor kisbetűre vált.
    UPPERCASE{
        TypeWriterState next(){
            return TypeWriterState.LOWERCASE;
        }
    },
    LOWERCASE{
        TypeWriterState next(){
            return TypeWriterState.UPPERCASE;
        }
    };

    abstract TypeWriterState next();
}

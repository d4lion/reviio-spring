package co.reviio.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {
    @Named("stateStringToBoolean")
    public static Boolean stringToBoolean(String estado) {
        if (estado == null) {
            return null;
        }



        return switch (estado.toUpperCase()) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }

    @Named("stateBooleanToString")
    public static String booleanToString(Boolean state) {
        return state == null ? null : (state ? "D" : "N");
    }



}

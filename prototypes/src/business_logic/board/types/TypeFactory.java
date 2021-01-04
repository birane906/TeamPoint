package business_logic.board.types;

public class TypeFactory {
    public static Type createType(int id, String name, String description){
        switch (name) {
            case "DateType":
                return new DateType(id, name, description);
            case "DependencyType":
                return new DependencyType(id, name, description);
            case "NumberType":
                 return new NumberType(id, name, description);
            case "PersonType":
                return new PersonType(id, name, description);
            case "StatusType":
                return new StatusType(id, name, description);
            case "TimelineType":
                return new TimelineType(id, name, description);
            default:
                return null;
        }
    }
}
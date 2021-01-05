package business_logic.board.types;

public class TypeFactory {
    /**
     * 
     * @param id
     * @param name must be the Class class.getSimpleName()
     * @param description
     * @return
     */
    public static Type createType(int id, String name, String description){
        switch (name) {
            case "DateType":
                return new DateType(id, description);
            case "DependencyType":
                return new DependencyType(id, description);
            case "NumberType":
                 return new NumberType(id, description);
            case "PersonType":
               // return new PersonType(id, description);
            case "StatusType":
                return new StatusType(id, description);
            case "TimelineType":
                return new TimelineType(id, description);
            default:
                return null;
        }
    }
}
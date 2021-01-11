package business_logic.board.types;

public class TypeFactory {
    /**
     * 
     * @param id of the type
     * @param name must be the Class class.getSimpleName()
     * @param description of the type
     * @return of the type
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
                return new PersonType(id, description);
            case "StatusType":
                return new StatusType(id, description);
            case "TimelineType":
                return new TimelineType(id, description);
            case "TextType":
                try {
                    return new TextType(id, description);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
                return null;
        }
    }
}
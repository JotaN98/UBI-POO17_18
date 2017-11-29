import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Entity {
    // -- beginning of static fields
    // -- vars
    private static Map<String, String> groups; // group, groupID
    static {
        groups = new HashMap<String,String>();
        groups.put("Aluno","ALU");
        groups.put("Aula","AUL");
        groups.put("Curso","CUR");
        groups.put("Disciplina","DIS");
        groups.put("Nota","NOT");
        groups.put("Pessoa","PSS");
        groups.put("Professor","PRF");
        groups.put("Teste","TST");
        groups.put("Turma","TRM");

        groups.put("Outro","???");
    }
    // -- methods
    protected static String getGroupIDFromGroup(Object groupClass){
        return groups.get(groupClass.getClass().getName());
    }
    protected static String getGroupIDFromGroup(String group){
        return groups.get(group);
    }
    protected static String getGroupFromID(String groupID){
        for(Map.Entry<String, String> entry : groups.entrySet()){
        	if(groupID == entry.getValue()){
        		return(entry.getKey());
        	}
        }
        return(null);
    }

    // -- beginning of non static fields
    // -- vars
    private String groupID;
    private long ID;

    // -- constructors
    public Entity(Object groupClass, long ID){
        groupID = getGroupIDFromGroup(groupClass.getClass().getName());
        this.ID = ID;
    }
    public Entity(String groupClass, long ID) throws IllegalArgumentException {
        if(!groups.containsValue(groupClass))
            throw new IllegalArgumentException();

        groupID = groupClass.getClass().getName();
        this.ID = ID;
    }

    // -- methods
    public long getID() {
        return ID;
    }

    public String getCodeID(){
        return groupID + ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    protected boolean equalsID(String group, long ID){
        return groupID == getGroupIDFromGroup(group) && this.ID == ID;
    }


    // -- method overrides
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass() == getClass()) {
            Entity entObj = (Entity) obj;
            return entObj.groupID == groupID && entObj.ID == ID;
        }
        return false;
    }

    @Override
    protected Object clone() {
        return new Entity(getGroupFromID(groupID), ID);
    }

    @Override
    public String toString() {
        return "Entity: "+ groupID + ID;
    }

}

import java.util.HashMap;
import java.util.Map;

public class FillUsers {
    private Map<String, Boolean> authors;

    public Map<String, Boolean> UsersList(){
        authors = new HashMap<>();
        Users eavan = new Users("EavanBoland", "EavanBoland");
        authors.put(eavan.getUsername() + ":" + eavan.getPw(), true);

        return authors;
    }

    public Map<String, Boolean> getAuthors() {
        return authors;
    }

    public String returnName(String userName) {
        String getName = null;
        String[] userNameParts = userName.split("(?=\\p{Upper})");
        getName = userNameParts[0] + " " + userNameParts[1];

        return getName;
    }
}

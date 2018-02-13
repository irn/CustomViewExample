package ivakhnenko.customviewexample.model;

/**
 * Created by Ruslan Ivakhnenko on 09.02.18.
 */

public enum UserRole {

    ADMIN(1), USER(2), ANONYMOUS(3);

    int id;

    UserRole(int i) {
        id = i;
    }

    public static UserRole findById(int id){
        UserRole result = null;
        for (UserRole userRole : values()) {
            if (userRole.id == id){
                result = userRole;
            }
        }

        return result;
    }
}

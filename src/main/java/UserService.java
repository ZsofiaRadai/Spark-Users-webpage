import java.util.List;

public class UserService {
    // returns a list of all users
    public List<User> getAllUsers() {
        return User.getUsers();
    }

    // returns a single user by id
    public  User getUser(int id) {
        List<User> allUsers = getAllUsers();
        for (User u: allUsers) {
            if (u.getId() == id){
                return u;
            }
        }
        return null;
    }
    // creates a new user
    public User createUser(String name, String email) {
        User newUser = new User(name, email);
        return newUser;
    }
    // updates an existing user
    public User updateUser(int id, String name, String email) {
        User userToBeUpdated = getUser(id);
        userToBeUpdated.setName(name);
        userToBeUpdated.setEmail(email);
        return userToBeUpdated;
    }
}
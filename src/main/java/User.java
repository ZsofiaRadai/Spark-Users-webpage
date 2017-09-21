import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private int id = 0;
    private String name;
    private String email;
    private static List<User> users = new ArrayList();
    private static final AtomicInteger count = new AtomicInteger(0);

    public User(){
        User.users.add(this);
        id = count.incrementAndGet();
    }

    public static List<User> getUsers() {
        return users;
    }

    public User(String name, String email) {
        this();
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

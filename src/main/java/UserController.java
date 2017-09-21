import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.*;
import static sun.plugin2.util.PojoUtil.toJson;

public class UserController {
    public UserController(final UserService userService) {
        port(9999);
        get("/users", (req, res) -> userService.getAllUsers(), JsonUtil.json());

        after((req, res) -> {
            res.type("application/json");
        });

        get("/users/:id", (req, res) -> {
            String idString = req.params(":id");
            int id = Integer.parseInt(idString);
            User user = userService.getUser(id);
            if (user != null) {
                return user;
            }
            res.status();
            return new ResponseError("No user with id '%s' found", id);
        }, JsonUtil.json());
    }
    // more routes
}

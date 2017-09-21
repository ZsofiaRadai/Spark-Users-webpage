import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class UserController {
    public UserController(final UserService userService) {
        //staticFiles.location("/public");
        port(9999);

        get("/", (req, res) -> renderPage());

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

    private static String renderPage(){
        Map<String, Object> model = new HashMap<>();
        return renderTemplate("velocity/index.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));
    }
}

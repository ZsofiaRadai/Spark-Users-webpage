import spark.ModelAndView;
import spark.Request;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class UserController {
    public UserController() {
        staticFiles.location("/public");
        port(9999);

        get("/", (req, res) -> renderPage());

        get("/users/:id", (req, res) -> userData(req));
    }

    private static String renderPage() {
        Map<String, List<User>> model = new HashMap<>();
        model.put("allUsers", User.getUsers());
        return renderTemplate("velocity/index.vm", model);
    }

    private static String userData(Request req){
        Map<String, User> model = new HashMap<>();
        String idString = req.params(":id");
        int id = Integer.parseInt(idString);
        model.put("userData", new UserService().getUser(id));
        return renderTemplate("velocity/userpage.vm", model);
    }

    private static String renderTemplate(String template, Map model) {
        return new VelocityTemplateEngine().render(new ModelAndView(model, template));

    }
}

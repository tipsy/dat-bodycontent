import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/",           Main::exampleOne);
        get("/exampleOne", Main::exampleOne);
        get("/exampleTwo", Main::exampleTwo);
    }

    public static String exampleOne(Request request, Response response) {
        return renderWithoutModel("velocity/exampleOne.vm");
    }

    public static String exampleTwo(Request request, Response response) {
        return renderWithoutModel("velocity/exampleTwo.vm");
    }

    public static String renderWithoutModel(String templatePath) {
        return new VelocityTemplateEngine().render(new ModelAndView(new HashMap<>(), templatePath));
    }
}

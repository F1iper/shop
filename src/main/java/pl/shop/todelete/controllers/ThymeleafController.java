package pl.shop.todelete.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.shop.todelete.service.Service;

@Controller
public class ThymeleafController {

    Service service;

    public ThymeleafController(Service service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/add")
    public String addInput(@RequestParam int numberOne,
                           @RequestParam int numberTwo,
                           Model model) { // Ten obiekt posłuży do przekazania danych do HTMLa.
        int result = service.add(numberOne, numberTwo);
        String method = "add"; // Dodatkowe info dla HTMLa.
        model.addAttribute("result", result); // W ten sposób przerzucamy info do HTMLa. Po tym
        model.addAttribute("method", method); // Stringu Thymeleaf rozpozna jakie ma wziąć dane.
        return "result"; // Sprawdźcie ten HTML. On Przyjmuje wyniki.
    }

    @GetMapping("/substract")
    public String substractInput(@RequestParam int numberOne,
                                 @RequestParam int numberTwo,
                                 Model model) {
        int result = service.substract(numberOne, numberTwo);
        String method = "substract";
        model.addAttribute("result", result);
        model.addAttribute("method", method);
        return "result";
    }

    @GetMapping("/multiply")
    public String multiplyInput(@RequestParam int numberOne,
                                @RequestParam int numberTwo,
                                Model model) {
        int result = service.multiply(numberOne, numberTwo);
        String method = "multiply";
        model.addAttribute("result", result);
        model.addAttribute("method", method);
        return "result";
    }

    @GetMapping("/divide")
    public String divideInput(@RequestParam int numberOne,
                              @RequestParam int numberTwo,
                              Model model) {
        int result = service.divide(numberOne, numberTwo);
        String method = "divide";
        model.addAttribute("result", result);
        model.addAttribute("method", method);
        return "result";
    }
}

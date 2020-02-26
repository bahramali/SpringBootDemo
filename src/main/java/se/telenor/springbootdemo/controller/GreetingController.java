package se.telenor.springbootdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.telenor.springbootdemo.model.Account;
import se.telenor.springbootdemo.model.Path;
import se.telenor.springbootdemo.model.Type;
import se.telenor.springbootdemo.service.GreetingService;

@Controller
public class GreetingController {

    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "account") String account,
                                   @RequestParam(value = "id", required = false) Integer id,
                                   @RequestParam(value = "type", required = false) String type, Model model) {
        Path path = Path.builder()
                .withId(id)
                .withAccount(Account.fromExternalValue(account))
                .withType(Type.fromExternalValue(type))
                .build();

        model.addAttribute("response",greetingService.getMessage(path));

        return "answer";
        //return ResponseEntity.accepted().body(greetingService.getMessage(path));
    }
}

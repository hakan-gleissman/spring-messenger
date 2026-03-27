package se.sprinto.hakan.springmessenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.sprinto.hakan.springmessenger.model.Email;
import se.sprinto.hakan.springmessenger.service.MessageService;

@Controller
@RequestMapping("/email")
public class EmailController {
    private final MessageService messageService;

    public EmailController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        return "form";
    }

    @PostMapping
    public String mail(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        messageService.send(email);
        redirectAttributes.addFlashAttribute(
                "success", "Mail skickat");
        return "redirect:/email";
    }
}

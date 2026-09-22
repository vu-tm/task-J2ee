package com.example._9.Controller;

import com.example._9.Form.PersonForm;
import com.example._9.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    /*
    * Array person
    * static: Dùng chung cho class MainContainer
    * final: Không thể gán sang danh sách khác. Vẫn có thể thêm, sửa, xoá
    * */
    private static final List<Person> persons = new ArrayList<>();

    // Du lieu mau
    static {
        persons.add(new Person("Truong", "Vu"));
        persons.add(new Person("Sai", "Gon"));
    }

    @Value("${welcome.message}")
    private String message;
    @Value("${error.message}")
    private String errorMessage;

    /*
    * @RequestMapping ( value={"/", "/index"}, method=RequestMethod.GET )
    * */
    @GetMapping({"/", "index"})
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping("/personList")
    public String personList(Model model) {
        model.addAttribute("persons", persons);
        return "personList";
    }

    /*
    * Cần object rỗng để form nhập xong binding dữ liệu vào
    * */
    @GetMapping("/addPerson")
    public String addPerson(Model model) {
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
        return "addPerson";
    }

    @PostMapping("/addPerson")
    public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm) {
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();

        if (firstName != null && !firstName.isBlank()
                && lastName != null && !lastName.isBlank()) {
            // Adding to List
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);

            // chuyen huong toi url personList
            return "redirect:/personList";
        } else {
            model.addAttribute("message", errorMessage);
            return "addPerson";
        }
    }
}

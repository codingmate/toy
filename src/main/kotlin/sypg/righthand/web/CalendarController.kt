package sypg.righthand.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/calendar")
class CalendarController {
    @RequestMapping("")
    fun index(model: Model): String {
        println("calendar/index")
        model.addAttribute("title", "Calendar")
        return "/index"
    }

}
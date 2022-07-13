package com.example.easySchool.controller;

import com.example.easySchool.models.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display ,Model model){
        if(display != null && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        }
        else if(display != null && display.equals("festival")) {
            model.addAttribute("festival", true);

        }
        else if(display != null && display.equals("federal")) {
            model.addAttribute("federal", true);
        }
        List<Holiday> holidays = Arrays.asList(
                new Holiday("jan 1", "New Year's Day",Holiday.Type.FESTIVAL),
                new Holiday("jan 3", "Day",Holiday.Type.FESTIVAL),
                new Holiday("jan 28", "PK's Birthday",Holiday.Type.FEDERAL),
                new Holiday("july 4", "My Birthday",Holiday.Type.FEDERAL),
                new Holiday("dec 25", "Christmas",Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type:types){
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }

        return "holidays.html";
    }
}

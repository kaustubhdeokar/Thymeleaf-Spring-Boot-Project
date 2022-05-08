package com.example.tamingthymeleaf3.web;

import com.example.tamingthymeleaf3.team.Team;
import com.example.tamingthymeleaf3.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeamController {

    private TeamService service;

    public TeamController(@Autowired TeamService service) {
        this.service = service;
    }

    @RequestMapping("/teams")
    @GetMapping()
    public String index(Model model) {
        List<Team> teams = service.getTeams();
        model.addAttribute("teams", teams);
        return "teams/list";
    }


    @RequestMapping("/teams/{id}")
    @GetMapping
    public String teamInfo(@PathVariable("id") String teamId, Model model) {
        model.addAttribute("teamInfo", service.getTeamInfo(teamId));
        return "teams/info";
    }

    @PostMapping("/teams/{id}")
    public String editTeamName(@PathVariable("id") String teamId) {
        service.changeTeamName(teamId, "newTeamName");
        return "redirect:/teams/all";
    }


}

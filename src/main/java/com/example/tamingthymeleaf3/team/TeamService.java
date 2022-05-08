package com.example.tamingthymeleaf3.team;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamService {


    public List<Team> getTeams();

    public Object getTeamInfo(String teamId);

    public void changeTeamName(String teamId, String newTeamName);
}

package com.example.tamingthymeleaf3.team;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    public TeamServiceImpl() {

    }

    public List<Team> getTeams() {
        List<Team> teams = new ArrayList<Team>();
        teams.add(new Team(1, "Initiates"));
        teams.add(new Team(2, "Knights"));
        teams.add(new Team(3, "Padawans"));
        teams.add(new Team(4, "Rookies"));
        teams.add(new Team(5, "Wizards"));
        return teams;
    }

    @Override
    public Team getTeamInfo(String teamId) {
        return getTeams().stream().filter(team->String.valueOf(team.getId()).equals(teamId)).findFirst().orElse(null);
    }

    @Override
    public void changeTeamName(String teamId, String newTeamName) {
        Team teamInfo = getTeamInfo(teamId);
        teamInfo.setName(newTeamName);
    }
}

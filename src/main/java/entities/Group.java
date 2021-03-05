package entities;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<Project> projects;

    public Group(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    public boolean isActive(){
        for (Project p : projects);
        return true;

    }

    public void addProject(Project plan) {
        this.projects.add(plan);
    }

}

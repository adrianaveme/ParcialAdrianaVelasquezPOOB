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


    public void addProject(Project plan) {
        this.projects.add(plan);
    }

//Si estan activos se filtran y despues se cuentan

    public int countActiveProjects() {
        return(int) this.projects.stream().map(p -> p.isActive()).filter(b -> b).count();
    }


}

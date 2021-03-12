package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations;

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();

        group.addProject(this);
    }

    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }

    public void setDateInit(LocalDate dateInit) {
        this.dateInit = dateInit;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }


    /**
     * Evaluate if a project is active.
     *
     * @return false if the project has open activities or the dateEnd is before than the system date.
     */

    //la fecha de cierre del proyecto debe ser posterior a la fecha en la cual estoy consultando
    //si eso no pasa proyecto cerrado isActive = false
    //entonces toca contar el numero de actividades pendientes, despues se retorna


    public boolean isActive() {
            boolean isActive = true;

            if(LocalDate.now().isAfter(this.dateEnd)){
                isActive = false;
            }
            else{
                int openActivities = this.countOpenActivities();
                isActive = openActivities > 0;
            }

            return isActive;
    }

    //pro

    public int countOpenActivities(){
        /*int count =0;
        for (Iteration i : this.iterations ){
            count += i.countOpenActivities();
        }
        return count;*/

        //Declara variable inicial cero y a y b
        //se  aplica a + b, se va reduciendo ese resultado en variable inicial 0

        return this.iterations
                .stream()
                .map(i -> i.countOpenActivities())
                .reduce(0, (a, b) -> a+b);
    }



}

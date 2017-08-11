import java.lang.*;
import java.util.*;
public class Portfolio{
    ArrayList<Project> projects = new ArrayList<Project>();

    //get Project
    public ArrayList<Project> getPortfolios(){
        return projects;
    }

    public void addToPortfolio(Project obj) {
        projects.add(obj);
    }


    // //set Project
    // public ArrayList<Project> getPortfolios(){
    //     this.projects = projects;
    // }

    public Double getPortfolioCost(){
        double totalCost = 0;
        for(Project project : projects){
            totalCost += project.getInitialCost();
        }
        return totalCost;

    }

    public Void showPortfolio(){

        for(Project project : projects){
            System.out.println(project.elevatorPitch());
        }
        System.out.println(getPortfolioCost()); 
    }


}


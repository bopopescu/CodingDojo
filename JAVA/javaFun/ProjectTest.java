import java.lang.*;
import java.util.*;

public class ProjectTest {
    public static void main(String[] args) {
        Portfolio get = new Portfolio();
        Project projectnumerouno = new Project("Project #1", "Description 1");
        Project projectnumerodos = new Project("Project #2", "Description 2");
        Project projectnumerotres = new Project("Project #3", "Description 3");
        projectnumerouno.setinitialCost(10.0);
        projectnumerodos.setinitialCost(12.0);
        projectnumerotres.setinitialCost(14.0);

        projectnumerouno.elevatorPitch();
        projectnumerodos.elevatorPitch();
        projectnumerotres.elevatorPitch();

        get.addToPortfolio(projectnumerodos);
        get.addToPortfolio(projectnumerouno);
        get.addToPortfolio(projectnumerotres);
        System.out.println(get.getPortfolioCost());
		get.showPortfolio();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;

/**
 *
 * @author Abel
 */
public class CompositePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee ceo = new Employee("DAVE" ,"CEO" , 40000 );
        Employee projectManager = new Employee("ABEL" ,"ProjectManager" , 20000);
        Employee headOfFinance = new Employee("abebe" ,"HeadFinance" , 10000);
        Employee developer1 = new Employee("kebede" , "IT" , 6000);
        Employee developer2 = new Employee("mike" ,"IT" , 6000);
        Employee accountant1 = new Employee("haile" , "finance" , 5000);
        Employee accountant2 = new Employee("fish" , "finance" , 5000);
        
        Employee dev1 = new Employee("aa" , "IT2", 4000);
        Employee dev2 = new Employee ("bb" , "IT2" , 4000);
        ceo.add(projectManager);
        ceo.add(headOfFinance);
        
        projectManager.add(developer1);
        projectManager.add(developer2);
        
        developer1.add(dev2);
        developer1.add(dev1);
        
        headOfFinance.add(accountant1);
        headOfFinance.add(accountant2);
        
        //ceo subordinates
        System.out.println("Subordinates of ceo");
        for (Employee emp : ceo.getSubordinates()) {
            System.out.println(emp);

            for (Employee emp2 : emp.getSubordinates()) {
                System.out.println(emp2);
                
                for(Employee emp3 : emp2.getSubordinates()){
                    System.out.println(emp3);
                }
            }
                
        }
        System.out.println("Total salary of ceo subordinates: " + ceo.getSubordinatesTotalSalary());
        
        System.out.println("dev1 Bosses");
        for (Employee emp : dev1.getBosses()){
            System.out.println(emp);

            for (Employee emp2 : emp.getBosses()){
                System.out.println(emp2);
                for(Employee emp3 : emp2.getBosses()){
                    System.out.println(emp3);
                }
            }
        }

        //
        
    }
    
}

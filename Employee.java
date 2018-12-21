/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepattern;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Abel
 */
public class Employee {
    private String name;
    private double salary;
    private String department;
    private List<Employee> subordinates;
    private List<Employee> bosses;
    public Employee(String name , String department , double salary){
        this.name = name;
        this.salary = salary;
        this.department = department;
        subordinates = new ArrayList<Employee>();
        bosses = new ArrayList<Employee>();
    }
    
    public void add(Employee emp){
        subordinates.add(emp);
        if (!(emp.bosses.contains(this)) && this.subordinates.contains(emp)){
            emp.bosses.add(this);
        }
    }
    public void remove(Employee emp){
        subordinates.remove(emp);
    }
    public List<Employee> getSubordinates(){
        return subordinates;
    }
    public List<Employee> getBosses(){
        return bosses;
    }
    
    
     public double getSubordinatesTotalSalary(){
         double totalAmount =0;
         List<Employee> curentSubordinate = subordinates;
         List<Employee> c= subordinates;
       /*  for (int i=0 ; i<subordinates.size();i++){
             for(int j=0 ; j<subordinates.get(i).getSubordinates().size();j++){
               totalAmount +=subordinates.get(i).getSubordinates().get(j).salary;
                }
             
         }
*/
         for(int counter =0 ; counter < curentSubordinate.size() ; counter ++){
             totalAmount += curentSubordinate.get(counter).salary; 
             while(! curentSubordinate.get(counter).getSubordinates().isEmpty()){
                 curentSubordinate = curentSubordinate.get(counter).getSubordinates();
                 for(int j=0 ; j< curentSubordinate.size();j++){
                     totalAmount+= curentSubordinate.get(j).salary;
                 }
             }
             curentSubordinate = c;
         }
         return totalAmount;
         
     }
     
     public String toString(){
        return ("Employee>>> Name : " + name + ", department : " + department + ", salary : " + salary + " ]");
    }
    
 
    
}

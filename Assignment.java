package Techolution;

import java.util.*;

class Person{
    String name;
    int age;
    String role;
    public Person(String name,int age,String role){
        this.name = name;
        this.age = age;
        this.role = role;
    }
}
class Role{
    String role;
    String designation;
    public Role(String role,String designation){
        this.role = role;
        this.designation = designation;
    }
}
class Employee{
    private String name;
    private int age;
    LinkedList<String> Role;
    public Employee(String name,int age){
        Role = new LinkedList<>();
        this.name = name;
        this.age = age;
    }
    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    }
    public void setdesignation(String designation){
        Role.add(designation);
    }
    public void setrole(String role){
        Role.add(role);
    }
}
public class Assignment {
    Employee[] E;
    public void merge(Person[] p,Role[] r){
        Map<String,String> hm = new HashMap<>();
        for(Role i:r){
            hm.put(i.role,i.designation);
        }
        int k = 0;
        E = new Employee[p.length];
        for(int i=0;i<p.length;i++){
            if(p[i]!=null){
                Person t = p[i];
                Employee tmp = new Employee(t.name,t.age);
                tmp.setrole(t.role);
                tmp.setdesignation(hm.get(t.role));
                E[k++] = tmp;
            }
        }
        for(int i=0;i<E.length;i++){
            if(E[i]!=null){
                Employee e = E[i];
                System.out.println("My name is:"+e.getname()+" My age is "+e.getage()
            +" I work on role addressed as "+e.Role.get(0)+" and my designation is "+e.Role.get(1));
            }
        }
    }
    public static void main(String[] args) {
        Person[] p = new Person[3];
        Role[] r = new Role[2];
        p[0] = new Person("ajay",23,"developer");
        p[1] = new Person("anil",26,"manager");
        p[2] = new Person("aditya",24,"developer");
        r[0] = new Role("developer","L3");
        r[1] = new Role("manager","P1");
        Assignment A = new Assignment();
        A.merge(p,r);
    }
}

public class Employee extends User{
    public Double salary;
    public Employee(String CPF, String phone, String name, Double salary){
        super(CPF, phone, name);
        this.salary = salary;
    }
    @Override
    public String toString(){
        return getCPF()+" "+getName()+" "+getPhone()+" "+salary;
    }
}

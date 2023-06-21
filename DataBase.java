import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    public Double totalSalary = 0.0;
    public Double totalSales = 0.0;
    HashMap <String, Client> tableClient = new HashMap <String, Client> ();
    HashMap <String, Employee> tableEmployee = new HashMap <String, Employee> ();
    HashMap <String, Service> tableService = new HashMap <String, Service> (); 
    HashMap <String, List <Service>> tableClientService = new HashMap<String, List<Service>>();


    public void registerClient(String CPF, String name, String phone) {
        Client client = new Client(CPF, name, phone);
        this.tableClient.put(CPF, client);
    }
    public void updateClient(String CPF, Client client) {
        tableClient.put(CPF, client);
    }


    public void registerEmployee(String CPF, String name, String phone, Double salary) {
        Employee employee = new Employee(CPF, name, phone, salary);
        this.tableEmployee.put(CPF, employee);
    }
    public void updateEmployee(String CPF, Employee employee) {
        tableEmployee.put(CPF, employee);
    }


    public void registerService(String IDService, String name, Double price){
        Service service = new Service(IDService, name, price);
        this.tableService.put(IDService, service);
    }

    public void registerClientService(String key, Service service){
        List<Service> services;
        if(this.tableClientService.containsKey(key)){
            services = this.tableClientService.get(key);
        }else{
            services = new ArrayList<Service>();
        }
        totalSales += service.price;
        services.add(service);
        this.tableClientService.put(key, services);
    }

    public void showAllClients(){
        for (String key : this.tableClient.keySet()) {
            System.out.println(this.tableClient.get(key).toString());
        }
    }
    public void showAllEmployeers(){
        for (String key : this.tableEmployee.keySet()) {
            System.out.println(this.tableEmployee.get(key).toString());
        }
    }
    public void showAllServices(){
        for (String key : this.tableService.keySet()) {
            System.out.println(this.tableService.get(key).toString());
        }
    }
    public void showIncome(){
        
        Double result = totalSales - totalSalary;

        System.out.println("O subtração entre o salario total dos funcionários e o total de serviços prestado é: "+ result); 
        
        if(result > 0){
            System.out.printf("Você pagou todos os funcionarios e ainda possui %.0f, está lucrando.", result);
        }
        else if(result < 0){
            System.out.printf("Você ainda deve %.0f, está tomando prejuizo.", result);
        }
        else{
            System.out.printf("Você possui %.0f, pagou seus funcionarios mas não restou nada.", result);
        }


    }
}

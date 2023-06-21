import java.util.Scanner;

class Menu {
    public DataBase database = new DataBase();
    public Scanner input = new Scanner(System.in); 

    public void run(){
        int condition = 0;
        do{
            mainMenu();

            int option = input.nextInt();

            switch(option){
                case 1:
                    clientsMenu();
                    
                    int clientoption = input.nextInt(); 

                    if(clientoption == 1){
                        registerClient();
                    }
                    else if(clientoption == 2){
                        ediClient();
                    }
                    else if(clientoption == 3){
                        deleteClient();

                    }
                    else if(clientoption == 4 ){
                        System.out.println("\n--- VER TODOS OS CLIENTES SELECIONADO---");
                        database.showAllClients();
                    }
                    break;

                case 2:
                    employeeMenu();
                    
                    int employeeoption = input.nextInt();

                    if(employeeoption == 1){
                        registerEmployee();
                        
                    }
                    else if(employeeoption == 2){
                        editEmployee();
                    }   
                    else if(employeeoption == 3){
                        deleteEmployee();

                    }
                    else if(employeeoption == 4){
                        System.out.println("\n---VER TODOS OS FUNCIONARIOS SELECIONADO---");
                        database.showAllEmployeers();
                    }
                    break;
                case 3:
                    serviceMenu();    

                    int serviceoption = input.nextInt();

                    if(serviceoption == 1){
                        registerService();
                    }
                    else if(serviceoption == 2){
                        deleteService();
                    }
                    else if(serviceoption == 3){
                        System.out.println("\n---VER TODOS OS SERVIÇOS SELECIONADO");
                        database.showAllServices();
                    }
                    break;
                case 4:
                    linkClientServiceMenu();

                    int linkclientserviceoption = input.nextInt();

                    if(linkclientserviceoption == 1){
                        linkService();
                    }
                    else if(linkclientserviceoption == 2){
                        deleteLinkService();
                    }
                    else if(linkclientserviceoption == 3){
                        System.out.println("\n---VER RENDA SELECIONADO---");
                        database.showIncome();
                    }
                    break;
                case 5:
                    condition = 1;
                    break;
                    
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }while(condition != 1);

    }

    private void deleteLinkService() {
        System.out.print("\n---DELETAR SERVIÇO VINCULADO SELECIONADO---");
        System.out.print("Digite o CPF para o cliente que o serviço foi vinculado: ");
        input.nextLine();
        String remove = input.nextLine();
        
        if(database.tableClientService.containsKey(remove)){
            database.tableClientService.remove(remove);
            System.out.println("Serviço vinculado removido com sucesso");
        }
        else if(database.tableService.get(remove) == null){
            System.out.println("Serviço vinculado não encontrado.");
        }
    }

    private void linkService() {
        System.out.println("\n---VINCULAR SERVIÇO SELECIONADO---");
        System.out.print("Digite o CPF do cliente para quem o serviço será registrado: ");
        input.nextLine();
        String key = input.nextLine();
        if(database.tableClient.containsKey(key)){
            System.out.print("Digite o ID do serviço: ");
            String serviceId = input.nextLine();
            if(database.tableService.containsKey(serviceId)){
                database.registerClientService(key, database.tableService.get(serviceId));
            }else{
                System.out.println("Serviço não encontrado");
            }

        }else{
            System.out.println("Usuario não encontrado");
        }
    }

    private void deleteService() {
        System.out.println("\n---DELETAR SERVIÇO SELECIONADO---");
        System.out.print("Informe o ID do serviço a ser removido: ");
        input.nextLine();
        String remove = input.nextLine();
        
        if(database.tableService.containsKey(remove)){
            database.tableService.remove(remove);
            System.out.println("Serviço removido com sucesso.");
        }
        else if(database.tableService.get(remove) == null){
            System.out.println("Serviço não encontrado.");
        }
    }

    private void registerService() {
        System.out.println("\n---CADASTRO DE SERVIÇOS SELECIONADO---");
        System.out.print("Digite o ID do serviço: ");
        input.nextLine();
        String IDService = input.nextLine();

        System.out.print("Digite o nome do serviço: ");
        String name = input.nextLine();

        System.out.print("Digite o valor do serviço: ");
        Double price = input.nextDouble();

        database.registerService(IDService, name, price);
        System.out.println("Serviço Cadastrado com Sucesso.");
    }

    private void deleteEmployee() {
        System.out.println("\n---DELETAR FUNCIONÁRIO SELECIONADO---");
        System.out.print("Informe o CPF do funcionário a ser removido: ");
        input.nextLine();
        String remove = input.nextLine();
        
        if(database.tableEmployee.containsKey(remove)){
            database.tableEmployee.remove(remove);
            System.out.println("Funcionário removido com sucesso.");
        }
        else if(database.tableClient.get(remove) == null){
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void editEmployee() {
        System.out.println("\n---EDITAR FUNCIONÁRIO SELECIONADO---");
        System.out.print("Informe o CPF do funcionario: ");
        input.nextLine();
        String key = input.nextLine();

        if(database.tableEmployee.containsKey(key)){
        
            Employee employee = database.tableEmployee.get(key);

            System.out.print("Reescreva o nome do funcionário: ");
            employee.name = input.nextLine();

            System.out.print("Reescreva o numero do funcionário: ");
            employee.phone = input.nextLine();

            database.updateEmployee(key, employee);
                            
            System.out.print("ALTERAÇÃO CONCLUIDA.");
            
            System.out.println(database.tableClient);

        }
        else if(database.tableClient.get(key) == null){
            System.out.println("Cliente não encontrado.");                    
        }
    }

    private void registerEmployee() {
        System.out.println("\n---CADASTRO DE FUNCIONÁRIO SELECIONADO---");
        System.out.print("Digite o CPF do funcionário: ");
        input.nextLine();
        String CPF = input.nextLine();

        System.out.print("Digite o nome do funcinário: ");
        String name = input.nextLine();

        System.out.print("Digite o numero do funcionário: ");
        String phone = input.nextLine();

        System.out.print("Digite o salario do cliente: ");
        Double salary = input.nextDouble();
        database.totalSalary += salary;  
        database.registerEmployee(CPF, name, phone, salary);
        System.out.println("Funcionário Cadastrado com Sucesso.");
    }

    private void deleteClient() {
        System.out.println("\n---DELETAR CLIENTE SELECIONADO---");
        System.out.print("Informe o CPF do cliente a ser removido: ");
        input.nextLine();
        String remove = input.nextLine();
        
        if(database.tableClient.containsKey(remove)){
            database.tableClient.remove(remove);
            System.out.println("Cliente removido com sucesso.");
        }
        else if(database.tableClient.get(remove) == null){
            System.out.println("Cliente não encontrado.");
        }
    }

    private void ediClient() {
        System.out.println("\n---EDITAR CLIENTE SELECIONADO---");
        System.out.print("Informe o CPF do cliente: ");
        input.nextLine();
        String key = input.nextLine();

        if(database.tableClient.containsKey(key)){
        
            Client client = database.tableClient.get(key);

            System.out.print("Reescreva o nome do cliente: ");
            client.name = input.nextLine();

            System.out.print("Reescreva o numero do cliente: ");
            client.phone = input.nextLine();

            database.updateClient(key, client);
                            
            System.out.print("ALTERAÇÃO CONCLUIDA.");
            
            System.out.println(database.tableClient);

        }
        else if(database.tableClient.get(key) == null){
            System.out.println("Cliente não encontrado.");
        }
    }

    private void registerClient() {
        System.out.println("\n---CADASTRO DE CLIENTE SELECIONADO---");
        System.out.print("Digite o CPF do cliente: ");
        input.nextLine();
        String CPF = input.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String name = input.nextLine();

        System.out.print("Digite o numero do cliente: ");
        String phone = input.nextLine();

        database.registerClient(CPF, name, phone);
        System.out.println("Cliente Cadastrado com Sucesso.");
    }
        
    public static void mainMenu(){
        System.out.println("\n#-----------------#");
        System.out.println("|Sistema Barbearia|");
        System.out.println("#-----------------#");
        System.out.println("\nSelecione abaixo o que deseja fazer.");
        System.out.println("1 - Gerir Clientes(Cadastrar, Editar, Deletar)");
        System.out.println("2 - Gerir Funcionarios(Cadastrar, Editar, Deletar)");
        System.out.println("3 - Gerir Serviços");
        System.out.println("4 - Gestão Financeira");
        System.out.println("5 - Sair do sistema.");
    }

    public static void clientsMenu(){
        System.out.println("\n---GERIR CLIENTES SELECIONADO---");
        System.out.println("O que deseja fazer ?\n");

        System.out.println("1 - Cadastrar novos clientes");
        System.out.println("2 - Editar clientes");
        System.out.println("3 - Deletar cliente");
        System.out.println("4 - Ver todos os clientes cadastrados");
        System.out.println("Outro Número - Menu principal");
    }

     public static void employeeMenu(){
        System.out.println("\n---GERIR FUNCIONÁRIOS SELECIONADO---");
        System.out.println("O que deseja fazer ?\n");

        System.out.println("1 - Cadastrar novos funcionários.");
        System.out.println("2 - Editar funcionários.");
        System.out.println("3 - Deletar funcionários.");
        System.out.println("4 - Ver todos os funcionarios cadastrados.");
        System.out.println("Outro Número - Menu principal");
    }
    public static void serviceMenu(){
        System.out.println("\n---GESTÃO DE SERVIÇO SELECIONADO---");
        System.out.println("1 - Cadastrar serviços.");
        System.out.println("2 - Deletar serviços.");
        System.out.println("3 - Ver todos os serviços cadastrados.");
        System.out.println("Outro Número - Menu principal");
    }
    public static void linkClientServiceMenu(){
        System.out.println("\n---GESTÃO DE FINANCEIRA SELECIONADO---");
        System.out.println("1 - Vincular Serviço ao Cliente.");
        System.out.println("2 - Deletar Serviço Vinculado.");
        System.out.println("3 - Ver renda/prejuizo gerado. ");
        System.out.println("Outro Número - Menu principal");
    }

}

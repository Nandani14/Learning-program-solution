// Dependency Injection Example - Managing customers

//Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Concrete Repository Implementation 
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        // For simplicity, return a dummy customer
        return "Customer#" + id + " - Nandani";
    }
}

// Service Class depending on the repository 
class CustomerService {
    private CustomerRepository repository;

    // Constructor-based dependency injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void showCustomer(int id) {
        String customer = repository.findCustomerById(id);
        System.out.println("Fetched from DB: " + customer);
    }
}

// Main Class
public class DependencyInjection {
    public static void main(String[] args) {
        // Injecting the dependency
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.showCustomer(101);  // Output: Fetched from DB: Customer#101 - Nandani
    }
}


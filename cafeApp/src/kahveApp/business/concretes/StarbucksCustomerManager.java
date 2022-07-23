package kahveApp.business.concretes;

import kahveApp.business.abstracts.BaseCustomerManager;
import kahveApp.business.abstracts.CustomerCheckService;
import kahveApp.entities.concretes.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

	private CustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		
		this.customerCheckService = customerCheckService;
	}
	
	@Override
	public void Save(Customer customer) throws Exception {
		if(customerCheckService.checkIfRealPerson(customer)) {
			super.Save(customer);
		}else {
			throw new Exception("Not a valid person");
		}	
	}

}

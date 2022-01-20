package com.filwsx.basic.project2;

public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    //判断数组索引是否正确
    public boolean indexIsRight(int index) {
    	if(index>=0 && index<total) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public CustomerList(int totalCustomer) {
    	customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
    	if(total+1 <= customers.length) {
    		customers[total] = customer;
    		total++;
    		return true;
    	}else {
    		return false;
    	}
    }
     
    public boolean replaceCustomer(int index, Customer cust) {
    	if(indexIsRight(index)) {
    		customers[index] = cust;
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean deleteCustomer(int index) {
    	if(indexIsRight(index)) {
			for(int i = index; i < total-1; i++) {
				customers[i] = customers[i+1];
			}
    		total--;
    		return true;
    	}else {
    		return false;
    	}
    	
    }

    public Customer[] getAllCustomers() {
    	Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    public int getTotal() {
    	return total;
    }

    public Customer getCustomer(int index) {
    	if(indexIsRight(index)) {
    		return customers[index];
    	}else{
    		return null;
    	}
    }
    
    
}

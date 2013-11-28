package models;

import java.util.*;

import javax.validation.*;

import play.data.validation.Constraints.*;

public class Contact {
    // name telepon email 
    @Required
    public String name;
    
    @Required
    public String telepon;
    
    public String email;
	
	public String address;
    
    
}
package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.phonebook.*;

import models.*;

public class Phonebooks extends Controller {
    
    /**
     * Defines a form wrapping the Contact class.
     */ 
    final static Form<Contact> phonebookForm = form(Contact.class);
  
    /**
     * Display a blank form.
     */ 
    public static Result blank() {
        return ok(form.render(phonebookForm));
    }
  
    /**
     * Handle the form submission.
     */
    public static Result submit() {
        Form<Contact> filledForm = phonebookForm.bindFromRequest();
        
        if(filledForm.hasErrors()) {
            return badRequest(form.render(filledForm));
        } else {
            Contact isidata = filledForm.get();
            return ok(summary.render(isidata));
        }
    }
  
}
package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.triangle.*;

import models.*;

public class Triangles extends Controller {
    
    /**
     * Defines a form wrapping the Segitiga class.
     */ 
    final static Form<Segitiga> segitigaForm = form(Segitiga.class);
  
    /**
     * Display a home form.
     */ 
    public static Result home() {
        return ok(home.render());
    }
	
	/**
     * Display a blank form.
     */ 
    public static Result blank() {
        return ok(form.render(segitigaForm));
    }
	 
    public static Result blank2() {
        return ok(form2.render(segitigaForm));
    }
  
    /**
     * Handle the form submission.
     */
    public static Result submit() {
        Form<Segitiga> filledForm = segitigaForm.bindFromRequest();
        
        if(filledForm.hasErrors()) {
            return badRequest(form.render(filledForm));
        } else {
            Segitiga isidata = filledForm.get();
			Double luas=0.5*isidata.height*isidata.width;
            return ok(summary.render(isidata,luas));
        }
    }
	
	public static Result hitungKeliling() {
        Form<Segitiga> filledForm = segitigaForm.bindFromRequest();
        
        if(filledForm.hasErrors()) {
            return badRequest(form.render(filledForm));
        } else {
            Segitiga isidata = filledForm.get();
			Integer keliling=isidata.height+isidata.width+isidata.sisi3;
            return ok(summary2.render(isidata,keliling));
        }
    }
  
}
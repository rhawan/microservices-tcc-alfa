package br.alfa.sales.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getCliente(@PathVariable("id") long id) {
		System.out.println("Consultando cliente com id " + id);
		return new ResponseEntity<String>("/cliente GET id = " + id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public ResponseEntity<String> listarClientes() {
		System.out.println("Listando clientes ");
		return new ResponseEntity<String>("/cliente POST", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.PUT)
	public ResponseEntity<String> salvarCliente() {
		System.out.println("Inserindo cliente ");
		return new ResponseEntity<String>("/cliente PUT", HttpStatus.OK);
	}
	
	
	
	
	
	//-------------------Retrieve Single User--------------------------------------------------------
    
    /*@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getName());
 
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }*/

}

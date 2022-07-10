
package com.pil.grim.logincontroller;

import com.pil.grim.logindao.logindao;
import com.pil.grim.loginentity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins={"*"})

public class logincontroller {
    @Autowired
    private logindao UserDao;
    
    
    @GetMapping("/api/user/perfil")
    @ResponseBody
    public user usuario(){
        return(UserDao.findById(1).get());
    }
                 
   
    
    @PostMapping("/api/user/login")
    @ResponseBody
    public user login(@RequestBody user u){
        return(UserDao.findByUsernameAndPassword(u.getUsername(),u.getPassword()));
    }
    
    @PostMapping("/api/user/add")
    public void newUser(@RequestBody user u){
        UserDao.save(u);
    }
    
    @PutMapping("/api/user/edit")
    public void editUser(@RequestBody user u){
        UserDao.save(u);
    }
    
    @DeleteMapping("/api/user/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        UserDao.deleteById(id);
    }
    
   
}

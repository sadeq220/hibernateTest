package com.sadeqtest.demo.controller;

import com.sadeqtest.demo.controller.dto.ReqParamTest;
import com.sadeqtest.demo.model.Address;
import com.sadeqtest.demo.model.City;
import com.sadeqtest.demo.model.Lname;
import com.sadeqtest.demo.controller.dto.LnameDto;
import com.sadeqtest.demo.repository.AddressRepo;
import com.sadeqtest.demo.repository.MyRepository;
import com.sadeqtest.demo.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class MyController {

    private MyRepository repository;
    private ServiceLayer serviceLayer;
    private AddressRepo addressRepo;
    @Autowired
    public MyController(MyRepository repository, ServiceLayer serviceLayer,AddressRepo addressRepo){
        this.repository=repository;
        this.serviceLayer=serviceLayer;
        this.addressRepo=addressRepo;

    }
    @GetMapping("/")
    public Map getHome(@RequestParam(defaultValue = "toraj") String name,HttpServletRequest request) throws InterruptedException {
        System.out.println(request.getRemotePort());
	HashMap<String,Object> map=new HashMap<>();
	map.put("long",1L);
	map.put("bool",true);
	map.put("string",name);
        //Thread.sleep(60*1000);
        return map;
    }
    @PostMapping("/useDto")
    public ResponseEntity<Address> useDto(@Valid @RequestBody LnameDto dto){
        Address address = new Address(dto.getCity(), dto.getLocation());
        Lname user = new Lname(dto.getUserID(), dto.getLastName(), dto.getGroupID());
        address.setLname(user);
        Address save = addressRepo.save(address);
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .contentType(MediaType.APPLICATION_JSON)
                .body(save);
    }
    @GetMapping("/exception")
    public void getException(@ModelAttribute ReqParamTest pedestrian){
        System.out.println(pedestrian);
       // throw new ConstraintViolationException("sadeq launched this");
    }
    @GetMapping("/filter")
        public Page<Lname> filterEntity(@RequestBody LnameDto lnameDto,
                                        @RequestParam(defaultValue = "0")Integer pageNo,
                                        @RequestParam(defaultValue = "10")Integer pageSize,
                                        @RequestParam(defaultValue = "id")String sortBy){
        return serviceLayer.filterSearch(lnameDto,pageNo,pageSize,sortBy);
        }
    @GetMapping(value = "/download")
    public ResponseEntity<Object> download() throws IOException {
        ClassPathResource resource=new ClassPathResource("/static/image.jpg");
        InputStreamResource streamResource=new InputStreamResource(resource.getInputStream());
        HttpHeaders headers=new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.attachment().filename(resource.getFilename()).build());
        headers.add("Cache-Control","no-cache, no-store, must-revalidate");
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");
        return ResponseEntity.ok().headers(headers).contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(streamResource);
    }

}

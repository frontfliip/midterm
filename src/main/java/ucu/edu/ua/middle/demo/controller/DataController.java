package ucu.edu.ua.middle.demo.controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.service.DataService;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping (path = "/search")
    public AllData getInfo(@RequestBody InfoRequest infoRequest){
        return dataService.getInfo(infoRequest.getName());
    }

    @GetMapping(path = "/getAll")
    public List<AllData> getAll(){
        return dataService.getAll();
    }
}

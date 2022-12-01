package ucu.edu.ua.middle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucu.edu.ua.middle.demo.allData.AllData;
import ucu.edu.ua.middle.demo.service.DataService;

@RestController
@RequestMapping(path = "/company")
public class DataController {

    @Autowired
    private DataService demoService;

    @PostMapping (path = "/search")
    public AllData getInfo(@RequestBody InfoRequest infoRequest){
        return demoService.getInfo(infoRequest.getName());
    }
}

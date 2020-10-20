package falah.falah_api.controller;

import falah.falah_api.model.BlogCategory;
import falah.falah_api.model.FridayReg;
import falah.falah_api.repository.FridayRegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class FridayRegController {
    @Autowired
    FridayRegRepository fridayRegRepository;

    @CrossOrigin
    @PostMapping("/api/prayer/isRegistered")
    @ResponseBody
    public List<FridayReg> fridayRegList(@RequestBody FridayReg body) throws ParseException {
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        // you can change format of date
//        Date date = formatter.parse(registeredOn);
//        Timestamp timeStampDate = new Timestamp(date.getTime());


        System.out.println(body.getRegisteredOn());
        return fridayRegRepository.findByMobileNum(body.getPhoneNum(),body.getRegisteredOn());
    }

    @CrossOrigin
    @PostMapping("/api/prayer/registered")
    public String create(@RequestBody FridayReg body){
        try {
            fridayRegRepository.save(body);
            return "You are successfully registered";
        }
        catch (Exception e){
            return "Something is wrong! please contact with us";
        }
    }

    @CrossOrigin
    @PostMapping("/api/prayer/deregister")
    public String delete(@RequestBody FridayReg body){
        try {
            long commentId =body.getRegId();
            fridayRegRepository.deleteById(commentId);
            return  "You are successfully unregistered";
        }
        catch (Exception e){
            return "Something is wrong! please contact with us";
        }
    }

    @CrossOrigin
    @PostMapping("/api/prayer/seatCapacity")
    public Integer[] seatCap(@RequestBody FridayReg body){
        Integer[] slotCapCount= {0,0,0,0,0};
        try {
            System.out.println(body.getRegisteredOn());
            List<FridayReg> allReg= fridayRegRepository.getAllByDate(body.getRegisteredOn());
            for(FridayReg fridayReg: allReg){
                int idx=fridayReg.getPrayTime();
                slotCapCount[idx]+= 1;
            }
            return slotCapCount;
        }
        catch (Exception e){
            return null;
        }
    }
    @CrossOrigin
    @PostMapping("/api/prayer/showAll")
    public List<FridayReg> showAll(@RequestBody FridayReg body){
        if(body.getName().equals("2020Milud")){
        try {
            return fridayRegRepository.getAllByDate(body.getRegisteredOn());
        }
        catch (Exception e){
            return null;
        }
        }
        else
            return null;
    }

}

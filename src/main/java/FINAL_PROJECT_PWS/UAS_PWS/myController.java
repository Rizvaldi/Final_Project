/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FINAL_PROJECT_PWS.UAS_PWS;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MSI 65 SERIES
 */
@RestController
@CrossOrigin
public class myController {
    Uas data = new Uas();
    UasJpaController dctrl = new UasJpaController();
    
    
    @RequestMapping("/GET")
    @ResponseBody
    public List<Uas> getDatabyID(){
        List<Uas> datas = new ArrayList<>();
        try {datas = dctrl.findUasEntities();}
        catch(Exception error) {}        
        return datas;
    }
    
    @RequestMapping(value ="/POST", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public String sendData(HttpEntity<String> kiriman) throws Exception{
        String message="no action";
        String json_receive = kiriman.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Uas data = new Uas(); 
        data = mapper.readValue(json_receive, Uas.class);
        dctrl.create(data);
        message ="Data " + data.getNama()+" telah diSimpan";
        return message;
    }
    

    @RequestMapping(value ="/PUT", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public String editData(HttpEntity<String> kiriman) throws Exception{
        String message="no action";
        String json_receive = kiriman.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Uas newdatas = new Uas(); 
        
        newdatas = mapper.readValue(json_receive, Uas.class);
        try {dctrl.edit(newdatas);} catch (Exception e){}
        message ="Data " + newdatas.getNama()+" telah diUbah";
        return message;
    }
    
        @RequestMapping(value ="/DELETE", method = RequestMethod.DELETE, consumes = APPLICATION_JSON_VALUE)
    public String deleteData(HttpEntity<String> kiriman) throws Exception{
        String message="no action";
        String json_receive = kiriman.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Uas newdatas = new Uas(); //jika ingin banyak data pake List atau ArrayList     
        newdatas = mapper.readValue(json_receive, Uas.class);
        dctrl.destroy(newdatas.getId());
        return "deleted";
    }
}

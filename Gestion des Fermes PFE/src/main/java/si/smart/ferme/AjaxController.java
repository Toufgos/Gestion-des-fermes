package si.smart.ferme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import si.smart.ferme.entities.Groupe;

@Controller
@RequestMapping(value="/result")
public class AjaxController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		
		return "index";
	}
	@RequestMapping(value="/json", method= RequestMethod.GET)
	@ResponseBody
	public Groupe json(){
		Groupe g=new Groupe("Groupe X");
		g.setId(1L);
		return g;
	}

}

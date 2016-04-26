package si.smart.ferme.entities;

import java.util.ArrayList;
import java.util.List;

public class TestPoly {
	public long polygone;
	public List<CoordonnesGPS> coor;
	public TestPoly() {
		super();
		// TODO Auto-generated constructor stub
		coor= new ArrayList<CoordonnesGPS>();
	}
	@Override
	public String toString() {
		String txt ="TestPoly [ploygone=" + polygone + ", coor=\n";
		for (CoordonnesGPS coordonnesGPS : coor) {
			txt+= ""+coordonnesGPS.getLatitude()+"  "+coordonnesGPS.getLongitude()+"\n";
		}
		txt+= "]";
		return txt;
	}
	
}

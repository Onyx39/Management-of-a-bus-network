import java.util.ArrayList;

class Station {

    public String station_name;
    public ArrayList<Line> lines;
    public ArrayList<Station> voisins;
    public ArrayList<Horaire> horaires_normaux;
    public ArrayList<Horaire> horaires_feries; 

    public Station (String aName) {
        station_name = aName;
        lines = new ArrayList<Line>();
        voisins = new ArrayList<Station>();
        horaires_normaux = new ArrayList<Horaire>();
        horaires_feries = new ArrayList<Horaire>();
    }
    
    public void addLine(Line l) {
        lines.add(l);
    }

    public void addVoisin (Station s) {
        voisins.add(s);
        s.voisins.add(this);
    }

    public void addHoraireNormal (Horaire h){
        horaires_normaux.add(h);
    } 
    
    public void addHoraireFerie (Horaire h){
        horaires_feries.add(h);
    }   
    
    @Override
    public String toString () {
        return "Station : " + this.station_name;
    }
}
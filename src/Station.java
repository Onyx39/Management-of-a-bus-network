import java.util.ArrayList;

class Station {

    public String station_name;
    public ArrayList<Line> lines;
    public ArrayList<Station> voisins;
    //public ArrayList<Station> voisins_sens_1;
    //public ArrayList<Station> voisins_sens_2;
    public ArrayList<Horaire> horaires_normaux_sens_1;
    public ArrayList<Horaire> horaires_normaux_sens_2;
    public ArrayList<Horaire> horaires_feries_sens_1; 
    public ArrayList<Horaire> horaires_feries_sens_2; 

    public Station (String aName) {
        station_name = aName;
        lines = new ArrayList<Line>();
        voisins = new ArrayList<Station>();
        //voisins_sens_1 = new ArrayList<Station>();
        //voisins_sens_2 = new ArrayList<Station>();
        horaires_normaux_sens_1 = new ArrayList<Horaire>();
        horaires_normaux_sens_2 = new ArrayList<Horaire>();
        horaires_feries_sens_1 = new ArrayList<Horaire>();
        horaires_feries_sens_2 = new ArrayList<Horaire>();
    }
    
    public void addLine(Line l) {
        lines.add(l);
    }

    public void addVoisin (Station s) {
        voisins.add(s);
        s.voisins.add(this);
    }

    /*public void addVoisins_sens1 (Station s) {
        voisins_sens_1.add(s);
        s.voisins_sens_2.add(this);
        voisins.add(s);
        s.voisins.add(this);
    }

    public void addVoisins_sens2 (Station s) {
        voisins_sens_2.add(s);
        s.voisins_sens_1.add(this);
        voisins.add(s);
        s.voisins.add(this);
    }*/

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public ArrayList<Horaire> getHoraires_normaux_sens_1() {
        return horaires_normaux_sens_1;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Station> getVoisins() {
        return voisins;
    }

    public void setVoisins(ArrayList<Station> newVoisins) {
        this.voisins = newVoisins;
    }

    /*public ArrayList<Station> getVoisins_sens_1() {
        return voisins_sens_1;
    }

    public void setVoisins_sens_1(ArrayList<Station> voisins_sens_1) {
        this.voisins_sens_1 = voisins_sens_1;
    }

    public ArrayList<Station> getVoisins_sens_2() {
        return voisins_sens_2;
    }

    public void setVoisins_sens_2(ArrayList<Station> voisins_sens_2) {
        this.voisins_sens_2 = voisins_sens_2;
    }*/

    public void setHoraires_normaux_sens_1(ArrayList<Horaire> horaires_normaux_sens_1) {
        this.horaires_normaux_sens_1 = horaires_normaux_sens_1;
    }

    public ArrayList<Horaire> getHoraires_normaux_sens_2() {
        return horaires_normaux_sens_2;
    }

    public void setHoraires_normaux_sens_2(ArrayList<Horaire> horaires_normaux_sens_2) {
        this.horaires_normaux_sens_2 = horaires_normaux_sens_2;
    }

    public ArrayList<Horaire> getHoraires_feries_sens_1() {
        return horaires_feries_sens_1;
    }

    public void setHoraires_feries_sens_1(ArrayList<Horaire> horaires_feries_sens_1) {
        this.horaires_feries_sens_1 = horaires_feries_sens_1;
    }

    public ArrayList<Horaire> getHoraires_feries_sens_2() {
        return horaires_feries_sens_2;
    }

    public void setHoraires_feries_sens_2(ArrayList<Horaire> horaires_feries_sens_2) {
        this.horaires_feries_sens_2 = horaires_feries_sens_2;
    }

    @Override
    public String toString () {
        String res = "Station : " + this.station_name + " (";
        for (int y = 0; y < lines.size(); y++) {
            String[] split = lines.get(y).line_name.split(" ");
            res += split[0] + ", ";
        }
        res = res.substring(0, res.length()-2);
        res = res + ')';
        return res;

    }
}
import java.util.ArrayList;

class Station {

    public String station_name;
    public ArrayList<Line> station_lines;

    public Station (String aName) {
        station_name = aName;
        station_lines = new ArrayList<Line>();
    }
    
    public void addLine(Line l) {
        station_lines.add(l);
    }

    @Override
    public String toString () {
        return "Station : " + this.station_name;
    }
}
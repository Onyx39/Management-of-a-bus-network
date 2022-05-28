import java.util.ArrayList;

class Line {

    public String line_name;
    public ArrayList<Station> station_list;

    public Line (String aName) {
        line_name = aName;
        station_list = new ArrayList<Station>();
    }

    public void addStation(Station s) {
        station_list.add(s);
        s.addLine(this);
    }

    @Override
    public String toString () {
        String res = "Ligne " + this.line_name + "\n";
        for (int i = 0; i < station_list.size(); i++) {
            res = res + "   " + station_list.get(i) + "\n";
        }
        return res;

    }
}
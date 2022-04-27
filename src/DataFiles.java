import java.util.ArrayList;

class DataFiles {

    public ArrayList<String> paths_list;

    public DataFiles () {
        paths_list = new ArrayList<String>();
    }

    public void addPath(String s) {
        this.paths_list.add(s);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.paths_list.size(); i++) {
            s += this.paths_list.get(i) + "\n";
        }
        return s;
    }



}
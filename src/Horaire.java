class Horaire {

    public int heure, minutes;

    public Horaire (int uneHeure, int uneMinute) {
        if ((0 <= uneHeure) && (uneHeure <= 23) && (0 <= uneMinute) && (uneMinute <= 59)) {
            heure = uneHeure;
            minutes = uneMinute;
        }
        else {
            throw new java.lang.Error("Vous n'avez pas défni correctement l'horaire");
        }
    }

    public Horaire addition(Horaire h) {
        int newMinute = this.minutes + h.minutes;
        int newHeure = this.heure + h.heure;
        if (newMinute >= 60) {
            newHeure ++;
            newMinute =- 60;
        }
        if (newHeure >= 24) {
            newHeure =- 24;
        }
        return new Horaire(newHeure, newMinute);
    }

    public Horaire soustraction(Horaire h) {
        int newMinute = this.minutes - h.minutes;
        if (newMinute < 0) {
            newMinute += 60;
            if (h.heure < 23) {
            h.heure ++;
            }
            else {
                h.heure = 0;
            }
        }
        int newHeure = this.heure - h.heure;

        return new Horaire(newHeure, newMinute);
    }

    @Override
    public String toString () {
        if (minutes > 10) {
            return heure + ":" + minutes;
        }
        else {
        return heure + ":0" + minutes;
        }
    }
}
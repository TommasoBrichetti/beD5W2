package Classes;

public class Magazines extends Item{

    Periodicity periodicity;

    public Magazines(String _title, int _year, int _pageNumber, Periodicity _periodicity) {
        super(_title, _year, _pageNumber);

        setPeriodicity(_periodicity);
    }

    public void setPeriodicity(Periodicity _periodicity) {
        this.periodicity = _periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    @Override
    public String toString(){
        return getTitle() +  ", " + getPeriodicity() + ", " + getYear();
    }

}

package project.domain;

/**
 * 架构师
 */
public class Architect extends Designer {

    private  int stock;//股票

    public Architect(double bonus, int stock) {
        super(bonus);
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t架构师\t" + getStatus() + "\t" + getBonus() +"\t" + stock +"\t\t\t" +getEquipment().getDescription() ;
    }
}

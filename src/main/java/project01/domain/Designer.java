package project01.domain;

/**
 *  设计师
 */
public class Designer extends Programmer{
    private double bonus;//奖金

    public Designer(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t工程师\t" + getStatus() + "\t" + bonus +"\t\t\t\t\t" +getEquipment().getDescription() ;
    }

    public String getDetailsForTeam(){
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" +getAge() + "\t" +getSalary() + "\t设计师" +"\t" +getBonus();
    }
}

import java.io.Serializable;

public class PetRecord implements Serializable {
    private String _name;
    private int _age;         //in years
    private double _weight;   //in pounds

    // Constructors
    public PetRecord() {
        this("",0,0);
    }
    public PetRecord(String name) {
        this(name,0,0);
    }
    public PetRecord(PetRecord petRecord) {
        this(petRecord.getName(),petRecord.getAge(),petRecord.getWeight());
    }
    public PetRecord(String name, int age, double weight) {
        // Designated initalizer 
        setName(name);
        setAge(age);
        setWeight(weight);
    }

    // Setters
    public void setName(String name) {
        _name = name; 
    }
    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age must be positive.");
        _age = age;        
    }
    public void setWeight(double weight) {
        if (weight < 0)
            throw new IllegalArgumentException("Weight must be positive.");
        _weight = weight;
    }

    // Getters
    public String getName() {
        return _name;
    }
    public int getAge() {
        return _age;
    }
    public double getWeight() {
        return _weight;
    }

    // Object 
    @Override
    public String toString() {
        return String.format("%s:%s:%s",getName(),getAge(),getWeight());
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) 
            return false;
        else if (o.getClass() != this.getClass())
            return false;
        else {
            PetRecord otherRecord = (PetRecord) o;

            boolean isSameName   = this.getName().equals(otherRecord.getName());
            boolean isSameAge    = this.getAge() == otherRecord.getAge();
            boolean isSameWeight = this.getWeight() == otherRecord.getWeight();
            return isSameName && isSameAge && isSameWeight;
        }
    }
    
    // Convenience
    public PetRecord copy() {
        return new PetRecord(this);
    }
}
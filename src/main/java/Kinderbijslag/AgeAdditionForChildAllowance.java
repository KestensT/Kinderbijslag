package Kinderbijslag;

public interface AgeAdditionForChildAllowance {

    double ageAddition(Child child);

    double ageAdditionFirstChild(int age);

    double ageAdditionNotFirstChild(int age);

}

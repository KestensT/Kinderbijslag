package Kinderbijslag;

public interface UnemployedPensionedParents {

    double additionForPensionsAndUnemployed(boolean isSingleParent, Child... children);

    double calculateChildAllowanceForPensionedOrUnemployedParents(boolean isSingleParent, Child... children);


}

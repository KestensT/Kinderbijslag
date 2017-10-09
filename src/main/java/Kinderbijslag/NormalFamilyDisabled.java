package Kinderbijslag;

public class NormalFamilyDisabled implements AgeAdditionForChildAllowance, NormalFamilySituation, DisabledParent {

    private Child[] child;

    public NormalFamilyDisabled(Child... child) {
        this.child = child;
    }

    public double calculateChildAllowancePlusAgeAddition(Child... children) {
        double totalAgeAddition = 0;
        for (Child c : children) {
            totalAgeAddition += ageAddition(c);

        }
        return childAllowance(children) + totalAgeAddition;

    }

    public double calculateChildAllowanceForDisabledParents(Child... children) {
        return calculateChildAllowancePlusAgeAddition(children) + additionForDisabledParents(children);
    }

    public double additionForDisabledParents(Child... children) {
        switch (children.length) {
            case 1:
                return 46.88;
            case 2:
                return 46.88 + 29.06;          // eerste kind + tweede kind --> case 2 kinderen
            default:
                return 46.88 + 29.06 + (23.43 * (children.length - 2));
        }
    }


    @Override
    public double childAllowance(Child... children) {
        switch (children.length) {
            case 1:
                return 92.09;
            case 2:
                return 92.09 + 170.39;          // eerste kind + tweede kind --> case 2 kinderen
            default:
                return 92.09 + 170.39 + (254.40 * (children.length - 2));
        }

    }

    @Override
    public double ageAddition(Child child) {
        int age = child.getAge();
        int rank = child.getRank();
        if (rank == 1) {
            return ageAdditionFirstChild(age);
        }
        return ageAdditionNotFirstChild(age);
    }


    public double ageAdditionFirstChild(int age) {
        if (age > 5 && age < 12) {
            return 16.04;
        }
        if (age > 11 && age < 18) {
            return 24.43;
        }
        if (age > 17) {
            return 28.16;
        }
        return 0;

    }

    public double ageAdditionNotFirstChild(int age) {
        if (age > 5 && age < 12) {
            return 31.99;
        }
        if (age > 11 && age < 18) {
            return 48.88;
        }
        if (age > 17) {
            return 62.15;
        }
        return 0;

    }


}



package Kinderbijslag;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.Test;

public class NormalFamilyTest {
    @Test
    public void calculateChildAllowance_forOneChild() throws Exception {
        Child child = new Child(6, 1);

        NormalFamily normalFamily = new NormalFamily(child);

        double expected = 92.09 + 16.04;

        Assertions.assertThat(normalFamily.calculateChildAllowancePlusAgeAddition(child)).isEqualTo(expected);

    }

    @Test
    public void childAllowance_forMultipleChildren() throws Exception {

        Child[] children = new Child[2];
        children[0] = new Child(5, 1);
        children[1] = new Child(5, 2);
        NormalFamily normalFamily = new NormalFamily(children);


        double expected = 92.09+170.39;

        Assertions.assertThat(normalFamily.childAllowance(children)).isEqualTo(expected);


    }

    @Test
    public void calculateChildAllowance_forTwoChildren() throws Exception {
        Child[] children = new Child[2];
        children[0] = new Child(6, 1);
        children[1] = new Child(5, 2);
        NormalFamily normalFamily = new NormalFamily(children);

        double expected = 92.09+170.39+16.04;

        Assertions.assertThat(normalFamily.calculateChildAllowancePlusAgeAddition(children)).isEqualTo(expected);
    }

    @Test
    public void calculateChildAllowance_forLotsOfChildren() throws Exception {
        Child[] children = new Child[3];
        children[0] = new Child(13, 1);
        children[1] = new Child(7, 2);
        children[2] = new Child(4,3);
        NormalFamily normalFamily = new NormalFamily(children);

        double expected = 92.09 + 24.43 + 170.39 + 31.99 + 254.40;

        Assertions.assertThat(normalFamily.calculateChildAllowancePlusAgeAddition(children)).isEqualTo(expected);

    }

    @Test
    public void calculateChildAllowance_forLotsOfChildernWithSingleParentPensionedOrUnemployed() throws Exception {

        Child[] children = new Child[3];
        children[0] = new Child(13, 1);
        children[1] = new Child(7, 2);
        children[2] = new Child(4,3);
        NormalFamilyPensionedOrUnemployed normalFamily = new NormalFamilyPensionedOrUnemployed(children);

        double expected = normalFamily.calculateChildAllowancePlusAgeAddition(children) +
                46.88 + 29.06 + 23.43;

        Assertions.assertThat(normalFamily.calculateChildAllowanceForPensionedOrUnemployedParents(true, children)).isEqualTo(expected, Offset.offset(0.001));

    }
    @Test
    public void calculateChildAllowance_forLotsOfChildrenWithDisabledParents() throws Exception {

        Child[] children = new Child[3];
        children[0] = new Child(13, 1);
        children[1] = new Child(7, 2);
        children[2] = new Child(4,3);
        NormalFamilyDisabled normalFamilyDisabled = new NormalFamilyDisabled(children);

        double expected = normalFamilyDisabled.calculateChildAllowancePlusAgeAddition(children) +
                46.88 + 29.06 + 23.43;

        Assertions.assertThat(normalFamilyDisabled.calculateChildAllowanceForDisabledParents(children)).isEqualTo(expected, Offset.offset(0.001));



    }

}

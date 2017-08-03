package accessModifiers;

/**
 * public” or “default” access modifiers allowed at class level
 *
 */
public class AccessModifierTest {
    static int saticv;
    int nonStaticv;

    public AccessModifierTest() {
        nonStaticv = 9;
        System.out.println("Coonstruction...");
    }

    static {
        saticv = 10;
        getSaticv();
        System.out.println("static block....");
    }

    {
        System.out.println("instacne block");
    }
    public void testAMT() {
        System.out.println("AMT .......");
    }

    public static void staticM() {
        System.out.println("Static method....");
    }


    public static int getSaticv() {
        return saticv;
    }

    public static void setSaticv(int saticv) {
        AccessModifierTest.saticv = saticv;
    }

    public int getNonStaticv() {
        return nonStaticv;
    }

    public void setNonStaticv(int nonStaticv) {
        this.nonStaticv = nonStaticv;
    }

    int add(int i, float j) {
        System.out.println("int add(int i, float j)");
        return (int) (i+j);
    }

    int add(float i, int j) {
        System.out.println("int add(float i, int j)");
        return (int) (i+j);
    }

    public static void main(String[] args) {

        AccessModifierTest test = new AccessModifierTest();
        int add = test.add(5, 6);
        System.out.println(add);
    }
}

/*class Demo {
    public void testDemo() {
        System.out.println("Demo.......");
    }
}*/

class ChangeStr {
    private String myStr;

    ChangeStr(String str) {
        myStr = str;
    }

    public void setMyStr(String newStr) {
        myStr = newStr;
    }

    public String toString() {
        return myStr;
    }
}

public class Refer_test {
    public static void main(String[] args) {
        Refer_test t = new Refer_test();

        System.out.println("==== Test 1 ====");
        ChangeStr changeStr1 = new ChangeStr("Hello");
        System.out.println(changeStr1);
        t.change1(changeStr1);
        System.out.println(changeStr1);

        System.out.println("==== Test 2 ====");
        ChangeStr changeStr2 = new ChangeStr("Hello");
        System.out.println(changeStr2);
        t.change2(changeStr2);
        System.out.println(changeStr2);
    }

    // Method 1
    public void change1(ChangeStr cs) {
        cs.setMyStr("Hi");
        cs = new ChangeStr("HaHa");
    }

    // Method 2
    public void change2(ChangeStr cs) {
        cs = new ChangeStr("HaHa");
        cs.setMyStr("Hi");
    }

}

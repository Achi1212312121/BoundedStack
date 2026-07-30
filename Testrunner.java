
/**
 * Test runner
 */
public class Testrunner {

    private static int passed = 0;
    private static int failed = 0;

    /** helper กลาง — พิมพ์ PASS/FAIL และนับผลให้เอง */
    private static void check(String name, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("[PASS] " + name);
        } else {
            failed++;
            System.out.println("[FAIL] " + name);
        }
    }

    public static void main(String[] args) {
        boolean assertsOn = false;
        assert assertsOn = true;
        if (!assertsOn) {
            System.out.println("WARNING: assertions disabled" + " - re-run with: java -ea PlaylistTest\n");
        }

        System.out.println("=== Playlist Test Suite ===\n");
        testCreators();
        PopandPush();
        testExceptions();
        testPeek();

        System.out.println("\n=== Summary ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total : " + (passed + failed));
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");

    }

    private static void testCreators() {
        System.out.println("-- Creators --");
        BoundedStack box = new BoundedStack(3);
        check("new(3) -> capacity is 3", box.getCapacity() == 3);
        check("new(3) -> size is 0", box.Nullcapacity() == true);
        check("new(3) -> is null", box.Nullcapacity() == true);
        check("new(3) -> Maxcapacity is false", box.Maxcapacity() == false);
    }

    private static void PopandPush() {
        /*
         * // ทดสอบการวางและยกกล่อง
         */
        System.out.println("-- Pop&&Push --");
        BoundedStack box = new BoundedStack(3);
        check("new() -> size is 0", box.getSize() == 0);
        box.push(10);
        check("new() -> size is 3", box.getSize() == 1);
        check("stack is not null is now", box.Nullcapacity() == false);
        box.push(20);
        box.push(30);
        check("new() -> size is 3", box.Maxcapacity() == true);
        // pop
        check("pop() 1st->should return 30", box.pop() == 30);
        check("pop() -> size is 2", box.getSize() == 2);
        check("pop() 2nd -> should return 20", box.pop() == 20);
        check("pop()  -> size is 1", box.getSize() == 1);
        check("pop() 3rd -> should return 10", box.pop() == 10);
        check("pop()  -> size is 0", box.getSize() == 0);
        check("pop all -> Nullcapacity is true again", box.Nullcapacity() == true);
    }

    private static void testExceptions() {
        System.out.println("-- Exceptions --");
        BoundedStack Emptybox = new BoundedStack(3);
        try {
            Emptybox.pop();
            check("pop() on empty stack should throw exception", false);
        } catch (IllegalArgumentException e) {
            check("pop() on empty stack should throw exception", true);
        }

        BoundedStack Fullbox = new BoundedStack(3);
        Fullbox.push(10);
        Fullbox.push(20);
        Fullbox.push(30);
        try {
            Fullbox.push(40);
            check("push() on full stack should throw exception", false);
        } catch (IllegalArgumentException e) {
            check("push() on full stack should throw exception", true);
        }

        BoundedStack NegativeWeightBox = new BoundedStack(3);
        try {
            NegativeWeightBox.push(-10);
            check("push() with negative weight should throw exception", false);
        } catch (IllegalArgumentException e) {
            check("push() with negative weight should throw exception", true);
        }
    }

    private static void testPeek() {
        System.out.println("-- Test Peek Behavior --");
        BoundedStack box = new BoundedStack(3);

        box.push(15);
        box.push(40);
        check("peek() -> should return top weight (40)", box.peek() == 40);
        check("peek() -> size remains 2", box.getSize() == 2);
        // เช็กค่าอีกรอบเพื่อยืนยันว่า peek() ไม่เปลี่ยนแปลงขนาดของ stack
        check("peek() twice -> still returns 40", box.peek() == 40);
    }
}
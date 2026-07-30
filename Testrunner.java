
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
            System.out.println("[PASS] " + name);//ถ
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
       /*
       // ทดสอบการสร้างกองกล่อง
       */
        System.out.println("-- Creators --");
        BoundedStack box = new BoundedStack(3);// สร้างกองกล่องที่มีความจุ 3
        check("new(3) -> capacity is 3", box.getCapacity() == 3);//เช็กว่ามีวามจุเท่ากับ 3 จริงไหม
        check("new(3) -> size is 0", box.Nullcapacity() == true);//เช็กว่ามีจำนวนกล่องเท่ากับ 0 จริงไหม
        check("new(3) -> is null", box.Nullcapacity() == true);//เช็กว่ากล่องไม่มีมีอยู่จริงไหม
        check("new(3) -> Maxcapacity is false", box.Maxcapacity() == false);//เช็กว่ากล่องมีความจุเต็มจริงไหม เพราะตนนี้ยังไม่มีการวางกล่องลงไป
    }

    private static void PopandPush() {
        /*
         * // ทดสอบการวางและยกกล่อง
         */
        System.out.println("-- Pop&&Push --");//พิมพ์ "-- Pop&&Push --""
        BoundedStack box = new BoundedStack(3);//สร้างความจุของจำนวนกล่อง(มีค่า3)
        check("new() -> size is 0", box.getSize() == 0);//เช็กว่ามีจำนวนกล่องเท่ากับ 0 จริงไหม
        box.push(10);//วางกล่องที่น้ำหนัก10ลง
        check("new() -> size is 3", box.getSize() == 1);//เช็กว่ามีจำนวนกล่องเท่ากับ 1 จริงไหม
        check("stack is not null is now", box.Nullcapacity() == false);//เช็กว่าไม่มีกล่องอยู่จริงไหม เพราะตอนนี้มีการวางกล่องลงไปแล้ว
        box.push(20);//วางกล่องที่น้ำหนัก20ลง
        box.push(30);//วางกล่องที่น้ำหนัก30ลง
        check("new() -> size is 3", box.Maxcapacity() == true);//เช็กว่ากล่องมีความจุเต็มจริงไหม เพราะตอนนี้มีการวางกล่องลงไปแล้ว
        // pop
        check("pop() 1st->should return 30", box.pop() == 30);//ดึงกล่องออกจากกอง (จะได้ 30)
        check("pop() -> size is 2", box.getSize() == 2);//เช็กว่ามีจำนวนกล่องเท่ากับ 2 จริงไหม
        check("pop() 2nd -> should return 20", box.pop() == 20);//ดึงกล่องออกจากกอง (จะได้ 20)
        check("pop()  -> size is 1", box.getSize() == 1);//เช็กว่ามีจำนวนกล่องเท่ากับ 1 จริงไหม
        check("pop() 3rd -> should return 10", box.pop() == 10);//ดึงกล่องออกจากกอง (จะได้ 10)
        check("pop()  -> size is 0", box.getSize() == 0);//เช็กว่ามีจำนวนกล่องเท่ากับ 0 จริงไหม
        check("pop all -> Nullcapacity is true again", box.Nullcapacity() == true);//เช็กว่ากล่องไม่มีมีอยู่จริงไหม เพราะตอนนี้มีการดึงกล่องออกจากกองหมดแล้ว
    }

    private static void testExceptions() {
        System.out.println("-- Exceptions --");//พิมพ์ "-- Exceptions --"
        BoundedStack Emptybox = new BoundedStack(3);//สร้างความจุของจำนวนกล่องว่าง(มีค่า3)
        try {
            Emptybox.pop();//ลองดึงกล่องออกจากกองว่าง
            check("pop() on empty stack should throw exception", false);//เช็กว่ามีการดึงกล่องออกจากกองว่างจริงไหม
        } catch (IllegalArgumentException e) {
            check("pop() on empty stack should throw exception", true);//เช็กว่ามีการดึงกล่องออกจากกองว่างจริงไหม
        }

        BoundedStack Fullbox = new BoundedStack(3);//สร้างความจุของจำนวนกล่องเต็ม(มีค่า3)
        Fullbox.push(10);//วางกล่องที่มีน้ำหนัก10ลง
        Fullbox.push(20);//วางกล่องที่มีน้ำหนัก20ลง
        Fullbox.push(30);//วางกล่องที่มีน้ำหนัก30ลง
        try {
            Fullbox.push(40);//ลองวางกล่องที่มีน้ำหนัก40ลงให้เกินขนาดที่กำหนดไว้
            check("push() on full stack should throw exception", false);
        } catch (IllegalArgumentException e) {
            check("push() on full stack should throw exception", true);
        }

        BoundedStack NegativeWeightBox = new BoundedStack(3);
        try {
            NegativeWeightBox.push(-10);//วางกล่องที่มีน้ำหนักติดลบ
            check("push() with negative weight should throw exception", false);//เช็กว่ามีการวางกล่องที่มีน้ำหนักติดลบจริงไหม
        } catch (IllegalArgumentException e) {
            check("push() with negative weight should throw exception", true);//เช็กว่ามีการวางกล่องที่มีน้ำหนักติดลบจริงไหม
        }
    }

    private static void testPeek() {
        System.out.println("-- Test Peek  --");
        BoundedStack box = new BoundedStack(3);// สร้างความจุของจำนวนกล่อง(มีค่า3)
        box.push(15);// วางกล่องที่มีน้ำหนัก 15 ลง
        box.push(40);// วางกล่องที่มีน้ำหนัก 40 ลง
        check("peek() -> should return top weight (40)", box.peek() == 40);//เช็กว่ากล่องบนสุดมีน้ำหนักเท่ากับ 40 จริงไหม
        check("peek() -> size remains 2", box.getSize() == 2);//เช็กดูว่ากล่องมีจำนวน2กล่องจริงไหม เพราะ peek ไม่เปลี่ยนแปลงขนาดของ stack
        check("peek() twice -> still returns 40", box.peek() == 40);// เช็กค่าอีกรอบเพื่อยืนยันว่า peek ไม่เปลี่ยนแปลงขนาดของ stack
    }
}
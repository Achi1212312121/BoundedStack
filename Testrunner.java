
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
        

        System.out.println("\n=== Summary ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total : " + (passed + failed));
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");

        

    }
    private static void testCreators(){
        System.out.println("-- Creators --");
        BoundedStack box = new BoundedStack(3);
        check("new(3) -> capacity is 3",box.getCapacity() == 3 );
    
        
    }
}
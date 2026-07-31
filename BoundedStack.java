/*
    //โปรแกรมนี้เป็นโปรแกรมที่ใช้ในการจัดการกองกล่องสินค้าที่มีน้ำหนักต่างกัน โดยใช้โครงสร้างข้อมูลแบบ Stack ที่มีขนาดจำกัด
    //ข้อบังคับของโปรแกรมคือสามารถใส่ขนาดของจำนวนกล่องเท่ากับจำนวนกล่องที่กำหนดไว้ตั้งแต่แรกไม่สามารถเพิ่มได้อีก
    //ตัวอย่างการใช้งานโค้ด(pre-code)

    //1.การสร้างBoundedStack โดยกำหนดความจุของชั้นวางเป็น 3
    //BoundedStack box = new BoundedStack(3);

    //2.นำกล่องที่มีน้ำหนักต่างกันมาวางซ้อนกัน
    //box.push(10);
    //box.push(20);
    //box.push(30);

    //3.ดึงกล่องออกจากชั้นวาง
    //box.pop();(จะได้กล่องที่มีน้ำหนัก 30 ออกมาและขนาดของจำนวนกล่องที่มีอยู่ตอนนี้จะลดลงเหลือ 2)

    //4.เช็คน้ำหนักของกล่องบนสุด
    //box.peek();(จะได้กล่องที่มีน้ำหนัก 20 ออกมา)

    *BoundedStack box = new BoundedStack(3); // สร้างกองกล่องที่มีความจุ 3
    *box.push(10); // วางกล่องที่มีน้ำหนัก 10 ลง
    *box.push(20); // วางกล่องที่มีน้ำหนัก 20 ลง
    *box.push(30); // วางกล่องที่มีน้ำหนัก 30 ลง
    *System.out.println(box.pop()); // ดึงกล่องออกจากกอง (จะได้ 30)
    *System.out.println(box.peek()); // ดูน้ำหนักของกล่องบนสุด (จะได้ 20)
*/

public class BoundedStack {
    private final int[] weight;//น้ำหนักของกล่องแต่ละกล่อง
    private int size;//จำนวนกล่องที่มีอยู่
    // ===== representation =====

    // AF
    // AF(weight,size)=กองกล่องสินค้าที่มีกล่องล่างสุดน้ำหนัก weights[0] kg
    // และกล่องบนสุดน้ำหนัก weights[size - 1] kg

    // Ri
    // weight!=null
    // 0 <= size <= weight.length
    // weights[0 ... size-1] ทุกตัวต้อง > 0 (น้ำหนักกล่องต้องเป็นบวก)

    private void checkRep() {
        assert weight != null : "weight is not null";//ตรวจสอบว่าตัวแปร weight ไม่เป็น null
        assert size <= weight.length && size >= 0 : "Invalid size: " + size;//ตรวจสอบว่าตัวแปร size มีค่าถูกต้อง
        for (int i = 0; i < size; i++) {
            assert weight[i] > 0 : "weight at index " + i + " must be greater than 0";//ตรวจสอบว่าตัวแปร weight ทุกตัวมีค่ามากกว่า 0
            }
        }

    /*
     * //Creator
     */
    
    /*
     * //กำหนดความจุของขนาดชั้นวาง
    // @param capacity ความจุของชั้นวางต้องมากกว่า0
    // @throws IllegalArgumentException ถ้าความจุน้อยกว่าหรือเท่ากับ 0
     */
    public BoundedStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");//ตรวจสอบว่าความจุของชั้นวางต้องมากกว่า 0
        }
        this.weight = new int[capacity];//สร้าง array ของน้ำหนักที่กำหนดความจุของชั้นวาง
        this.size = 0;//กำหนดจำนวนกล่องที่มีอยู่เป็น 0
        checkRep();//เช็คเงื่อนไขRi
    }

    /*
     * Mutator
     */

    /*
     * //วางกล่อง
     * //@param kg ของกล่อง น้ำหนักต้องมากกว่า0และชั้นวางต้องไม่เต็ม
     * //@throws IllegalArgumentException ถ้าน้ำหนักน้อยกว่า0 หรือ ชั้นวางเต็ม
     */

    public void push(int kg) {
        if (kg <= 0)
            throw new IllegalArgumentException("น้ำหนักต้องมากกว่า0"); //ตรวจสอบน้ำหนักต้องมากกว่าหรือเท่ากับ0
        if (Maxcapacity())
            throw new IllegalArgumentException("ชั้นเต็มแล้ว"); // ชั้นวางเต็มแล้ว
        weight[size] = kg;//วางกล่องลงบนชั้นวาง
        size++;//เพิ่มจำนวนกล่องที่มีอยู่
        checkRep();//เรียกใช้ฟังก์ชัน checkRep(เช็คเงื่อนไขRi)
    }

    /*
     * //ยกกล่อง
     * //@return ดึงกล่องออกไป
     * //@throws IllegalArgumentException
     */
    public int pop() {
        if (Nullcapacity())
            throw new IllegalArgumentException("ไม่มีกล่องให้เอาออก");//ตรวจสอบว่ามีกล่องไหม
        size--;//เอากล่องออกจากชั้นวาง
        int removeweight = weight[size];// เก็บน้ำหนักของกล่องที่ถูกเอาออกไป
        weight[size] = 0;// กำหนดน้ำหนักของกล่องที่ถูกเอาออกไปเป็น 0
        checkRep();//เช็คเงื่อนไขRi
        return removeweight;//คืนค่าน้ำหนักของกล่องที่ถูกเอาออกไป
    }

    /*
     * //Observer
     */

    /*
     * //ดูน้ำหนักกล่องบนสุด
     * //@return กล่องที่อยู่บนสุด
     * //@throw IllegalStateException ถ้าstackยังว่างอยู่
     */
    public int peek() {
        if (Nullcapacity()) {
            throw new IllegalStateException("กล่องยังว่างอยู่ ไม่มีอะไรให้เช็ค");//ตรวจสอบว่ามีกล่องไหม
        }
        return weight[size - 1];//ส่งค่าน้ำหนักของกล่องบนสุด
    }

    /*
     * //เช็ดว่าข้อมูลเต็มรึยัง
     * 
     * @return true ถ้าจำนวนข้อมูลเต็ม,false ถ้าข้อมูลเหลือ
     */
    public boolean Maxcapacity() {
        return size == weight.length;//กำหนดค่าขนาดของจำนวนกล่องที่ใส่ได้ และส่งค่ากลับไป
    }

    /*
     * //เช็ดว่าข้อมูลว่างไหม
     * //@return trunถ้าไม่มีข้อมูล,false ถ้ามีข้อมูลเหลือ
     */
    public boolean Nullcapacity() {
        return size == 0;//กำหนดค่ากล่องให้เท่ากับ 0 และส่งค่ากลับไป
    }

    /*
     * //ดูจำนวนกล่องที่มีอยู่ตอนนี้
     * //@return จำนวนกล่องที่มี
     */
    public int getSize() {
        return size;//ส่งค่าจำนวนกล่องที่มีอยู่ตอนนี้
    }

    /*
     * //ดูความจุสูงสุดของชั้นวาง
     * //@return ความจุสูงสุดที่รับได้
     */
    public int getCapacity() {
        return weight.length;//ส่งค่าขนาดของจำนวนกล่องกลับไป
    }
}

/*
    
*/

public class BoundedStack {
    private final int[] weight;
    private int size;
   // ===== representation =====

   //AF
   //AF(weight,size)=กองกล่องสินค้าที่มีกล่องล่างสุดน้ำหนัก weights[0] kg
   //                และกล่องบนสุดน้ำหนัก weights[size - 1] kg

   //Ri
   // weight!=null
   // 0 <= size <= weight.length
   // weights[0 ... size-1] ทุกตัวต้อง > 0 (น้ำหนักกล่องต้องเป็นบวก)

   private void checkRep(){
        assert  weight != null :"weight is not null";
        assert size <= weight.length && size >= 0 :"Invalid size: " + size;
        for(int i=0;i<size;i++){
            if (weight[i]<=0) {
                assert weight[i]>= 0:"weight must be more than 0";
            }
        }
   }

   //Creator
   /*
    //กำหนดความจุของขนาดชั้นวาง
   */
   public BoundedStack(int capacity){
        this.weight = new int[capacity];
        this.size = 0;
        checkRep();
   }
   
   /*
    *Mutator
     */
    
    /*
     //วางกล่อง
     //@param kg ของกล่อง น้ำหนักต้องมากกว่า0และชั้นวางต้องไม่เต็ม
     //@throws IllegalArgumentException ถ้าน้ำหนักน้อยกว่า0 หรือ ชั้นวางเต็ม
    */
    
    public void push(int kg){
        if (kg<=0) throw new IllegalArgumentException("น้ำหนักต้องมากกว่า0");
        if (Maxcapacity())throw new IllegalArgumentException("ชั้นเต็มแล้ว");
        weight[size]=kg;
        size++;
        checkRep();
   }

   /*
     //ยกกล่อง
     //@return ดึงกล่องออกไป   
     //@throws IllegalArgumentException
   */
   public int pop(){
    if (Nullcapacity()) throw new IllegalArgumentException("ไม่มีกล่องให้เอาออก");
    size--;
    int removeweight = weight[size];
    weight[size] = 0;
    checkRep();
    return removeweight;
   }

   /*
   //Observer
   */
 

   
 /*
   //เช็ดว่าข้อมูลเต็มรึยัง
   @return true ถ้าจำนวนข้อมูลเต็ม,false ถ้าข้อมูลเหลือ
 */
   public boolean Maxcapacity(){
    return size == weight.length;
     }

     /*
     //เช็ดว่าข้อมูลว่างไหม
     //@return trunถ้าไม่มีข้อมูล,false ถ้ามีข้อมูลเหลือ
     */
     public boolean Nullcapacity(){
        return size == 0;
     }
/*
    //ดูจำนวนกล่องที่มีอยู่ตอนนี้
    //@return จำนวนกล่องที่มี
*/
     public int getSize(){
        return size;
     }

}

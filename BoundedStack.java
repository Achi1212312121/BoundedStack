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
    *กำหนดความจุของขนาดชั้นวาง
   */
   public BoundedStack(int capacity){
        this.weight = new int[capacity];
        this.size = 0;
        checkRep();
   }

}

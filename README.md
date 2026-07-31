# Lab - สร้าง ADT-Boundenstack(วางกล่องยกกล่องและดูน้ำหนักบนกล่องสุด)

## ไฟล์ในโฟลเดอร์นี้

| ไฟล์ | คำอธิบาย |
|---|---|
| `BoundedStack.java` | โค้ดหลักของ ADT พร้อม JavaDoc อธิบายสเปก |
| `Testrunner.java` | ชุดทดสอบอัตโนมัติ 21 เคส  |
| `README.md` | ไฟล์นี้ |

## วิธี compile และรัน

**ตั้งค่าใน VSCode** ให้เปิด `-ea` อัตโนมัติ — เพิ่มใน `.vscode/settings.json`:

```json
{
  "java.debug.settings.vmArgs": "-ea"
}
```
---

## เป้าหมาย

1.ระบุตัวดำเนินการให้ครบ4ตัว: Creator, Producer, Observer, Mutator
2.เขียน Abstraction Function(AF) และ Representation Invariant(RI)และต้องมีcheckRep()ตรวจสอบสถานะเสมอ
3.ต้องเขียนTest Runnerเอง ห้ามใช้ JUnit / TestNG / assertJ(ต้องมีอย่างน้อย20-40เคส)
4.ทดสอบให้ครอบคลุม รวมถึงเคส Boundary และ Exception


เมื่อทำเสร็จถูกต้องทั้งหมด จะได้ผลลัพธ์แบบนี้

```
=== Summary ===
Passed: 21
Failed: 0
Total : 21
ALL TESTS PASSED
```

> การตรวจ exception ใช้ `try` / `catch` ตรง ๆ และ `main()` เรียกเมธอดเทสต์ทีละบรรทัด

## สเปคของ ADT

### ค่านามธรรม (A)

stackสามารถเก็บข้อมูลสุงสุดได้แค่ที่กำหนดเท่านั้น โดยข้อมูลที่ใส่เข้ามาล่าสุด จะถูกนำออกไปใช้งานเป็นตัวแรกเสมอ

### Representation (R)

```java
    private final int[] weight;
    private int size;
```

### กฎที่ต้องรักษาไว้เสมอ

1. กล่องต้องมีน้ำหนักไม่เป็นค่าว่าง
2. จำนวนกล่องที่รับเข้ามาต้องไม่เกินที่กำหนดไว้
3. ค่าของน้ำหนักต้องไม่ติดลบ

---

## Contributors

| ข้อมูลส่วนตัว | รายละเอียด |
| :--- | :--- |
| **ชื่อ-นามสกุล** | [ทัดเทพ แซ่จาง] |
| **รหัสนิสิต** | [682151230] |
| **GitHub ID** | [@thanaphat-mane](https://github.com/taddteps-creator) |

| ข้อมูลส่วนตัว | รายละเอียด |
| :--- | :--- |
| **ชื่อ-นามสกุล** | [อชิตะ เกษมพรทวีกิจ] |
| **รหัสนิสิต** | [6821651884] |
| **GitHub ID** | [@Achi1212312121](https://github.com/Achi1212312121) |
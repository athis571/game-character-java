import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // สร้างออบเจกต์ Scanner เพื่อรอรับข้อมูลที่ผู้ใช้พิมพ์
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("   Welcome to Ragnarok Online (Java) ");
        System.out.println("====================================");

        // 1. ขั้นตอนการสร้างตัวละคร (ตั้งชื่อ)
        System.out.print("Please enter your character name: ");
        String characterName = scanner.nextLine(); // รับค่าบรรทัดที่ผู้ใช้พิมพ์มาเก็บไว้ในตัวแปร

        // สร้างตัวละครด้วยชื่อที่พิมพ์เข้ามา
        RoCharacter player = new RoCharacter(characterName);
        
        System.out.println("\n[System] Character created successfully!");
        player.displayStatus();

        // จำลองการเก็บเลเวลก่อนเปลี่ยนอาชีพ
        System.out.println("\n[System] You are grinding to reach Job Level 10...");
        player.levelUpBase();
        player.levelUpBase(); // สมมติว่าเลเวลอัปจนพร้อมเปลี่ยนอาชีพ

        // 2. ขั้นตอนการเปลี่ยนอาชีพ
        System.out.println("\n====================================");
        System.out.println("      Job Change Center");
        System.out.println("====================================");
        System.out.println("Choose your path, " + player.getName() + ":");
        System.out.println("1. SWORDSMAN (นักดาบ เน้นพลังชีวิตและการโจมตีระยะประชิด)");
        System.out.println("2. MAGE      (นักเวทย์ เน้นพลังเวทมนตร์ทำลายล้าง)");
        System.out.println("3. ARCHER    (นักธนู โจมตีระยะไกลแม่นยำ)");
        System.out.println("4. ACOLYTE   (นักบวช สายสนับสนุนและฟื้นฟู)");
        System.out.println("5. MERCHANT  (พ่อค้า สายหาเงินและสร้างไอเทม)");
        System.out.println("6. THIEF     (โจร เน้นความเร็วและหลบหลีก)");
        System.out.print("Select your class (1-6): ");

        int jobChoice = 0;
        
        // ตรวจสอบว่าผู้ใช้พิมพ์ตัวเลขมาหรือไม่ เพื่อป้องกันโปรแกรม Error
        if (scanner.hasNextInt()) {
            jobChoice = scanner.nextInt();
        } else {
            System.out.println("[Error] Invalid input. Please enter a number.");
            scanner.next(); // เคลียร์ค่าที่ผิดพลาดทิ้ง
        }

        // ใช้ Switch-Case เพื่อเปลี่ยนอาชีพตามตัวเลขที่เลือก
        switch (jobChoice) {
            case 1:
                player.setJob(JobClass.SWORDSMAN);
                break;
            case 2:
                player.setJob(JobClass.MAGE);
                break;
            case 3:
                player.setJob(JobClass.ARCHER);
                break;
            case 4:
                player.setJob(JobClass.ACOLYTE);
                break;
            case 5:
                player.setJob(JobClass.MERCHANT);
                break;
            case 6:
                player.setJob(JobClass.THIEF);
                break;
            default:
                System.out.println("\n[System] Invalid choice. You remain a NOVICE.");
                break;
        }

        // แสดงผลลัพธ์หลังเปลี่ยนอาชีพ
        if (jobChoice >= 1 && jobChoice <= 6) {
            System.out.println("\n[System] Congratulations! " + player.getName() + " is now a " + player.getJob() + "!");
        }
        
        System.out.println("\n--- Updated Status ---");
        player.displayStatus();

        // ปิด Scanner เมื่อเลิกใช้งาน เพื่อคืนพื้นที่หน่วยความจำ
        scanner.close();
    }
}

public class RoCharacter {

    private String name;
    private JobClass job;
    private int baseLevel;
    private int jobLevel;

    private int maxHp;
    private int currentHp;
    private int maxSp;
    private int currentSp;

    private int str;
    private int agi;
    private int vit;
    private int intl; 
    private int dex;
    private int luk;

    public RoCharacter(String name) {
        this.name = name;
        this.job = JobClass.NOVICE;
        this.baseLevel = 1;
        this.jobLevel = 1;
        
        this.maxHp = 40;
        this.currentHp = 40;
        this.maxSp = 11;
        this.currentSp = 11;

        this.str = 1;
        this.agi = 1;
        this.vit = 1;
        this.intl = 1;
        this.dex = 1;
        this.luk = 1;
    }

    public void takeDamage(int damage) {
        this.currentHp -= damage;
        if (this.currentHp <= 0) {
            this.currentHp = 0;
            System.out.println(this.name + " has died! (กลับจุดเซฟ)");
        } else {
            System.out.println(this.name + " took " + damage + " damage. HP left: " + this.currentHp);
        }
    }

    public void heal(int amount) {
        if (this.currentHp <= 0) {
            System.out.println("Cannot heal a dead character. Need Yggdrasil Leaf!");
            return;
        }
        this.currentHp += amount;
        if (this.currentHp > this.maxHp) {
            this.currentHp = this.maxHp;
        }
        System.out.println(this.name + " healed for " + amount + " HP. Current HP: " + this.currentHp);
    }

    public void levelUpBase() {
        this.baseLevel++;
        this.maxHp += 15;
        this.maxSp += 5;
        this.currentHp = this.maxHp;
        this.currentSp = this.maxSp;
        System.out.println("Level Up! " + this.name + " is now Base Level " + this.baseLevel);
    }

    public void displayStatus() {
        System.out.println("=== Character Status ===");
        System.out.println("Name: " + name + " | Job: " + job);
        System.out.println("Base Lv: " + baseLevel + " | Job Lv: " + jobLevel);
        System.out.println("HP: " + currentHp + "/" + maxHp + " | SP: " + currentSp + "/" + maxSp);
        System.out.println("STR: " + str + " | AGI: " + agi + " | VIT: " + vit);
        System.out.println("INT: " + intl + " | DEX: " + dex + " | LUK: " + luk);
        System.out.println("========================");
    }

    public String getName() { return name; }
    public JobClass getJob() { return job; }
    public void setJob(JobClass job) { this.job = job; }
}

import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;

class Main {
    public static String nick;
    public static String input;
    public static String fot = "[attack] [defined] [info] [RUN]";
    public static int HP=10;
    public static int armor=0;
    public static int xp=0;
    public static int atk=1;
    public static int lv=0;
    public static int money = 0;
    public static int zhp=2;
    public static int shp=3;
    public static int zatk=1;
    public static int ver=1;
    public static void main(String[] args) throws InterruptedException {

        Scanner myObj = new Scanner(System.in);
        print("Game Ver.Demo-"+ver);
        print("Made by " + "apo");
        Thread.sleep(1500);
        print("==Story==");
        print("(Story)");
        print("Hey, What's Your Name?");
        nick();
        Thread.sleep(1800);

        System.out.println("-- " + nick + " INFO --" ); //player info
        System.out.println("HP : " + HP);
        print("Armor : " + armor);
        System.out.println("Xp : " + xp);
        System.out.println("attack damage : " + atk);
        System.out.println("lv : "+ lv);
        Thread.sleep(2000);

        print("\nOK Let's Move"); //game play start
        Thread.sleep(1600);
        print("There is a zombie, let's fight!");
        zhp=2;
        zombie();
        Thread.sleep(1200);
        zombie();
        Thread.sleep(1100);
        zombie();
        Thread.sleep(1500);
        village("");
    }

    public static String print(String a) {
        System.out.println(a);
        return a;
    }
    public  static String nick() {
        System.out.println("Enter username on input");
        nick = JOptionPane.showInputDialog("nickname");
        if (nick.equals("APO")) {
            DEV();
        }
        System.out.println("Username : " + nick);
        return null;
    }

    public static void gameover() {
        System.out.println( nick + " Died!");
        System.out.println("GAME OVER!");
        System.exit(0); // terminates if lost
    }
    public static String village(String V) {
        print("This village is your town");
        print("[shop] [dungeon] [quest] [(update)] [(update)]");
        V = JOptionPane.showInputDialog("now, where we go?");
        if (V.equals("shop")) {
            Shop();
        } else if (V.equals("dungeon")) {
            dungeon();
        } else if (V.equals("quest")) {
            quest();
        } else if (V.equals("info")) {
            info();
        } else {
            print("(UPDATE)");
        }
        return null;
    }
    public static void zombie() throws InterruptedException {
        zatk=1;
        if (HP > 0) {
            if (zhp > 0) {
                print(fot);
                input = JOptionPane.showInputDialog("Motion");

                if (input.equals("attack")) {
                    zhp-=atk;
                    print("zombie HP -"+atk);
                    System.out.println("Zombie HP : " + zhp);
                } else if (input.equals("defined")) {
                    armor++;
                    print("armor +1");
                    print("armor : " + armor);
                    Thread.sleep(1500);
                    print("zombie attack me! \n armor -1");
                    --armor;
                } else if (input.equals("info")) {
                    print("--zombie--");
                    print("zombie is default monster");
                    print("attack damage : " + zatk);
                    print("HP : " + zhp);
                } else if (input.equals("run")) {
                    gameover();
                }
            } else {
                print("You Win");
                xp+=1;
                money+=5;
                Thread.sleep(1200);
                print("+1 xp, +5$ lv:" + lv);
                if (xp==10) {
                    xp=0;
                    lv+=1;
                    money+=15;
                    ++ZQ;
                    print("Lv Up!");
                    print("+15$");
                }
                print("lv: " + lv +", Xp: " +xp+", MONEY: "+money+"$");
            }
        } else {
            gameover();
        }
    }
    public static void DEV() {
        print("+EVERYTHING");
        money+=999999999;
        atk+=9999999;
        HP+=99999999;
        lv=999;
    }
    public static String Shop() {
        print("Hello, I'm Shop Keeper What Do You Want?");
        print("[Wooden Sword(+2 attack damage,5$)] \n[(UPDATE)] [(UPDATE)] [(UPDATE)]");
        input=JOptionPane.showInputDialog("select");
        if (input.equals("wooden sword")) {
            print("You Bought a Wooden Sword");
            print("-5$");
            atk+=2;
            money-=5;
        } else {
            print("(UPDATE)");
        }
        village("");
        return null;
    }
    public static String dungeon() {
        print("[ZOMBIE] [SLIME] [(UPDATE)]");
        input=JOptionPane.showInputDialog("select monster");
        if (input.equals("zombie")) {
            try {
                ZF();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        village("");
        return null;
    }
    public static int ZQ=0;
    public static int SQ=0;
    public static String quest() {
        print("==QUEST==");
        print("Kill Zombie ("+ZQ+"/20)");
        print("Kill Slime ("+SQ+"/10)");
        village("");
        return null;
    }
    public static void slime() throws InterruptedException { //slime hp: 3
        shp=1;
        if (HP > 0) {
            if (shp > 0) {
                print(fot);
                input = JOptionPane.showInputDialog("Motion");

                if (input.equals("attack")) {
                    shp-=atk;
                    print("slime HP -"+atk);
                    System.out.println("slime HP : " + shp);
                } else if (input.equals("defined")) {
                    armor++;
                    print("armor +1");
                    print("armor : " + armor);
                    Thread.sleep(1500);
                    print("slime attack me! \n armor -1");
                    --armor;
                } else if (input.equals("info")) {
                    print("--slime--");
                    print("slimeeeeeee");
                    print("attack damage : 1");
                    print("HP : " + shp);
                } else if (input.equals("run")) {
                    gameover();
                }
            } else {
                print("You Win");
                ++SQ;
                xp+=2;
                money+=2;
                Thread.sleep(1200);
                print("+2 xp, +2$ lv:" + lv);
                if (xp==10) {
                    xp=0;
                    lv+=1;
                    money+=15;
                    print("Lv Up!");
                    print("+15$");
                }
                print("lv: " + lv +", Xp: " +xp+", MONEY: "+money+"$");
            }
        } else {
            gameover();
        }
    }
    public static void info() {
        print("==GAME INFO==");
        print("GAME VER : DEMO-"+ver);
        print("DEV BY. APO");
        print("==PLAYER INFO==");
        print("NAME : " + nick);
        print("LV: "+lv);
        print("Xp: "+ xp);
        print("HP: "+HP);
        print("Money: "+money+"$");
        print("Armor: "+armor);
        print("Attack Damage: "+atk);
        village("");
    }
    public static void ZF() throws InterruptedException {
        zhp=2;
        print("Oh, There is a zombie");
        zombie();
        zombie();
        zombie();
    }
    public static void SF() throws  InterruptedException {
        shp=3;
        print("Oh, There is a Slime");
        slime();
        slime();
        slime();
    }
}
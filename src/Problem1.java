class A {
public int key;
public void f() { key = 5; }
}
class B extends A {
public void f() { key = 2*key; }
}
public class Problem1 {
public static void main(String[] args) {
	
A x = new A();
B y = new B();
A z = y;
B w = new B();

x.key = 3;
System.out.println("before x"+ " "  +x.key);
y.key = 7;
System.out.println("before y"+  " " +y.key);
z.key = 9;
System.out.println("before z"+ " "  +z.key);
w.key = y.key;
System.out.println("before w"+  " "  +w.key+"\n");
///////
System.out.println("next x"+  " "  +x.key);
System.out.println("next y"+  " "  +y.key);
System.out.println("next z"+  " "  +z.key);
System.out.println("next w"+  " "  +w.key+"\n");

w.f();
x.f();
y.f();
z.f();
System.out.println("final w"+  " "+w.key);
System.out.println("final x"+  " "+x.key);
System.out.println("final y"+  " "+y.key);
System.out.println("final z"+  " "+z.key);

}
}

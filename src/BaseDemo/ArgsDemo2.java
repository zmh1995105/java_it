package BaseDemo;

public class ArgsDemo2 {
    public static void main(String[] args) {
	int[] arr = {10, 20, 30};
	System.out.println("before call func of change: " + arr[1]);
	change(arr);
	System.out.println("after call func of change: " + arr[1]);
    }

    public static void change(int[] arr) {
	arr[1] = 200;
    }

}

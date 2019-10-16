import java.util.Scanner;

public class test
{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);

    int t1_x = keyboard.next();
    int t1_y = keyboard.next();
    int t1_s = keyboard.next();
    int t2_x = keyboard.next();
    int t2_y = keyboard.next();
    int t2_s = keyboard.next();
    double x1_c = t1_x + (t1_s / 2);
    double y1_c = t1_y + (t1_s / 2);
    double x2_c = t2_x + (t2_s / 2);
    double y2_c = t2_y + (t2_s / 2);
    double d = Math.sqrt((x2_c-x1_c)*(x2_c-x1_c)+(y2_c - y1_c)*(y2_c - y1_c));
    double whs = ((t1_s/2) + (t2_s/2));
    if(d <= whs)
  　return true;
  else
  return false;
  }
}

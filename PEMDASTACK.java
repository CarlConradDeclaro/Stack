import java.util.Stack;
import java.util.Scanner;

public class Main
{  
   static int preceedence(char c){
        if(c == '+' || c == '-'){
                return 1;
        }else if(c == '*' || c == '/'){
            return 2;
        }
        return 0;
    }
    
  static int valueXY(char c, int x, int y){
      int v=0;
      switch(c){
          case '+':
              v= x+y;
             break;
          case '-':
             v= x-y;
             break;
         case '*':
              v= x*y;
              break;
          case'/':
             v= x/y;
             break;
      }
      return x;
  }    
    
    public static void main(String[] args) {

        Stack<Character> operator = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Input: ");
        String s = sc.nextLine();
        StringBuilder c = new StringBuilder();

         // "4+1*3+(1+2)"; 
       
        
        
        for(int i=0;i<s.length();i++){
               
               if(s.charAt(i) == '('){
                   operator.push(s.charAt(i));
               }else if(Character.isDigit(s.charAt(i)))
                   c.append(s.charAt(i));
                 
               if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' ){
                       while(!operator.isEmpty() && preceedence(s.charAt(i)) <= preceedence(operator.peek())){
                           c.append(operator.pop());
                       }
                          operator.push(s.charAt(i));
               }
          
               if(s.charAt(i) == ')'){
                    while(!operator.isEmpty() && operator.peek() != '(' ){
                        c.append(operator.pop());
                    }
                    if(!operator.isEmpty()  &&  operator.peek() ==  '('){
                        operator.pop();
                    }
               } 

        }
        
        while(!operator.isEmpty()){
            c.append(operator.pop());
        }
 
       String postFix = c.toString().trim();
       Stack<Integer> num = new Stack<>();
      
       for(int j=0; j<postFix.length();j++){
            while(Character.isDigit(postFix.charAt(j))){
                num.push(Character.getNumericValue(postFix.charAt(j)));
               j++;
            }
            if( j < postFix.length() ){
                  
                  int x1 = num.pop();
                  int x2 = num.pop();
                  
                  int result = valueXY( postFix.charAt(j),x2,x1);
                  num.push(result);
            }
       }
      System.out.println(num.pop());
  
    }
}

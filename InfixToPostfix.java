import java.util.*; 
public class InfixToPostfix
{
    static int preceedence(char r){
        switch (r) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }
    
    static boolean isOperator(char o){
        return o == '+' || o == '-' || o == '*' || o == '/';
    }
    
    static String convertToPostfix(String s){
        Stack<Character> operators = new Stack<>();
        StringBuilder operand = new StringBuilder();
        // 1+(2+2)
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isLetterOrDigit(c)){
                operand.append(c);
            }else if(c == '('){
                operators.add(c);
            }else if(isOperator(c)){
                while(!operators.isEmpty() && preceedence(operators.peek()) >= preceedence(c)){
                    operand.append(operators.pop());
                }
                operators.add(c);
            }else if( c == ')'){
                while(!operators.isEmpty() &&  operators.peek() != '('){
                    operand.append(operators.pop());
                }
                operators.pop();
            }
        }
        
        while(!operators.isEmpty())
           operand.append(operators.pop());
        
        return operand.toString();
    }

	public static void main(String[] args) {
	     System.out.println(convertToPostfix("a+b*(c*d-e)")); //
	}
}

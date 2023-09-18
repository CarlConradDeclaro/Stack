import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class PEMDASJavaScriptEngineJava{
       public static void main(String[] args) {
            String expression = "1+2*(1+2)";
            
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            
            try {
                Object result = engine.eval(expression);
                System.out.println("Result: " + result);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
    }
}
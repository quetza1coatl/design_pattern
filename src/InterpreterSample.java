import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InterpreterSample {
    public static void main(String[] args) {
        String exp = "a + b";
        Expression parse = parse(exp);
        Map<String, Integer> context = new HashMap<>();
        context.put("a", 4);
        context.put("b", 7);
        System.out.println(parse.interpret(context));
    }

    private static Expression parse(String exp) {
        ArrayDeque<Expression> stack = new ArrayDeque<>();
        Arrays.stream(exp.split(" "))
                .filter(token -> Character.isLetter(token.codePointAt(0)))
                .forEach(token -> stack.push(parseToken(token, stack)));
        Arrays.stream(exp.split(" "))
                .filter(token -> !Character.isLetter(token.codePointAt(0)))
                .forEach(token -> stack.push(parseToken(token, stack)));
        return stack.pop();
    }

    private static Expression parseToken(String token, ArrayDeque<Expression> stack) {
        Expression left, right;
        switch (token){
            case "+":
                right = stack.pop();
                left = stack.pop();
                return Expression.plus(left, right);
            case "-":
                right = stack.pop();
                left = stack.pop();
                return Expression.minus(left, right);
            default:
                return Expression.variable(token);
        }
    }
}

interface Expression{
    int interpret(Map<String, Integer> context);

    static Expression plus(Expression left, Expression right){
        return context -> left.interpret(context) + right.interpret(context);
    }

    static Expression minus(Expression left, Expression right){
        return context -> left.interpret(context) - right.interpret(context);
    }

    static Expression variable(String name){
        return context -> context.getOrDefault(name, 0);
    }
}

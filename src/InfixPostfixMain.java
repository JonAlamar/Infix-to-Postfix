public class InfixPostfixMain {

    static Queue infix = new Queue();
    static Queue postfix = new Queue();
    static Stack operatorStack = new Stack();
    static StackInt evalStack = new StackInt();

    public static void main(String[] args) {

        //String expression = "A+B/C*D-E-F+(G/H)";    // Comment out either of these
        String expression = "(5+3)*6*(7/2)+3-(4*7)";     // expressions to run program
        System.out.println("\n"+expression);
        loadInfix(expression);      // enqueues each character of expression
        System.out.println("\n****** Infix Queue ******");
        infix.traverse();           // prints out the infix queue
        conversion();               // converts infix to postfix using operator stack
        System.out.println("\n****** Postfix Queue ******");
        postfix.traverse();         // prints out the postfix expression

        if (expression.matches(".*\\d.*"))  // if expression contains numbers, evaluate postfix expression.
        {
            postfixEval();
        }
    }

    public static void conversion() {
        Node scan = infix.front;
        System.out.println("****** Infix to Postfix Conversion ******");
        while (scan != null) {
            if (Character.isLetterOrDigit(scan.getData())) {
                System.out.println("Add " + scan.getData() + " to postfix queue");
                postfix.enqueue(scan.getData());
            } else if (scan.getData() == '(') {
                System.out.println("Push " + scan.getData() + " to operator stack");
                operatorStack.push(scan.getData());
            } else if (scan.getData() == ')') {
                while (operatorStack.top() != '(') {
                    System.out.println("Pop " + operatorStack.top() + " to postfix queue");
                    postfix.enqueue(operatorStack.pop());
                }
                System.out.println("Pop " + operatorStack.top());
                operatorStack.pop();
            } else if (!operatorStack.empty() && (infixPriority(scan.getData()) <= infixPriority(operatorStack.top()))) {
                while (!operatorStack.empty() && (infixPriority(scan.getData()) <= infixPriority(operatorStack.top()))) {
                    System.out.println("Pop " + operatorStack.top() + " to postfix queue");
                    postfix.enqueue(operatorStack.pop());
                }
                System.out.println("Push " + scan.getData() + " to operator stack");
                operatorStack.push(scan.getData());
            } else {
                System.out.println("Push " + scan.getData() + " to operator stack");
                operatorStack.push(scan.getData());
            }
            scan = scan.getNext();
        }
        while (!operatorStack.empty()) {
            System.out.println("Pop " + operatorStack.top() + " to postfix");
            postfix.enqueue(operatorStack.pop());
        }
        System.out.println("****** End of Infix to Postfix Conversion ******");
    }

    public static void loadInfix(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            infix.enqueue(expression.charAt(i));
        }
    }

    public static int infixPriority(char i) {

        if (i == '+' || i == '-') {
            return 1;
        } else if (i == '*' || i == '/') {
            return 2;
        } else {
            return -1;
        }
    }

    public static void postfixEval() {
        Node scan = postfix.front;
        double temp;
        double first;
        double second;
        System.out.println("****** Postfix Evaluation ******");

        while (scan != null) {
            if (Character.isLetterOrDigit(scan.getData())) {
                temp = Integer.parseInt(String.valueOf((scan.getData())));
                evalStack.push(temp);
            } else if (scan.getData() == '+') {
                first = evalStack.pop();
                second = evalStack.pop();
                temp = first + second;
                evalStack.push(temp);
            } else if (scan.getData() == '-') {
                first = evalStack.pop();
                second = evalStack.pop();
                temp = second - first;
                evalStack.push(temp);
            } else if (scan.getData() == '*') {
                first = evalStack.pop();
                second = evalStack.pop();
                temp = first * second;
                evalStack.push(temp);
            } else if (scan.getData() == '/') {
                first = evalStack.pop();
                second = evalStack.pop();
                temp = second / first;
                evalStack.push(temp);
            }
            scan = scan.getNext();
        }
        System.out.println("The evaluated expression is: " + evalStack.top());
    }
}
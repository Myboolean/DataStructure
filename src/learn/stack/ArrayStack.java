package learn.stack;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/19
 * Time: 18:46
 */
public class ArrayStack <E> implements Stack<E>{
    Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }
    public ArrayStack() {
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E peek(E e) {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    // TODO: 2022/9/19

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append("Stack: ");
       res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
    public static boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;
        ArrayStack<Character> stack = new ArrayStack<Character>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if( c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if(c == ')'  && top != '('){
                    return false;
                }
                if(c == ']' && top != '[') return false;

                if(c == '}' && top != '{') return false;

            }
        }
        if(stack.getSize() > 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}

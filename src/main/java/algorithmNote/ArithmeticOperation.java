package algorithmNote;

/**
 * 实现算术运算
 */
public class ArithmeticOperation {
    public int add(int a, int b) {
        //a + b = a ^ b + (a & b) << 1
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public int multiply(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            b >>>= 1;
            a <<= 1;
        }
        return res;
    }

    public int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        //从30位开始递减右移a，当a>=b时右移i位，结果右数i位设置为1，a减去b左移i位的值
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if (x >> i >= y) {
                res |= 1 << i;
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == -1) return Integer.MAX_VALUE;
            //将a+1除以b得c，结果等于c+(a-b*c)/b
            int c = divide(add(a, 1), b);
            return add(c, divide(minus(a, multiply(b, c)), b));
        }
        return div(a, b);
    }

    public int negNum(int a) {
        return add(~a, 1);
    }

    public boolean isNeg(int a) {
        return a < 0;
    }
}
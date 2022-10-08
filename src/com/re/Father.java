package com.re;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/8
 * Time: 17:48
 */
public class Father {
    protected Object s() throws Exception{
        return null;
    }

}

class Son extends Father{
    @Override
    public Integer s() throws IOException {
        return 0;

    }
    BigInteger integer;
}

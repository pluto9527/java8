package com.jcfc.optional;

import com.jcfc.optional.entity.Man;
import com.jcfc.optional.entity.NewMan;
import com.jcfc.optional.entity.Women;
import org.junit.Test;

import java.util.Optional;

public class TestOptionEntity {

    @Test
    public void test2() {
        Optional<NewMan> man = Optional.ofNullable(null);
        String name2 = getWomenName2(man);
        System.out.println(name2);
    }
    private String getWomenName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())
                .getWomen()
                .orElse(new Women("没有女神"))
                .getName();

    }

    @Test
    public void test() {
        Man man = new Man();
        String name = getWomenName(man);
        System.out.println(name);
    }
    private String getWomenName(Man man) {
        if (man != null) {
            Women women = man.getWomen();
            if (women != null) {
                return women.getName();
            }
        }

        return "没有女神！";
    }

}

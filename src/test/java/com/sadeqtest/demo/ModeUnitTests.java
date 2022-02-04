package com.sadeqtest.demo;

import com.sadeqtest.demo.model3.ApplicationUser;
import org.junit.Assert;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;


public class ModeUnitTests {
    @Test
    public void testSet() throws CloneNotSupportedException {
        HashSet<ApplicationUser> applicationUserSet=new HashSet<>();
        HashMap<String,ApplicationUser> applicationUserHashMap=new HashMap<>();
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername("sadeq");
        applicationUser.setPassword("1234");
        System.out.println(applicationUserSet.add(applicationUser));
        applicationUserHashMap.put("one",applicationUser);
        Object clone = applicationUser.clone();
        applicationUser=(ApplicationUser)clone;
        applicationUser.setPassword("2345");
        applicationUser.setUsername("sahar");
        System.out.println(applicationUserSet.add(applicationUser));
        applicationUserHashMap.put("two",applicationUser);
        Object clone1 = applicationUser.clone();
        applicationUser=(ApplicationUser)clone1;
        applicationUser.setUsername("sadeq");
        applicationUser.setPassword("aaaa");

        Assumptions.assumeFalse(applicationUserSet.add(applicationUser));

        applicationUserHashMap.put("one",applicationUser);
        applicationUserSet.parallelStream().forEach(System.out::println);

        Assert.assertEquals(applicationUser.getPassword(),applicationUserHashMap.get("one").getPassword());
    }
    @Test
    void equalWithSelfObj() throws CloneNotSupportedException {
        HashSet<ApplicationUser> applicationUserSet=new LinkedHashSet<>();

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername("sadeq");
        applicationUser.setPassword("1234");
        System.out.println(applicationUserSet.add(applicationUser));

        Object clone = applicationUser.clone();
        applicationUser=(ApplicationUser)clone;
        applicationUser.setPassword("2345");
        applicationUser.setUsername("sahar");
        System.out.println(applicationUserSet.add(applicationUser));

//        Object clone1 = applicationUser.clone();
//        applicationUser=(ApplicationUser)clone1;
        applicationUser.setUsername("sadeqSafdari");
        applicationUser.setPassword("aaaa");

        Assumptions.assumeTrue(applicationUserSet.add(applicationUser));
        applicationUserSet.parallelStream().forEach(System.out::println);
    }
}

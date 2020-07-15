import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Period;
import java.util.HashSet;
import java.util.Set;

// This test using Set collection
public class EqualsWrapperTest {


    private class Person implements IcustomEquals{

        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
        @Override
        public int getCustomHashCode() {
            return name.length();
        }
    }
    private Person person = new Person(23, "bbbb");
    private Person person2 = new Person(20, "aaaa");
    private Person person3 = new Person(23, "blabal");
    private EqulasWrapper<Person> equlasWrapper =
            new EqulasWrapper<>(person, (p1, p2) -> p1.name.length() == p2.name.length());
    private Set<EqulasWrapper<Person>> wrapperSet = new HashSet<>();

    @Before
    public void before(){
        wrapperSet.clear();
        wrapperSet.add(equlasWrapper);
    }

    @Test
    public void contains(){
        Assert.assertTrue(wrapperSet.contains(equlasWrapper));
    }

    @Test
    public void add(){
        Assert.assertEquals(wrapperSet.size(), 1);
        EqulasWrapper<Person> equlasWrapper =
                new EqulasWrapper<>(person2, (p1, p2) -> p1.name.length() == p2.name.length());
        wrapperSet.add(equlasWrapper);
        Assert.assertEquals(wrapperSet.size(), 1);
        EqulasWrapper<Person> newEqulasWrapper =
                new EqulasWrapper<>(person3, (p1, p2) -> p1.name.length() == p2.name.length());
        wrapperSet.add(newEqulasWrapper);
        Assert.assertEquals(wrapperSet.size(), 2);
    }

    @Test
    public void remove(){
        Assert.assertEquals(wrapperSet.size(), 1);
        EqulasWrapper<Person> equlasWrapper =
                new EqulasWrapper<>(person2, (p1, p2) -> p1.name.length() == p2.name.length());
        wrapperSet.remove(equlasWrapper);
        Assert.assertEquals(wrapperSet.size(), 0);
    }



}

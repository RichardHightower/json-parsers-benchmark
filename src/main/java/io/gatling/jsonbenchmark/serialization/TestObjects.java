package io.gatling.jsonbenchmark.serialization;

import org.boon.Lists;
import org.boon.core.reflection.BeanUtils;
import org.boon.core.reflection.Reflection;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rick on 12/27/13.
 */
public class TestObjects {



    static final AllTypes OBJECT = new AllTypes ();

    static  {

        OBJECT.ingnoreMe = "THIS WILL NOT PASS";
        OBJECT.ignoreMe2 = "THIS WILL NOT PASS EITHER";
        OBJECT.ignoreMe3 = "THIS WILL NOT PASS TOO";
        OBJECT.setBigDecimal ( new BigDecimal ( "1.235678900" ) );
        OBJECT.setDate ( new Date () );
        OBJECT.setBar ( FooEnum.BAR );
        OBJECT.setFoo ( FooEnum.FOO );
        OBJECT.setString ( "Hi Mom" );
        OBJECT.setMyDouble ( 1.2345d );
        OBJECT.setMyFloat ( 1.0f );
        OBJECT.setMyShort ( (short)1 );
        OBJECT.setMyByte ( (byte)1 );

        AllTypes foo2 = BeanUtils.copy( OBJECT );
        OBJECT.setAllType ( foo2 );
        foo2.setString ( "Hi Dad" );
        OBJECT.setAllTypes ( Lists.list ( BeanUtils.copy ( foo2 ), BeanUtils.copy ( foo2 ) ) );
    }

}

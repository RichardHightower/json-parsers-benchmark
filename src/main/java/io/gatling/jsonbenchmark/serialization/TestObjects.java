package io.gatling.jsonbenchmark.serialization;

import data.media.MediaContent;
import io.gatling.jsonbenchmark.serialization.model.StringPerformance;
import org.boon.Lists;
import org.boon.core.reflection.BeanUtils;
import org.boon.core.reflection.Reflection;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.boon.Boon.toJson;

/**
 * Created by rick on 12/27/13.
 */
public class TestObjects {



    static final AllTypes OBJECT = new AllTypes ();


    static final MediaContent MEDIA_CONTENT = MediaContent.mediaContent();

    static final AllTypes BIG_OBJECT = new AllTypes ();


    static final StringPerformance STRING_PERF = new StringPerformance (1);


    static final String STRING_PERF_STRING = toJson(new StringPerformance (1));

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

        final List<AllTypes> list = Lists.list(OBJECT);
        BIG_OBJECT.setAllTypes(list);

        for (int index = 0; index < 10_000; index++) {
            AllTypes item = new AllTypes();

            item.ingnoreMe = "THIS WILL NOT PASS";
            item.ignoreMe2 = "THIS WILL NOT PASS EITHER";
            item.ignoreMe3 = "THIS WILL NOT PASS TOO";
            item.setBigDecimal ( new BigDecimal ( "1.235678900" ) );
            item.setDate ( new Date () );
            item.setBar ( FooEnum.BAR );
            item.setFoo ( FooEnum.FOO );
            item.setString ( "Hi Mom" + System.currentTimeMillis());
            item.setMyDouble ( 1.2345d );
            item.setMyFloat ( 1.0f );
            item.setMyShort ( (short)1 );
            item.setMyByte ( (byte)1 );

            list.add(item);
        }
    }

}
